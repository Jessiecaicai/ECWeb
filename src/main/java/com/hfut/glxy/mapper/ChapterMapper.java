package com.hfut.glxy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hfut.glxy.entity.Chapter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author: Jessiecaicai
 * @Description: 章的mapper映射
 * @Date: Created in 15:12 2017/12/5
 * @Modified By:
 */
@Component
public interface ChapterMapper extends BaseMapper<Chapter> {
    /**
     * @Author: Jessiecaicai
     * @Description: 增加课程与章节的关系
     * @Date: 18:38 2017/12/27
     * @param:  * @param null
     */
    @Insert("insert into course_chapter(course_id,chapter_id,create_time,update_time,is_delete)values(#{course_id},#{chapter_id},NOW(),NOW(),0)")
    Integer addRelation(@Param("course_id")  String course_id, @Param("chapter_id") String chapter_id);
}
