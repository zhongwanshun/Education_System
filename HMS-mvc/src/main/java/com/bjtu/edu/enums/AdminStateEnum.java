package com.bjtu.edu.enums;

/**
 * @project: mvc
 * @description: Admin枚举状态类
 * @author: wanShun
 * @create: 2022/11/30
 */
public enum AdminStateEnum {

    SUCCESS(1, "创建成功"),
    INNER_ERROR(-1001, "操作失败"),
    EMPTY(-1002, "管理员信息为空");

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    private AdminStateEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }


    public static AdminStateEnum stateOf(int state){
        for (AdminStateEnum stateEnum : values()){
            if (stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }
}
