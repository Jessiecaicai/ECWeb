/*
package com.hfut.glxy.dao;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Component;

*/
/**
 * ProjectName: Courses <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017/11/22 19:31 <br/>
 *
 * @author students_ManagementSchool
 * @since JDK 1.8
 *//*

@Mapper
@Component(value="teacher_courseDao")
public interface Teacher_CourseDao {


    */
/**
 *
 * @Date 2017/11/22 19:34
 * @author students_ManagementSchool
 * @param course_id
 * @param teacher_id
 * @return
 * @since JDK 1.8
 * @condition 给课程指定负责人（从教师中选）
 *//*

    @Insert("insert into teacher (teacher_id,course_id,createtime,updatetime,isDelete)" +
            " value (#{teacher_id},#{course_id},NOW(),NOW(),0)")
    Integer addRelation(@Param("teacher_id") String teacher_id,@Param("course_id") String course_id);


    */
/**
 *
 * @Date 2017/11/22 19:37
 * @author students_ManagementSchool
 * @param course_id
 * @param teacher_id
 * @return
 * @since JDK 1.8
 * @condition  将该关系彻底删除
 *//*

    @Delete("delete from teacher_course where teacher_id=#{teacher_id} and course_id=#{course_id}")
    Integer deleteRelation(@Param("teacher_id") String teacher_id,@Param("course_id") String course_id);


    */
/**
 *
 * @Date 2017/11/22 19:40
 * @author students_ManagementSchool
 * @param course_id
 * @param teacher_id
 * @return
 * @since JDK 1.8
 * @condition 将课程和该负责人解除关系
 *//*

    @Update("update teacher_course set isDelete=1 where teacher_id=#{teacher_id} and course_id=#{course_id}")
    Integer putToDustbin(@Param("teacher_id") String teacher_id,@Param("course_id") String course_id);


    */
/**
 *
 * @Date 2017/11/22 19:43
 * @author students_ManagementSchool
 * @param teacher_id
 * @param startPage
 * @param pageSize
 * @return
 * @since JDK 1.8
 * @condition 分页查询某老师负责的课程
 *//*

    @Select("select course_id from teacher_course where teacher_id=#{teacher_id}" +
            " and order by createtime desc limit #{startPage},#{pageSize}")
    String[] queryCourseByPage(@Param("teacher_id") String teacher_id,
                               @Param("startPage") Integer startPage,@Param("pageSize") Integer pageSize);

    */
/**
 *
 * @Date 2017/11/26 17:09
 * @author students_ManagementSchool
 * @param teacher_id
 * @return
 * @since JDK 1.8
 * @condition    在教师-课程关联表中，查询某教师是否还有课程（用于删除教师的校验）
 *//*

    @Select("select count(*) from teacher_course where teacher_id=#{teacher_id} and isDelete=0")
    Integer ifTeacherExists(@Param("teacher_id") String teacher_id);

}
*/
