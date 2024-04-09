package com.bjtu.edu.service;

import com.bjtu.edu.dto.CourseExecution;
import com.bjtu.edu.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourseList();


    Course getCourseById(long courseId);


    List<Course> getCourseByTeacherId(long teacherId);

    CourseExecution addCourse(Course course);


    CourseExecution modifyCourse(Course course);


    CourseExecution deleteCourse(long courseId);
}
