package com.bjtu.edu.enums;

/**
 * @project: mvc
 * @description: Clazz枚举状态类
 * @author: wanShun
 * @create: 2022/11/30
 */
public enum ClazzStateEnum {

    SUCCESS(1, "创建成功"),
    INNER_ERROR(-1001, "操作失败"),
    EMPTY_LIST(-1002, "添加数少于1"),
    EMPTY(-1003, "班级信息为空");

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    private ClazzStateEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }


    public static ClazzStateEnum stateOf(int state){
        for (ClazzStateEnum stateEnum : values()){
            if (stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }
}
