package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dao.ChitRepository;
import com.eminence.chitty.jwt.dao.ChittalDetailsRepo;
import com.eminence.chitty.jwt.entity.ChittalDetails;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ChittalUserIdServiceImpl implements ChittalUserIdService{

    @Autowired
    private ChittalDetailsRepo chittalDetailsRepo;
    private ChitRepository chitRepository;
//    List<Chitty> chittyList = new ArrayList<Chitty>();


    @Override
    public Set<String> getChitties(Long id) {
        Set<String> chittyNumbers = new HashSet<>();
        List<ChittalDetails> chittalList = new ArrayList<ChittalDetails>();
        chittalList = chittalDetailsRepo.findAll();
        for(ChittalDetails chittalDetails : chittalList){
//            System.out.println(chittalDetails.getUserId().getId());
//            System.out.println(id);
//            System.out.println(chittalDetails.getChittyId().getChitNumber());
            if(chittalDetails.getUserId().getId().equals(id)){
//                System.out.println(chittalDetails.getChittyId().getChitNumber());
//                System.out.println(chittalDetails.getChittyId());
                chittyNumbers.add(chittalDetails.getChittyId().getChitNumber());
            }
        }

        return chittyNumbers;

    }
}
