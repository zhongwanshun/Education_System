package com.bjtu.edu.service;

import com.bjtu.edu.dto.ImageHolder;
import com.bjtu.edu.dto.StudentExecution;
import com.bjtu.edu.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList();


    Student getStudentById(long studentId);


    StudentExecution addStudent(Student student, ImageHolder imageHolder);

    StudentExecution modifyStudent(Student student, ImageHolder imageHolder);


    StudentExecution deleteStudent(long studentId);
}
