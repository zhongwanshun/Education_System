package com.bjtu.edu.dao;

import com.bjtu.edu.entity.Course;

import java.util.List;

/**
 * @author: wanShun
 * @description: 课程实体类dao层接口
 * @createTime: 2022/11/30
 */
public interface CourseDao {

    List<Course> queryCourse();
    

    Course queryCourseById(long courseId);


    List<Course> queryCourseByTeacherId(long teacherId);

    int addCourse(Course course);
    

    int modifyCourse(Course course);
    

    int deleteCourse(long courseId);
}
