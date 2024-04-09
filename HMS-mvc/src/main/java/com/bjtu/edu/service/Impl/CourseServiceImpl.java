package com.bjtu.edu.service.Impl;

import com.bjtu.edu.dao.CourseDao;
import com.bjtu.edu.dto.CourseExecution;
import com.bjtu.edu.entity.Course;
import com.bjtu.edu.enums.CourseStateEnum;
import com.bjtu.edu.exception.CourseOperationException;
import com.bjtu.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @project: mvc
 * @description: CourseService实现类
 * @author: wanShun
 * @create: 2022/11/30
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;


    @Override
    public List<Course> getCourseList() {
        return courseDao.queryCourse();
    }


    @Override
    public Course getCourseById(long courseId) {
        return courseDao.queryCourseById(courseId);
    }


    @Override
    public List<Course> getCourseByTeacherId(long teacherId) {
        return courseDao.queryCourseByTeacherId(teacherId);
    }


    @Override
    public CourseExecution addCourse(Course course) {
        //空值判断
        if (course == null){
            return new CourseExecution(CourseStateEnum.EMPTY);
        }
        //设置创建时间
        course.setCreateTime(new Date());
        //添加课程信息
        int effectedNum = courseDao.addCourse(course);
        //判断是否添加成功
        if (effectedNum <= 0){
            throw new CourseOperationException("添加课程信息失败");
        }
        return new CourseExecution(CourseStateEnum.SUCCESS,course);
    }


    @Override
    public CourseExecution modifyCourse(Course course) {
        //空值判断
        if (course == null || course.getCourseId() == null){
            return new CourseExecution(CourseStateEnum.EMPTY);
        }
        //设置更新时间
        course.setLastEditTime(new Date());
        //修改课程信息
        int effectedNum = courseDao.modifyCourse(course);
        //判断是否修改成功
        if (effectedNum <= 0){
            throw new CourseOperationException("修改课程信息失败");
        }
        return new CourseExecution(CourseStateEnum.SUCCESS,course);
    }


    @Override
    public CourseExecution deleteCourse(long courseId) {
        //删除该课程信息
        int effectedNum = courseDao.deleteCourse(courseId);
        //判断是否删除成功
        if (effectedNum <= 0) {
            throw new CourseOperationException("课程信息删除失败");
        } else {
            return new CourseExecution(CourseStateEnum.SUCCESS);
        }
    }
}
