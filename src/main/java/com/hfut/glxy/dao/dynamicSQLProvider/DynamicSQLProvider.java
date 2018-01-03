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
package com.hfut.glxy.dao.dynamicSQLProvider;

import com.hfut.glxy.entity.Course;
import com.hfut.glxy.entity.CourseGroup;
import com.hfut.glxy.entity.Manager;
import com.hfut.glxy.entity.Teacher;
import com.hfut.glxy.entity.Unit;
import com.hfut.glxy.entity.*;
import org.apache.ibatis.jdbc.SQL;

public class DynamicSQLProvider {


    *//**
         *
         * @Date 2017/11/22 14:22
         * @author students_ManagementSchool
         * @param course
         * @return
         * @since JDK 1.8
         * @condition 对课程的动态更新语句
    */
    /*
    public String updateCourse(Course course){
        return new SQL(){
            {
                UPDATE("course");
                if(course.getNumber()!=null){
                    SET("number=#{course.number}");
                }
                if(course.getName()!=null){
                    SET("name=#{course.name}");
                }
                if (course.getType()!=null){
                    SET("type=#{course.type}");
                }
                if (course.getIntroduction()!=null){
                    SET("introduction=#{course.introduction}");
                }
                if (course.getCredit()!=null){
                    SET("credit=#{course.credit}");
                }
                if (course.getHours()!=null){
                    SET("hours=#{course.hours}");
                }
                if (course.getIsDelete()!=0){
                    SET("isDelete=#{course.isDelete}");
                }
                SET("updateTime=NOW()");
                WHERE("id=#{course.id}");
            }
        }.toString();
    }
    */
    /**
         *
         * @Date 2017/11/22 14:33
         * @author students_ManagementSchool
         * @param courseGroup
         * @return
         * @since JDK 1.8
         * @condition  对课程组的动态更新语句
    */
    /*
    public String updateCourseGroup(CourseGroup courseGroup){
        return new SQL(){
            {
                UPDATE("coursegroup");
                if(courseGroup.getNumber()!=null){
                    SET("number=#{courseGroup.number}");
                }
                if(courseGroup.getName()!=null) {
                    SET("name=#{courseGroup.name}");
                }
                if (courseGroup.getIntroduction()!=null) {
                    SET("introduction=#{courseGroup.introduction}");
                }
                if (courseGroup.getIsDelete()!=0){
                    SET("isDelete=#{courseGroup.isDelete}");
                }
                SET("updateTime=NOW()");
                WHERE("id=#{courseGroup.id}");
            }
        }.toString();
    }
    */
    /**
         *
         * @Date 2017/11/22 14:51
         * @author students_ManagementSchool
         * @param teacher
         * @return
         * @since JDK 1.8
         * @condition  对教师的动态更新语句
    */
    /*
    public String updateTeacher(Teacher teacher){
        return new SQL(){
            {
                UPDATE("teacher");
                if(teacher.getNumber()!=null){
                    SET("number=#{teacher.number}");
                }
                if(teacher.getName()!=null) {
                    SET("name=#{teacher.name}");
                }
                if (teacher.getSex()!=null) {
                    SET("sex=#{teacher.sex}");
                }
                if (teacher.getPosition()!=null) {
                    SET("position=#{teacher.position}");
                }
                if (teacher.getPersonIntroduction()!=null) {
                    SET("personIntroduction=#{teacher.personIntroduction}");
                }
                if (teacher.getIsDelete()!=0){
                    SET("isDelete=#{teacher.isDelete}");
                }
                SET("updateTime=NOW()");
                WHERE("id=#{teacher.id}");
            }
        }.toString();
    }

    public String updateManager(Manager manager){
        return new SQL(){
            {
                UPDATE("manager");
                if(manager.getAccount()!=null){
                    SET("account=#{manager.account}");
                }
                if(manager.getPassword()!=null) {
                    SET("password=#{manager.password}");
                }
                if (manager.getIsSuper()!=0) {
                    SET("issuper=#{manager.isSuper}");
                }
                if (manager.getIsDelete()!=0){
                    SET("isDelete=#{manager.isDelete}");
                }
                SET("updateTime=NOW()");
                WHERE("id=#{manager.id}");
            }
        }.toString();
    }
    */
    /**
     * @Author: Jessiecaicai
     * @Description: 对章的更新操作
     * @Date: 20:37 2017/11/26
     * @param:  * @param null
     */
    /*
    public String updateUnit(Unit unit){
        return new SQL(){
            {
                UPDATE("unit");
                if(unit.getNumber()!=null){
                    SET("number=#{unit.number}");
                }
                if(unit.getName()!=null) {
                    SET("name=#{unit.name}");
                }
                if (unit.getContent()!=null) {
                    SET("content=#{unit.content}");
                }
                if (unit.getIsDelete()!=0){
                    SET("isDelete=#{unit.isDelete}");
                }
                SET("updateTime=NOW()");
                WHERE("id=#{unit.id}");
            }
        }.toString();
    }
    */
    /**
     * @Author: Jessiecaicai
     * @Description: 对知识点的更新操作
     * @Date: 20:46 2017/11/26
     * @param:  * @param null
     */
    /*
    public String updateKnowledgePoint(KnowledgePoint knowledgePoint){
        return new SQL(){
            {
                UPDATE("knowledgepoint");
                if(knowledgePoint.getContent()!=null){
                    SET("content=#{knowledgePoint.content}");
                }
                if (knowledgePoint.getIsDelete()!=0){
                    SET("isDelete=#{knowledgePoint.isDelete}");
                }
                SET("updateTime=NOW()");
                WHERE("id=#{knowledgePoint.id}");
            }
        }.toString();
    }
}
*/