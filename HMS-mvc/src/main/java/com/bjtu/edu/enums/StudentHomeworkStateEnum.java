package com.bjtu.edu.enums;

/**
 * @project: mvc
 * @description: StudentHomeWork枚举状态类
 * @author: wanShun
 * @create: 2022/11/30
 */
public enum StudentHomeworkStateEnum {

    SUCCESS(1, "创建成功"),
    INNER_ERROR(-1001, "操作失败"),
    EMPTY(-1002, "作业内容为空");

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    private StudentHomeworkStateEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }


    public static StudentHomeworkStateEnum stateOf(int state){
        for (StudentHomeworkStateEnum stateEnum : values()){
            if (stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }
}
