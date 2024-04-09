package com.bjtu.edu.service;

import com.bjtu.edu.dto.FileHolder;
import com.bjtu.edu.dto.HomeworkExecution;
import com.bjtu.edu.entity.Homework;

import java.util.List;

public interface HomeworkService {

    List<Homework> getHomeworkList();


    Homework getHomeworkById(long homeworkId);


    List<Homework> getHomeworkByCourseId(long courseId);


    List<Homework> getHomeworkByTeacherId(long teacherId);


    List<Homework> getHomeworkByStudentId(long studentId);


    HomeworkExecution addHomework(Homework homework, FileHolder fileHolder);


    HomeworkExecution modifyHomework(Homework homework, FileHolder fileHolder);


    HomeworkExecution deleteHomework(long homeworkId);
}
