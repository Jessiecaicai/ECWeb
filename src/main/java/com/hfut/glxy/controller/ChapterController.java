package com.hfut.glxy.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hfut.glxy.dto.Result;
import com.hfut.glxy.entity.Chapter;
import com.hfut.glxy.entity.Course;
import com.hfut.glxy.relation.Chapter_KnowledgePoint;
import com.hfut.glxy.relation.Course_Chapter;
import com.hfut.glxy.service.ChapterService;
import com.hfut.glxy.service.Chapter_KnowledgePointService;
import com.hfut.glxy.utils.MapToObjectUtils;
import com.hfut.glxy.utils.ResultUtil;
import org.apache.ibatis.session.SqlSession;
import org.hibernate.validator.constraints.ModCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date: Created in 17:21 2017/12/5
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/chapter")
public class ChapterController {

    private ChapterService chapterService;
    private Chapter_KnowledgePointService chapter_knowledgePointService;
    //@Resource
    //private Course_ChapterService course_chapterService;

    @Autowired
    protected ChapterController(ChapterService chapterService){
        this.chapterService=chapterService;
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 根据课程分页章的列表 ...自己写sql
     * @Date: 21:02 2017/12/5
     * @param:  * @param null
     */
    @GetMapping("/{pageNum}")
    public Result listChapters(@PathVariable(value = "pageNum",required = false)int pageNum, HttpSession session){
        String courseId=(String)session.getAttribute("courseid");
        if(pageNum<=0){
            pageNum=1;
        }
        try{
            Page<Chapter> page=chapterService.selectPage(new Page<>(pageNum,4),
                    new EntityWrapper<Chapter>()
                            .eq("is_delete",0)
                            .eq("id",courseId));
            return ResultUtil.success(page);
        }catch(Exception e){
            e.printStackTrace();
            return ResultUtil.selectError();
        }
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 单个删除章 加上删除该章与其关联点之间的关系，加上事务管理 待解决
     * @Date: 21:02 2017/12/5
     * @param:  * @param null
     */
    @DeleteMapping("/{id}")
    @Transactional//添加事务管理成功
    public Result removeChapter(@PathVariable("id") String id ){
        try{
            if(id!=null&&id!="0") {
                //删除章
                Chapter chapter = new Chapter();
                chapter.setId(id);
                chapter.setIsDelete(1);
                ArrayList<Chapter_KnowledgePoint> chapter_knowledgePointList = new ArrayList<Chapter_KnowledgePoint>();
                //if(chapter_knowledgePointList!=null&&chapter_knowledgePointList.size()>0) {
                    chapter_knowledgePointList.forEach(it -> {
                        Chapter_KnowledgePoint chapter_knowledgePoint = new Chapter_KnowledgePoint();
                        chapter_knowledgePoint.setChapter_id(id);
                        chapter_knowledgePoint.setIsDelete(1);
                        chapter_knowledgePointList.add(chapter_knowledgePoint);
                    });
                //}
                if (chapterService.updateById(chapter)&&chapter_knowledgePointService.updateBatchById(chapter_knowledgePointList) ){
                    return ResultUtil.success("删除章成功以及删除章与对应知识点关联成功", null);
                } else {
                    return ResultUtil.fail("id为空或格式不正确");
                }
                //删除章和知识点的关系


                //List<String> list= JSONObject.parseArray(map.get("ids").toString(),String.class);

                    //List<Chapter_KnowledgePoint> chapter_knowledgePointList = new ArrayList<>(list.size());

                    //chapter_knowledgePointList.add();
                    //if (chapter_knowledgePointService.updateBatchById(chapter_knowledgePointList)) {
                    //    return ResultUtil.success("删除该章对应知识点关联成功", null);
                    //} else {
                    //    return ResultUtil.fail("id为空或格式不正确");
                    //}

            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ResultUtil.deleteError();
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 批量删除章 然后要批量解除章和课程关联表的关系，还没完成
     * {
     *     "ids":
     *     ["1","2"]
     * }
     * @Date: 21:44 2017/12/5
     * @param:  * @param null
     */
    @DeleteMapping("/batch")
    @Transactional
    public Result removeChapters(@RequestBody Map<String,Object> map){
        List<String> list= JSONObject.parseArray(map.get("ids").toString(),String.class);
System.out.print(list);
        try{
            if(list!=null&&list.size()>0){
                List<Chapter> chapterList=new ArrayList<>(list.size());

                list.forEach(it->{
                    Chapter chapter=new Chapter();
                    chapter.setId(it);
                    chapter.setIsDelete(1);
                    chapterList.add(chapter);
                });
                if(chapterService.updateBatchById(chapterList)){
                    return ResultUtil.success("批量删除作业成功",null);
                }
            }else{
                return ResultUtil.dataError();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.deleteError();
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 更新章 ok 实际更新的时候id和创造时间不进行更新
     * @Date: 22:21 2017/12/5
     * @param:  * @param null
     */

    @PutMapping
    @Transactional
    public Result updateChapter(@RequestBody Chapter chapter){
        try{
            if(chapterService.updateById(chapter)){
                return ResultUtil.OK();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.updateError();
    }

    ///**
    // * @Author: Jessiecaicai
    // * @Description: 增加章节的方法之三，都用MP方法解决,过多关联类，放弃
    // * {
    //"courseId":"22",
    //"chapter_number":"11",
    //"chapter_name":"11"
    //}
    // * @Date: 17:55 2017/12/28
    // * @param:  * @param null
    // */
    //@PostMapping(value = "/addChapterOne")
    //@Transactional
    ////添加表单验证
    //public Result insertChapterThree(@RequestBody Map<String,Object> map,HttpSession session){
    //    Chapter chapter=new Chapter();
    //    Course_Chapter course_chapter=new Course_Chapter();
    //    course_chapter.setCourse_id((String)map.get("courseId"));
    //    //course_chapter.setChapter_id((String) session.getAttribute("chapterId"));
    //    course_chapter.setChapter_id("111");
    //    chapter.setNumber((String) map.get("chapter_number"));
    //    chapter.setName((String)map.get("chapter_name"));
    //    try {
    //        if (chapterService.insert(chapter) && (course_chapterService.insert(course_chapter))) {
    //
    //            return ResultUtil.OK();
    //        }
    //    }catch(Exception e){
    //        e.printStackTrace();
    //        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    //    }
    //    return ResultUtil.fail("增加新的章失败");
    //}
    /**
     * @Author: Jessiecaicai
     * @Description: 增加章节的方法之一,ok
     * {
    "courseId":"22",
    "chapter_number":"11",
    "chapter_name":"11"
    }
     * @Date: 17:55 2017/12/28
     * @param:  * @param null
     */
    @PostMapping(value = "/addChapterOne")
    @Transactional
    //添加表单验证
    public Result insertChapterTwo(@RequestBody Map<String,Object> map){
        //Course course=new Course();
        //course.setId(chapter.getCourseId());
        //if(result.hasErrors()){
        //    return ResultUtil.fail(result.getAllErrors().toString());
        //}
        //String courseId=(String)session.getAttribute("courseid");
        Course course=new Course();
        Chapter chapter=new Chapter();
        course.setId((String)map.get("courseId"));
        chapter.setNumber((String) map.get("chapter_number"));
        chapter.setName((String)map.get("chapter_name"));
        try {
            //Chapter chapter=(Chapter) MapToObjectUtils.mapToBean(map.get(0), Chapter.class);
            //
            //Course_Chapter course_chapter=(Course_Chapter) MapToObjectUtils.mapToBean(map.get(1), Course_Chapter.class);

            if (chapterService.insert(chapter) && (chapterService.addRelation(course,chapter))==1) {

                return ResultUtil.OK();
            }
        }catch(Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ResultUtil.fail("增加新的章失败");
    }


    /**
     * @Author: Jessiecaicai
     * @Description: 增加章方法之二 前端格式如下： ok
    [
    {
    "name": "string",
    "number": "string"
    },
    {
    "id": "333"
    }
    ]

     * @Date: 15:50 2017/12/7
     * @param:  * @param null
     */

    @PostMapping(value = "/addChapterTwo")
    @Transactional
    //添加表单验证
    public Result insertChapter(@RequestBody List<Map<String,Object>> mapList){
        //Course course=new Course();
        //course.setId(chapter.getCourseId());
        //if(result.hasErrors()){
        //    return ResultUtil.fail(result.getAllErrors().toString());
        //}

        try {
            Chapter chapter=(Chapter) MapToObjectUtils.mapToBean(mapList.get(0), Chapter.class);

            Course course=(Course) MapToObjectUtils.mapToBean(mapList.get(1), Course.class);
            if (chapterService.insert(chapter) && (chapterService.addRelation(course, chapter) == 1)) {

                return ResultUtil.OK();
            }
        }catch(Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ResultUtil.fail("增加新的章失败");
    }

    //class Param{
    //     public Course course;
    //     public Chapter chapter;
    //
    //    public Course getCourse() {
    //        return course;
    //    }
    //
    //    public void setCourse(Course course) {
    //        this.course = course;
    //    }
    //
    //    public Chapter getChapter() {
    //        return chapter;
    //    }
    //
    //    public void setChapter(Chapter chapter) {
    //        this.chapter = chapter;
    //    }
    //
    //    public Param() {
    //    }
    //}

}
