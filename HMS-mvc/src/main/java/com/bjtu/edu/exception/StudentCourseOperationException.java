package com.bjtu.edu.exception;

/**
 * @project: mvc
 * @description: StudentCourse异常操作类
 * @author: wanShun
 * @create: 2022/11/30
 */
public class StudentCourseOperationException extends RuntimeException{
    private static final long serialVersionUID = -4815731819042253407L;

    public StudentCourseOperationException(String msg){super(msg);}
}
