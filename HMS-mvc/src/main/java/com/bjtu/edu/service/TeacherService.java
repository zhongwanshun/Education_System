package com.bjtu.edu.service;

import com.bjtu.edu.dto.ImageHolder;
import com.bjtu.edu.dto.TeacherExecution;
import com.bjtu.edu.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getTeacherList();
    

    Teacher getTeacherById(long teacherId);


    TeacherExecution addTeacher(Teacher teacher, ImageHolder thumbnail);


    TeacherExecution modifyTeacher(Teacher teacher, ImageHolder thumbnail);
    

    TeacherExecution deleteTeacher(long teacherId);
}
