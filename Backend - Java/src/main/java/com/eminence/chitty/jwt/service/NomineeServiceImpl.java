package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dao.ChittalDetailsRepo;
import com.eminence.chitty.jwt.dao.NomineeDetailsRepo;
import com.eminence.chitty.jwt.dto.NomineePost;
import com.eminence.chitty.jwt.entity.ChittalDetails;
import com.eminence.chitty.jwt.entity.NomineeDetails;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class NomineeServiceImpl implements NomineeService{

    private NomineeDetailsRepo nomineeDetailsRepo;
    private ChittalDetailsRepo chittalDetailsRepo;
//    private ChitRepository chitRepository;

    @Override
    public NomineePost addNominee(NomineePost request) {
        NomineeDetails nomineeDetails = new NomineeDetails();
        BeanUtils.copyProperties(request,nomineeDetails);

        Optional<ChittalDetails> chittalDetails = chittalDetailsRepo.findById(request.getChittalId());
        nomineeDetails.setChittalId(chittalDetails.get());
        nomineeDetails.setName(request.getName());
        nomineeDetails.setAge(request.getAge());
        nomineeDetails.setDob(request.getDob());
        nomineeDetails.setPhone(request.getPhone());
        nomineeDetails.setAddress(request.getAddress());
        nomineeDetails.setPincode(request.getPincode());
        nomineeDetails.setAadhar(request.getAadhar());
        nomineeDetailsRepo.save(nomineeDetails);
        return request;
    }
}
