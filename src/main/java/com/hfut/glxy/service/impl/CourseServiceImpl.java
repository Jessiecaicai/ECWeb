/*package com.hfut.glxy.service.impl;

import com.hfut.glxy.dao.*;
import com.hfut.glxy.entity.Course;
import com.hfut.glxy.entity.CourseGroup;
import com.hfut.glxy.entity.Manager;
import com.hfut.glxy.entity.Teacher;
import com.hfut.glxy.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
*/
/**
 * ProjectName: Courses <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017/11/22 19:56 <br/>
 *
 * @author students_ManagementSchool
 * @since JDK 1.8
 *//*
@Service
public class CourseServiceImpl implements CourseService{

    @Resource
    private CourseDao courseDao;
    @Resource
    private ManagerDao managerDao;
    @Resource
    private CourseGroup_CourseDao courseGroup_courseDao;
    @Resource
    private Teacher_CourseDao teacher_courseDao;
    @Resource
    private Manager_CourseDao manager_courseDao;
*/
    /**
         *
         * @Date 2017/11/23 15:17
         * @author students_ManagementSchool
         * @param course
         * @param courseGroup
         * @param teacher
         * @param manager
         * @return
         * @since JDK 1.8
         * @condition 增加课程，并进行事务管理，因为在此添加过程中，涉及到对多个表的操作，必须保证事务的完整性和一致性
    *//*
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 36000,noRollbackFor = Exception.class)
    public int addCourse(CourseGroup courseGroup, Course course, Teacher teacher, Manager manager){

        int addCourseSuccess;
        int addManagerSuccess;
        int addCourseGroup_courseSuccess;
        int addTeacher_courseSuccess;
        int addManager_courseSuccess;

        //将课程添加到课程表
        addCourseSuccess=courseDao.addCourse(course);
        //将给课程指定的管理员增加到管理员表
        addManagerSuccess=managerDao.addManager(manager);
        //将课程组与课程建立关联并增加到相应的关联表
        addCourseGroup_courseSuccess=courseGroup_courseDao.addRelation(courseGroup,course);
        //将教师与课程建立关联并增加到相应的关联表
        addTeacher_courseSuccess=teacher_courseDao.addRelation(teacher.getId(),course.getId());
        //将管理员与课程建立关联并增加到相应的关联表
        addManager_courseSuccess=manager_courseDao.addRelation(manager.getId(),course.getId());

        if(addCourseGroup_courseSuccess==1&&addManager_courseSuccess==1&&addTeacher_courseSuccess==1&&
                addCourseSuccess==1&&addManagerSuccess==1){
            return 1;
        }else{
            return 0;
        }
    }

}*/
