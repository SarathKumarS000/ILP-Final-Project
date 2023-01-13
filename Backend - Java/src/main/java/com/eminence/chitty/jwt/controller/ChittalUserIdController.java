package com.eminence.chitty.jwt.controller;

import com.eminence.chitty.jwt.service.ChittalUserIdService;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@Data
@CrossOrigin
@RestController
public class ChittalUserIdController {

    @Autowired
   private ChittalUserIdService chittalUserIdService;

    @GetMapping("/getchitties/{id}")
    Set<String> getChitties(@PathVariable Long id){
        return chittalUserIdService.getChitties(id);
    }
}
