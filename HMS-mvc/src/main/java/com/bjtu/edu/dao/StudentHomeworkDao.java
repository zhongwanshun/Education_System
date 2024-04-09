package com.bjtu.edu.dao;

import com.bjtu.edu.entity.Homework;
import com.bjtu.edu.entity.StudentHomework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: wanShun
 * @description: 学生作业实体类dao层接口
 * @createTime: 2022/11/30
 */
public interface StudentHomeworkDao {

    List<StudentHomework> queryStudentHomework();


    StudentHomework queryStudentHomeworkById(long studentHomeworkId);


    List<StudentHomework> queryStudentHomeworkByCourseId(long courseId);


    List<StudentHomework> queryStudentHomeworkByTeacherId(long teacherId);


    int queryStudentHomeworkExist(@Param("studentHomeworkCondition") StudentHomework studentHomeworkCondition);


    StudentHomework queryStudentHomeworkByCondition(@Param("studentHomeworkCondition") StudentHomework studentHomeworkCondition);


    int addStudentHomework(StudentHomework studentHomework);


    int modifyStudentHomework(StudentHomework studentHomework);


    int deleteStudentHomework(long studentHomeworkId);
}
