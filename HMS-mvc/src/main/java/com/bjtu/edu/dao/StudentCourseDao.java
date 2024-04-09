package com.bjtu.edu.dao;

import com.bjtu.edu.entity.Homework;
import com.bjtu.edu.entity.StudentCourse;

import java.util.List;

/**
 * @author: wanShun
 * @description: 选课实体类dao层接口
 * @createTime: 2022/11/30
 */
public interface StudentCourseDao {

    List<StudentCourse> queryStudentCourse();
    

    StudentCourse queryStudentCourseById(long studentCourseId);



    List<StudentCourse> queryStudentCourseByStudentId(long studentId);


    List<StudentCourse> queryStudentByCourseId(long courseId);
    

    int addStudentCourse(StudentCourse studentCourse);
    

    int modifyStudentCourse(StudentCourse studentCourse);

    int deleteStudentCourse(long studentCourseId);
}
