package com.bjtu.edu.dao;

import com.bjtu.edu.entity.Student;

import java.util.List;

/**
 * @author: wanShun
 * @description: 学生实体类dao层接口
 * @createTime: 2022/11/30
 */
public interface StudentDao {

    List<Student> queryStudent();


    Student queryStudentById(long studentId);
    

    int addStudent(Student student);
    

    int modifyStudent(Student student);
    

    int deleteStudent(long studentId);
}
