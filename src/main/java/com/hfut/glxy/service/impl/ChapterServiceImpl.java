package com.hfut.glxy.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hfut.glxy.entity.Chapter;
import com.hfut.glxy.entity.Course;
import com.hfut.glxy.mapper.ChapterMapper;
import com.hfut.glxy.service.ChapterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date: Created in 15:54 2017/12/5
 * @Modified By:
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper,Chapter> implements ChapterService{
    //@Resource
    //private Course_ChapterMapper course_chapterMapper;
    @Resource
    private ChapterMapper chapterMapper;

    @Override
    public int addRelation(Course course, Chapter chapter) throws Exception{

        //String course_id="1";
        //String course_id=course.getId();
        //String chapter_id=chapter.getId();

        if(course==null&&chapter==null){
            throw new Exception("添加课程与章的参数有误");
        }

        try {
            int result=chapterMapper.addRelation(course.getId(),chapter.getId());

            if(result==1){
                return 1;
            }else if(result==0){
                //ResultUtil.insertError();
                return 0;
            }else {
                //ResultUtil.fail("添加失败");
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
            //ResultUtil.fail("添加失败");
        }
    }
}
