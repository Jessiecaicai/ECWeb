package com.hfut.glxy.service;

import com.baomidou.mybatisplus.service.IService;
import com.hfut.glxy.entity.Chapter;
import com.hfut.glxy.entity.Course;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date: Created in 15:58 2017/12/5
 * @Modified By:
 */
public interface ChapterService extends IService<Chapter>{
    /**
     * @Author: Jessiecaicai
     * @Description: 添加章节之后，添加该章节与课程之间的关联
     * @Date: 19:25 2017/12/26
     * @param:  * @param null
     */
    public int addRelation(Course course, Chapter chapter) throws Exception;
}
