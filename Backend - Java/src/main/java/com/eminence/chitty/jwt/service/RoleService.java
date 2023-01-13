package com.eminence.chitty.jwt.service;

//import com.youtube.jwt.dao.RoleDao;
//import com.youtube.jwt.entity.Role;
import com.eminence.chitty.jwt.dao.RoleDao;
import com.eminence.chitty.jwt.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

}
