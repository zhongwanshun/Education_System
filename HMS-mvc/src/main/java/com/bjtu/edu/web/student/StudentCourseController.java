package com.bjtu.edu.web.student;

import com.bjtu.edu.entity.Course;
import com.bjtu.edu.entity.StudentCourse;
import com.bjtu.edu.service.CourseService;
import com.bjtu.edu.service.StudentCourseService;
import com.bjtu.edu.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: mvc
 * @description: 课程相关操作类-学生界面
 * @author: wanShun
 * @create: 2022/12/1
 */
@Controller
@RequestMapping("/student")
public class StudentCourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentCourseService studentCourseService;


    @RequestMapping(value = "/listCourseMap",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listCourseMap(HttpServletRequest request){
        //查询课程列表数据
        Map<String,Object> modelMap = new HashMap<>();
        long studentId = (long) request.getSession().getAttribute("studentId");
        List<StudentCourse> studentCourseList = studentCourseService.getStudentCourseByStudentId(studentId);
        modelMap.put("success",true);
        modelMap.put("studentCourseList",studentCourseList);
        return modelMap;
    }


    @RequestMapping(value = "/getCourseById",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getCourseById(@RequestParam("courseId") Long courseId,HttpServletRequest request){
        //查询课程列表数据
        Map<String,Object> modelMap = new HashMap<>();
        Course course = courseService.getCourseById(courseId);
        modelMap.put("success",true);
        modelMap.put("course",course);
        return modelMap;
    }


    @RequestMapping(value = "/listStudentByCourseId",method = RequestMethod.GET)
    @ResponseBody
    private Layui listStudentByCourseId(@RequestParam("courseId") Long courseId){
        List<StudentCourse> studentCourseList = studentCourseService.getStudentByCourseId(courseId);
        return Layui.data(studentCourseList.size(),studentCourseList);
    }
}
