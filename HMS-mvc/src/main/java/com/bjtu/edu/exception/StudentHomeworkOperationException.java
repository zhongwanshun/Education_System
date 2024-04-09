package com.bjtu.edu.exception;

/**
 * @project: mvc
 * @description: StudentHomeWork异常操作类
 * @author: wanShun
 * @create: 2022/11/30
 */
public class StudentHomeworkOperationException extends RuntimeException{
    private static final long serialVersionUID = 8353226200023490354L;

    public StudentHomeworkOperationException(String msg){super(msg);}
}
