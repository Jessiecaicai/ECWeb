/*package com.hfut.glxy.dao;

import com.hfut.glxy.entity.Course;
import com.hfut.glxy.entity.CourseGroup;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
*/
/**
 * ProjectName: Courses <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017/11/22 15:37 <br/>
 *
 * @author students_ManagementSchool
 * @since JDK 1.8
 */
/*
@Mapper
@Component(value="courseGroup_courseDao")
public interface CourseGroup_CourseDao {
*/
    /**   
         * 
         * @Date 2017/11/22 15:44 
         * @author students_ManagementSchool
         * @param courseGroup
         * @param course
         * @return
         * @since JDK 1.8
         * @condition 将课程添加到课程组
    *//*
    @Insert("insert into coursegroup_course (coursegroup_id,course_id,createtime,updatetime,isDelete)" +
            " values (#{courseGroup.id},#{course.id},NOW(),NOW(),0)")
    Integer addRelation(@Param("courseGroup") CourseGroup courseGroup,@Param("course") Course course);
*/
    /**
         *
         * @Date 2017/11/22 15:48
         * @author students_ManagementSchool
         * @param course_id
         * @param coursegroup_id
         * @return
         * @since JDK 1.8
         * @condition  将课程彻底删除
    *//*
    @Delete("delete from coursegroup_course where course_id=#{course_id} and coursegroup_id=#{coursegroup_id}")
    Integer deleteRelation(@Param("course_id") String course_id,@Param("coursegroup_id") String coursegroup_id);
*/
   /* @UpdateProvider(type="DynamicSQLProvider_Relation.class",name="");*/

   /**   
        * 
        * @Date 2017/11/22 16:16
        * @author students_ManagementSchool
        * @param coursegroup_id
        * @param course_id
        * @return
        * @since JDK 1.8
        * @condition  将课程从课程组中删除
   *//*
   @Update("update coursegroup_course set isDelete=1 where " +
           "coursegroup_id=#{coursegroup_id} and course_id=#{course_id}")
    Integer putToDustbin(@Param("coursegroup_id") String coursegroup_id,@Param("course_id") String course_id);
*/
   /**
        *
        * @Date 2017/11/22 16:25
        * @author students_ManagementSchool
        * @param coursegroup_id
        * @param startPage
        * @param pageSize
        * @return
        * @since JDK 1.8
        * @condition  分页查询属于某一课程组的课程
   *//*
   @Select("select course_id from coursegroup_course where coursegroup_id=#{coursegroup_id}" +
           " and order by createtime desc limit #{startPage},#{pageSize}")
    String[] queryCourseByPage(@Param("coursegroup_id") String coursegroup_id,
           @Param("startPage") Integer startPage,@Param("pageSize") Integer pageSize);

}
*/