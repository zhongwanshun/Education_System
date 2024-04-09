package com.bjtu.edu.dao;

import com.bjtu.edu.entity.Clazz;

import java.util.List;

/**
 * @author: wanShun
 * @description: 班级实体类dao层接口
 * @createTime: 2022/11/30
 */
public interface ClazzDao {

    List<Clazz> queryClazz();


    Clazz queryClazzById(long clazzId);

    int addClazz(Clazz clazz);


    int modifyClazz(Clazz aClazz);


    int deleteClazz(long clazzId);
}
