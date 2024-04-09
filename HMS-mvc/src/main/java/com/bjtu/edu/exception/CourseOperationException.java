package com.bjtu.edu.exception;

/**
 * @project: mvc
 * @description: Course异常操作类
 * @author: wanShun
 * @create: 2022/11/30
 */
public class CourseOperationException extends RuntimeException{
    private static final long serialVersionUID = -7989645915942446156L;

    public CourseOperationException(String msg){super(msg);}
}
