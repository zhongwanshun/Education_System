package com.bjtu.edu.enums;

/**
 * @project: mvc
 * @description: Course枚举状态类
 * @author: wanShun
 * @create: 2022/11/30
 */
public enum CourseStateEnum {

    SUCCESS(1, "创建成功"),
    INNER_ERROR(-1001, "操作失败"),
    EMPTY(-1002, "课程信息为空");

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    private CourseStateEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }


    public static CourseStateEnum stateOf(int state){
        for (CourseStateEnum stateEnum : values()){
            if (stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }
}
