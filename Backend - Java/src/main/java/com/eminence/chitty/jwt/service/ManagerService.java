package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dao.ManagerRepo;
import com.eminence.chitty.jwt.entity.Chitty;
import com.eminence.chitty.jwt.entity.ChittyCategory;
import com.eminence.chitty.jwt.entity.Manager;
import com.eminence.chitty.jwt.helper.Helper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepo managerRepo;

    public void save(MultipartFile file) {

        try {
            List<Manager> managers = Helper.convertExcelToListOfManager(file.getInputStream());
            this.managerRepo.saveAll(managers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Manager> getAllManagers(){
        return (List<Manager>)managerRepo.findAll();
    }


    public void add(Manager manager){
        this.managerRepo.save(manager);
    }

    public ManagerService(ManagerRepo managerRepo) {
        this.managerRepo = managerRepo;
    }


//    public void change(Manager manager) {
//        Optional<Manager> getManager = managerRepo.findById(manager.getEmp_id());
//        Manager mng = getManager.get();
//        BeanUtils.copyProperties(manager,mng);
//        mng.setEmp_id(manager.getEmp_id());
//        mng.setFirstName(manager.getFirstName());
//        mng.setEmp_lastname(manager.getEmp_lastname());
//
//
//    }
}
