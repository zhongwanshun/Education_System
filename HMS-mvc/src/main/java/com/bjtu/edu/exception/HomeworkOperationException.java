package com.bjtu.edu.exception;

/**
 * @project: mvc
 * @description: HomeWork异常操作类
 * @author: wanShun
 * @create: 2022/11/30
 */
public class HomeworkOperationException extends RuntimeException{
    private static final long serialVersionUID = 7621921089468686702L;

    public HomeworkOperationException(String msg){super(msg);}
}
