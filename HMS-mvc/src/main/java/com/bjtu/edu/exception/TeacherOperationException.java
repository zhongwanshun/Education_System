package com.bjtu.edu.exception;

/**
 * @project: mvc
 * @description: Teacher异常操作类
 * @author: wanShun
 * @create: 2022/11/30
 */
public class TeacherOperationException extends RuntimeException{
    private static final long serialVersionUID = -5542113967321598807L;

    public TeacherOperationException(String msg){super(msg);}
}
