package com.bjtu.edu.service;

import com.bjtu.edu.dto.StudentCourseExecution;
import com.bjtu.edu.entity.StudentCourse;

import java.util.List;

public interface StudentCourseService {

    List<StudentCourse> getStudentCourseList();


    StudentCourse getStudentCourseById(long studentCourseId);


    List<StudentCourse> getStudentCourseByStudentId(long studentId);


    List<StudentCourse> getStudentByCourseId(long courseId);


    StudentCourseExecution addStudentCourse(StudentCourse studentCourse);


    StudentCourseExecution modifyStudentCourse(StudentCourse studentCourse);


    StudentCourseExecution deleteStudentCourse(long studentCourseId);
}
