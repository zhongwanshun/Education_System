package com.bjtu.edu.service;

import com.bjtu.edu.dto.FileHolder;
import com.bjtu.edu.dto.StudentHomeworkExecution;
import com.bjtu.edu.entity.StudentHomework;

import java.util.List;

public interface StudentHomeworkService {

    List<StudentHomework> getStudentHomeworkList();


    StudentHomework getStudentHomeworkById(long studentHomeworkId);


    List<StudentHomework> getStudentHomeworkByCourseId(long courseId);


    List<StudentHomework> getStudentHomeworkByTeacherId(long teacherId);


    StudentHomework getStudentHomeworkCondition(StudentHomework studentHomeworkCondition);


    StudentHomeworkExecution addStudentHomework(StudentHomework studentHomework, FileHolder fileHolder);


    StudentHomeworkExecution modifyStudentHomework(StudentHomework studentHomework, FileHolder fileHolder);


    StudentHomeworkExecution deleteStudentHomework(long studentHomeworkId);
}
