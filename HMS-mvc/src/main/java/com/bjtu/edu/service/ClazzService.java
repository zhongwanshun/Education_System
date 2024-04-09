package com.bjtu.edu.service;

import com.bjtu.edu.dto.ClazzExecution;
import com.bjtu.edu.entity.Clazz;

import java.util.List;

public interface ClazzService {

    List<Clazz> getClazzList();

    Clazz getClazzById(long clazzId);

    ClazzExecution addClazz(Clazz clazz);


    ClazzExecution modifyClazz(Clazz clazz);

    ClazzExecution deleteClazz(long clazzId);
}
