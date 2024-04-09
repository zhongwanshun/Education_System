package com.bjtu.edu.dao;

import com.bjtu.edu.entity.Teacher;

import java.util.List;

/**
 * @author: wanShun
 * @description: 教师实体类dao层接口
 * @createTime: 2022/11/30
 */
public interface TeacherDao {

    List<Teacher> queryTeacher();


    Teacher queryTeacherById(long teacherId);


    int addTeacher(Teacher teacher);


    int modifyTeacher(Teacher teacher);


    int deleteTeacher(long teacherId);
}
