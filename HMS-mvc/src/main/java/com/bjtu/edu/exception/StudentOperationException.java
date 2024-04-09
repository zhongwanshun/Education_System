package com.bjtu.edu.exception;

/**
 * @project: mvc
 * @description: Student异常操作类
 * @author: wanShun
 * @create: 2022/11/30
 */
public class StudentOperationException extends RuntimeException{
    private static final long serialVersionUID = -6415835066202472815L;

    public StudentOperationException(String msg){super(msg);}
}
