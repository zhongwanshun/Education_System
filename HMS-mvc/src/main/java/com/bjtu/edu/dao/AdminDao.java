package com.bjtu.edu.dao;

import com.bjtu.edu.entity.Admin;

/**
 * @author: wanShun
 * @description: 管理员实体类dao层接口
 * @createTime: 2022/11/30
 */
public interface AdminDao {

    Admin queryAdminById(long adminId);


    int modifyAdmin(Admin admin);
}
