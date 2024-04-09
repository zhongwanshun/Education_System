package com.bjtu.edu.service;

import com.bjtu.edu.dto.AdminExecution;
import com.bjtu.edu.dto.ImageHolder;
import com.bjtu.edu.entity.Admin;

public interface AdminService {

    Admin getAdminById(long adminId);


    AdminExecution modifyAdmin(Admin admin, ImageHolder imageHolder);
}
