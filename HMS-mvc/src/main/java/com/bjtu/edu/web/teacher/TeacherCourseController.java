package com.bjtu.edu.web.teacher;

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
 * @description: 课程相关操作类-教师界面
 * @author: wanShun
 * @create: 2022/12/1
 */
@Controller
@RequestMapping("/teacher")
public class TeacherCourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentCourseService studentCourseService;


    @RequestMapping(value = "/listCourseMap",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listCourseMap(HttpServletRequest request){
        //查询课程列表数据
        Map<String,Object> modelMap = new HashMap<>();
        long teacherId = (long) request.getSession().getAttribute("teacherId");
        List<Course> courseList = courseService.getCourseByTeacherId(teacherId);
        modelMap.put("success",true);
        modelMap.put("courseList",courseList);
        return modelMap;
    }


    @RequestMapping(value = "/getCourseById",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getCourseById(@RequestParam("courseId") Long courseId){
        Course course = courseService.getCourseById(courseId);
        Map<String,Object> modelMap = new HashMap<>();
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


    @RequestMapping(value = "/listStudentMapByCourseId",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listStudentMapByCourseId(@RequestParam("courseId") Long courseId){
        Map<String,Object> modelMap = new HashMap<>();
        List<StudentCourse> studentCourseList = studentCourseService.getStudentByCourseId(courseId);
        modelMap.put("success",true);
        modelMap.put("studentCourseList",studentCourseList);
        return modelMap;
    }
}
