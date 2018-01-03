/*package com.hfut.glxy.controller;

import com.hfut.glxy.dto.Result;
import com.hfut.glxy.entity.Course;
import com.hfut.glxy.entity.CourseGroup;
import com.hfut.glxy.entity.Manager;
import com.hfut.glxy.entity.Teacher;
import com.hfut.glxy.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.UUID;
*/
/**
 * ProjectName: Courses <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017/11/23 15:40 <br/>
 *
 * @author students_ManagementSchool
 * @since JDK 1.8
 *//*
@Controller
public class CourseController {

    @Resource
    private CourseService courseService;
*/
    /**
         *
         * @Date 2017/11/23 16:58
         * @author students_ManagementSchool
         * @param courseGroup
         * @param course
         * @param teacher
         * @param manager
         * @return
         * @since JDK 1.8
         * @condition 增加课程的校验过程以及数据传输过程（包括向数据库层传以及返回前台响应信息）
    *//*
    @ResponseBody
    @RequestMapping(value="/addCourse",method= RequestMethod.POST)
    public Result<String> addCourse(@RequestBody CourseGroup courseGroup, @RequestBody Course course,
                                    @RequestBody Teacher teacher, @RequestBody Manager manager){

        if (courseGroup.getId()==null){
            return new Result<String>(false,"没有指定课程组",null);
        }
        if (teacher.getId()==null){
            return new Result<String>(false,"没有指定负责教师",null);
        }
        if(manager.getAccount()==null){
            return new Result<String>(false,"没有指定管理员账号",null);
        }
        if (manager.getPassword()==null){
            return new Result<String>(false,"没有指定管理员密码",null);
        }
        if (course.getNumber()==null){
            return new Result<String>(false,"没有指定课程编号",null);
        }
        if (course.getName()==null){
            return new Result<String>(false,"没有指定课程名称",null);
        }
        if (course.getType()==null){
            return new Result<String>(false,"没有指定课程类型",null);
        }
        if (course.getCredit()==null){
            return new Result<String>(false,"没有指定课程学分",null);
        }
        if (course.getHours()==null){
            return new Result<String>(false,"没有指定课程学时",null);
        }

        course.setId(UUID.randomUUID().toString().replaceAll("-",""));
        manager.setId(UUID.randomUUID().toString().replaceAll("-",""));

        int success=courseService.addCourse(courseGroup,course,teacher,manager);
        if(success==0){
            return new Result<String>(false,"增加课程失败，未知错误",null);
        }else{
            return new Result<String>(true,"增加课程成功，请点击确定查看详细信息",null);
        }
    }


}
*/