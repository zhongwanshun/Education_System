package com.bjtu.edu.util;

import java.util.HashMap;
import java.util.List;

/**
 * @project: mvc
 * @description: Layui工具类
 * @author: wanShun
 * @create: 2022/12/1
 */
public class Layui  extends HashMap<String, Object> {

    public static Layui data(Integer count, List<?> data){
        Layui r = new Layui();
        r.put("code", 0);
        r.put("msg", "");
        r.put("count", count);
        r.put("data", data);
        return r;
    }
}
