package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dao.ChitCategoryRepository;
import com.eminence.chitty.jwt.dao.ChitRepository;
import com.eminence.chitty.jwt.dao.ManagerRepo;

import com.eminence.chitty.jwt.dto.ChittyPost;
import com.eminence.chitty.jwt.entity.Chitty;
import com.eminence.chitty.jwt.entity.ChittyCategory;
import com.eminence.chitty.jwt.entity.Manager;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ChittyServiceImpl implements ChittyService{

    private ChitRepository chitRepository;
    private ManagerRepo managerRepo;
    private ChitCategoryRepository chitCategoryRepository;


    @Override
    public ChittyPost addChitty(ChittyPost request) {
        Chitty chitty = new Chitty();
        BeanUtils.copyProperties(request,chitty);
        chitty.setChitNumber(request.getChitNumber());
        chitty.setInstallment(request.getInstallment());
        chitty.setDuration(request.getDuration());
        Optional<ChittyCategory> chittyCategory = chitCategoryRepository.findById(request.getCategory());
        chitty.setCategory(chittyCategory.get());
        chitty.setNumberOfChittal(request.getNumberOfChittal());
        chitty.setCurrentNumberOfChittal(request.getCurrentNumberOfChittal());
        chitty.setTotalAmount(request.getTotalAmount());
        Optional<Manager> manager = managerRepo.findById(request.getManager());
        chitty.setManager(manager.get());
        chitty.setLaunchDate(request.getLaunchDate());
        chitty.setStartDate(request.getStartDate());
        chitty.setStatus(request.getStatus());
        chitRepository.save(chitty);
        return request;
    }

    @Override
    public ChittyPost updateChitty(ChittyPost request) {
        Optional<Chitty> getChitty = chitRepository.findById(request.getChitNumber());
        Chitty chitty = getChitty.get();
        BeanUtils.copyProperties(request,chitty);
        chitty.setChitNumber(request.getChitNumber());
        chitty.setInstallment(request.getInstallment());
        chitty.setDuration(request.getDuration());
        Optional<ChittyCategory> chittyCategory = chitCategoryRepository.findById(request.getCategory());
        chitty.setCategory(chittyCategory.get());
        chitty.setNumberOfChittal(request.getNumberOfChittal());
        chitty.setCurrentNumberOfChittal(request.getCurrentNumberOfChittal());
        chitty.setTotalAmount(request.getTotalAmount());
        Optional<Manager> manager = managerRepo.findById(request.getManager());
        chitty.setManager(manager.get());
        chitty.setLaunchDate(request.getLaunchDate());
        chitty.setStartDate(request.getStartDate());
        chitty.setStatus(request.getStatus());
        chitRepository.save(chitty);
        return request;
    }

    @Override
    public Optional<Chitty> findById(String chitNumber){
        Optional<Chitty> chitty = chitRepository.findById(chitNumber);
        return chitty;
    }

    @Override
    public void deleteChitty(Long id) {

    }


}
