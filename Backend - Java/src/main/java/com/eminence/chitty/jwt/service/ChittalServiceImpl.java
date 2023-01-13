package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dao.ChitRepository;
import com.eminence.chitty.jwt.dao.ChittalDetailsRepo;
import com.eminence.chitty.jwt.dao.UserRegistrationRepo;
import com.eminence.chitty.jwt.dto.ChittalPost;
import com.eminence.chitty.jwt.dto.ChittalPostResponse;
import com.eminence.chitty.jwt.entity.ChittalDetails;
import com.eminence.chitty.jwt.entity.Chitty;
import com.eminence.chitty.jwt.entity.UserRegistration;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ChittalServiceImpl implements ChittalService{

    private ChittalDetailsRepo chittalDetailsRepo;
    private UserRegistrationRepo userRegistrationRepo;
    private ChitRepository chitRepository;

    @Override
    public ChittalPostResponse addChittal(ChittalPost request) {
        ChittalDetails chittalDetails = new ChittalDetails();
        BeanUtils.copyProperties(request,chittalDetails);
        chittalDetails.setChittalId(request.getChittalId());
        Optional<UserRegistration> userRegistration = userRegistrationRepo.findById(request.getUserId());
        chittalDetails.setUserId(userRegistration.get());
        Optional<Chitty> chitty = chitRepository.findById(request.getChittyId());
        chittalDetails.setChittyId(chitty.get());
        chittalDetails.setAge(request.getAge());
        chittalDetails.setAddress(request.getAddress());
        chittalDetails.setPinCode(request.getPinCode());
        chittalDetails.setUserPhone(request.getUserPhone());
        chittalDetails.setDob(request.getDob());
        chittalDetails.setStatus(request.getStatus());
        chittalDetails.setIncome(request.getIncome());
        chittalDetails.setAadhar(request.getAadhar());
        chittalDetailsRepo.save(chittalDetails);
        Long chittalId = chittalDetails.getChittalId();
        return new ChittalPostResponse(chittalId);
    }
}
