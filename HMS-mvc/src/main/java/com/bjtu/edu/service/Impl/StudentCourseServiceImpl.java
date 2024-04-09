package com.bjtu.edu.service.Impl;

import com.bjtu.edu.dao.StudentCourseDao;
import com.bjtu.edu.dto.StudentCourseExecution;
import com.bjtu.edu.entity.StudentCourse;
import com.bjtu.edu.enums.StudentCourseStateEnum;
import com.bjtu.edu.exception.StudentCourseOperationException;
import com.bjtu.edu.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @project: mvc
 * @description: StudentCourseService实现类
 * @author: wanShun
 * @create: 2022/11/30
 */
@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    private StudentCourseDao studentCourseDao;


    @Override
    public List<StudentCourse> getStudentCourseList() {
        return studentCourseDao.queryStudentCourse();
    }

    @Override
    public StudentCourse getStudentCourseById(long studentCourseId) {
        return studentCourseDao.queryStudentCourseById(studentCourseId);
    }


    @Override
    public List<StudentCourse> getStudentCourseByStudentId(long studentId) {
        return studentCourseDao.queryStudentCourseByStudentId(studentId);
    }


    @Override
    public List<StudentCourse> getStudentByCourseId(long courseId) {
        return studentCourseDao.queryStudentByCourseId(courseId);
    }


    @Override
    public StudentCourseExecution addStudentCourse(StudentCourse studentCourse) {
        //空值判断
        if (studentCourse == null){
            return new StudentCourseExecution(StudentCourseStateEnum.EMPTY);
        }
        //给选课信息赋初始值
        studentCourse.setCreateTime(new Date());
        //添加选课信息
        int effectedNum = studentCourseDao.addStudentCourse(studentCourse);
        //判断是否添加成功
        if (effectedNum <= 0){
            throw new StudentCourseOperationException("添加选课信息失败");
        }
        return new StudentCourseExecution(StudentCourseStateEnum.SUCCESS,studentCourse);
    }


    @Override
    public StudentCourseExecution modifyStudentCourse(StudentCourse studentCourse) {
        //空值判断
        if (studentCourse == null || studentCourse.getStudentCourseId() == null){
            return new StudentCourseExecution(StudentCourseStateEnum.EMPTY);
        }
        //给选课信息赋初始值
        studentCourse.setLastEditTime(new Date());
        //修改选课信息
        int effectedNum = studentCourseDao.modifyStudentCourse(studentCourse);
        //判断是否修改成功
        if (effectedNum <= 0){
            throw new StudentCourseOperationException("修改选课信息失败");
        }
        return new StudentCourseExecution(StudentCourseStateEnum.SUCCESS,studentCourse);
    }


    @Override
    public StudentCourseExecution deleteStudentCourse(long studentCourseId) {
        //删除该选课信息
        int effectedNum = studentCourseDao.deleteStudentCourse(studentCourseId);
        //判断是否删除成功
        if (effectedNum <= 0){
            throw new StudentCourseOperationException("选课信息删除失败");
        }else {
            return new StudentCourseExecution(StudentCourseStateEnum.SUCCESS);
        }
    }
}
