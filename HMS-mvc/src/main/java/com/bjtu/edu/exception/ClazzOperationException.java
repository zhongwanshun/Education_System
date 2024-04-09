package com.bjtu.edu.exception;

/**
 * @project: mvc
 * @description: Clazz异常操作类
 * @author: wanShun
 * @create: 2022/11/30
 */
public class ClazzOperationException extends RuntimeException{
    private static final long serialVersionUID = 1110885646012316735L;

    public ClazzOperationException(String msg){super(msg);}
}
