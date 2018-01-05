package com.hfut.glxy.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hfut.glxy.dto.Result;
import com.hfut.glxy.entity.Chapter;
import com.hfut.glxy.entity.Course;
import com.hfut.glxy.entity.KnowledgePoint;
import com.hfut.glxy.entity.Unit;
import com.hfut.glxy.relation.Chapter_KnowledgePoint;
import com.hfut.glxy.service.ChapterService;
import com.hfut.glxy.service.Chapter_KnowledgePointService;
import com.hfut.glxy.service.KnowledgePointService;
import com.hfut.glxy.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.smartcardio.TerminalFactory;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author: Jessiecaicai
 * @Description: 知识点管理是在教学单元管理下的，教学单元下会有相应知识点的管理。
 *               并且章处能显示该章所有的知识点，然后点击知识点弹出包含有该知识点对应的教学单元任用户选中。
 *               知识点和教学单元是多对多的关系；
 * @Date: Created in 16:16 2017/12/7
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/knowledgePoint")
public class KnowledgePointController {

    private Chapter_KnowledgePointService chapter_knowledgePointService;
    private KnowledgePointService knowledgePointService;

    @Autowired
    protected KnowledgePointController(KnowledgePointService knowledgePointService) {
        this.knowledgePointService=knowledgePointService;
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 增加教学单元与知识点之间的关联
     * {
    "unitId":"22",
    "knowledgePointId":"11"
    }
     * @Date: 21:16 2018/1/3
     * @param:  * @param null
     */
    @PostMapping(value = "/addUnitKnowledgePointRelation")
    @Transactional
    public Result addUnitKnowledgePointRelation(@RequestBody Map<String,Object> map){
        Unit unit=new Unit();
        KnowledgePoint knowledgePoint=new KnowledgePoint();
        unit.setId((String)map.get("unitId"));
        knowledgePoint.setId((String)map.get("knowledgePointId"));
        try{
            if (knowledgePointService.addUnitKnowledgePointRelation(unit,knowledgePoint)==1){
                return ResultUtil.OK();
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ResultUtil.fail("添加教学单元和知识点的关联失败");
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 根据章分页知识点 pageNum表示当前页码 ok
     * @Date: 20:10 2017/12/17
     * @param:  * @param null
     */
    @GetMapping("/{pageNum}")
    public Result listKnowledgePointsByChapter(@PathVariable(value="pageNum",required = false)int pageNum, HttpSession session){
        String chapterId=(String)session.getAttribute("chapterId");
        if(pageNum<=0){
            pageNum=1;
        }
        try{
            Page<KnowledgePoint> page=knowledgePointService.selectPage(new Page<>(pageNum,4),
                    new EntityWrapper<KnowledgePoint>()
            .eq("is_delete",0)
            .eq("id",chapterId));
            return ResultUtil.success(page);
        }catch(Exception e){
            e.printStackTrace();
            return ResultUtil.selectError();
        }
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 知识点分页1  size 一页显示数量  current 当前页码 选出 is_delete 为0的所有知识点分页方法
     *               仅仅是全部知识点的分页 ok indeed
     * @Date: 21:22 2017/12/25
     * @param:  * @param null
     */
    @GetMapping("/page")
    public Result pageKnowledgePoints2(Page<KnowledgePoint> page){
        try{
            page=knowledgePointService.selectPage(page,new EntityWrapper<KnowledgePoint>()
            .eq("is_delete",0));
            return ResultUtil.success(page);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.selectError();
        }

    }

    /**
     * @Author: Jessiecaicai
     * @Description: 知识点按章节提取 ok
     * @Date: 16:59 2018/1/4
     * @param:  * @param null
     */
    @PostMapping("/listKnowledgePointByChapter")
    public Result<List<KnowledgePoint>> listKnowledgePointByChapter(@RequestParam("chapter_id") String chapterId){
        //Chapter chapter=new Chapter();
        //KnowledgePoint knowledgePoint=new KnowledgePoint();
        //chapter.setId((String)map.get("chapterId"));
        try {
            List<KnowledgePoint> list=knowledgePointService.listKnowledgePointByChapter(chapterId);
            if (list!=null){
                return ResultUtil.success(list);
            }else {
                return ResultUtil.fail("在该章中，暂无相关联知识点");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.selectError();
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 知识点按课程选取 无对应课程时，不执行fail方法
     * @Date: 17:23 2018/1/5
     * @param:  * @param null
     */
    @PostMapping("/listKnowledgePointByCourse")
    public Result<List<KnowledgePoint>> listKnowledgePointByCourse(@RequestParam("course_id")String courseId){
        try{
            List<KnowledgePoint> list=knowledgePointService.listKnowledgePointByCourse(courseId);
            if(list!=null){
                return ResultUtil.success(list);
            }else{
                return ResultUtil.fail("在该课程中，暂无相关联知识点");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.selectError();
        }
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 列出该知识点对应的所有教学单元，是在同一个章里的 ok
     * @Date: 21:37 2018/1/4
     * @param:  * @param null
     */
    @PostMapping("/listUnitByKnowledgePointSameChapter")
    public Result<List<Unit>> listUnitByKnowledgePointSameChapter(@RequestParam("chapter_id")String chapterId,@RequestParam("knowledge_point_id")String knowledgePointId){
        try {
            Chapter chapter=new Chapter();
            KnowledgePoint knowledgePoint=new KnowledgePoint();
            chapter.setId(chapterId);
            knowledgePoint.setId(knowledgePointId);
            List<Unit> list=knowledgePointService.listUnitByKnowledgePointSameChapter(chapter,knowledgePoint);
            if (list!=null){
                return ResultUtil.success(list);
            }else {
                return ResultUtil.fail("在该章中，该知识点暂时无相应课程章节对应");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.selectError();
    }
    /**
     * @Author: Jessiecaicai
     * @Description: 列出该知识点对应的所有教学单元，是在同一门课程里的 ok
     *                  取出的为空时，不进行fail方法？
     * @Date: 16:00 2018/1/5
     * @param:  * @param null
     */
    @PostMapping("/listUnitByKnowledgePointSameCourse")
    public Result<List<Unit>> listUnitByKnowledgePointSameCourse(@RequestParam("knowledge_point_id")String knowledgePointId,@RequestParam("course_id")String courseId){
        try {
            Course course=new Course();
            KnowledgePoint knowledgePoint=new KnowledgePoint();
            course.setId(courseId);
            knowledgePoint.setId(knowledgePointId);
            List<Unit> list=knowledgePointService.listUnitByKnowledgePointSameCourse(knowledgePoint,course);
            if(list!=null){
                return ResultUtil.success(list);
            }else {
                return ResultUtil.fail("在本课程中，该知识点暂时无相应课程章节对应");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.selectError();
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 更新知识点 ok
     * @Date: 20:17 2017/12/17
     * @param:  * @param null
     */
    @PutMapping
    public Result updateKnowledgePoint(@RequestBody KnowledgePoint knowledgePoint){
        try{
            if(knowledgePointService.updateById(knowledgePoint)){
                return ResultUtil.OK();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResultUtil.updateError();
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 增加知识点 ok
     * @Date: 20:19 2017/12/17
     * @param:  * @param null
     */
    @PostMapping
    public Result insertKnowledgePoint(@RequestBody @Valid KnowledgePoint knowledgePoint, BindingResult result){
        if(result.hasErrors()){
            return ResultUtil.fail(result.getAllErrors().toString());
        }
        try{
            if(knowledgePointService.insert(knowledgePoint)) {
                return ResultUtil.OK();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.success("success",knowledgePoint);
    }
}
