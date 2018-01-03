/*
 * ProjectName: courses <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年11月21日 <br/>
 *
 * @author students_ManagementSchool
 * @version
 * @since JDK 1.8
 */
/*
package com.hfut.glxy.dao;

import com.hfut.glxy.dao.dynamicSQLProvider.DynamicSQLProvider;
import com.hfut.glxy.entity.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value="courseDao")
public interface CourseDao {

*/
    /**   
         * 
         * @Date 2017/11/22 11:22 
         * @author students_ManagementSchool
         * @param course
         * @return
         * @since JDK 1.8
         * @condition  增加课程
    *//*
    @Insert("insert ignore into course (id,number,name,type,introduction," +
            "credit,hours,createtime,updatetime,isDelete) values (#{course.id}," +
            "#{course.number},#{course.name},#{course.type},#{course.introduction}," +
            "#{course.credit},#{course.hours},NOW(),NOW(),#{course.isDelete})")
    Integer addCourse(@Param("course") Course course);
*/
    /**
     *
     * @author students_ManagementSchool
     * @param course
     * @return
     * @since JDK 1.8
     * @condition 更新课程（包括将课程放入回收站，也要调用该方法，其中isDelete设为1）
     *//*
    @UpdateProvider(type= DynamicSQLProvider.class,method = "updateCourse")
    Integer updateCourse(Course course);
*/
    /**
         *
         * @Date 2017/11/22 11:23
         * @author students_ManagementSchool
         * @param id
         * @return
         * @since JDK 1.8
         * @condition  按id删除课程
    *//*
    @Delete("delete from course where id=#{id}")
    Integer deleteCourseById(@Param("id") String id);

*/
    /**
         *
         * @Date 2017/11/22 14:11
         * @author students_ManagementSchool
         * @param id
         * @return
         * @since JDK 1.8
         * @condition  按id查找课程
    *//*
    @Select("select * from course where id=#{id}")
    Course queryCourseById(@Param("id") String id);

*/
    /**
         *
         * @Date 2017/11/22 14:15
         * @author students_ManagementSchool
         * @param startPage
         * @param pageSize
         * @return
         * @since JDK 1.8
         * @condition 分页查询课程
    *//*
    @Select("select * from course order by createtime desc limit #{startPage},#{pageSize}")
    List<Course> queryCourseByPage(@Param("startPage") Integer startPage,@Param("pageSize") Integer pageSize);

*/
    /**
         *
         * @Date 2017/11/22 14:18
         * @author students_ManagementSchool
         * @param null
         * @return
         * @since JDK 1.8
         * @condition  查询课程总数
    *//*
    @Select("select count(*) from course")
    Integer getCourseTotalCount();

}
*/