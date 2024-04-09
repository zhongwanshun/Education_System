package com.bjtu.edu.exception;

/**
 * @project: mvc
 * @description: Admin异常操作类
 * @author: wanShun
 * @create: 2022/11/30
 */
public class AdminOperationException extends RuntimeException{
    private static final long serialVersionUID = -4473514521615519498L;

    public AdminOperationException(String msg){super(msg);}
}
