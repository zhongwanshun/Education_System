package com.bjtu.edu.dao;

import com.bjtu.edu.entity.Homework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: wanShun
 * @description: 作业实体类dao层接口
 * @createTime: 2022/11/30
 */
public interface HomeworkDao {

    List<Homework> queryHomework();


    Homework queryHomeworkById(long homeworkId);


    List<Homework> queryHomeworkByCourseId(long courseId);


    List<Homework> queryHomeworkByTeacherId(long teacherId);


    List<Homework> queryHomeworkByStudentId(@Param("studentId") long studentId);


    int addHomework(Homework homework);


    int modifyHomework(Homework homework);


    int deleteHomework(long homeworkId);
}
