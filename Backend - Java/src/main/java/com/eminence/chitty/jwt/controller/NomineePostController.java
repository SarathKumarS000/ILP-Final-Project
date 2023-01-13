package com.eminence.chitty.jwt.controller;



import com.eminence.chitty.jwt.dto.NomineePost;
import com.eminence.chitty.jwt.service.NomineeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/nominee")

public class NomineePostController {

    private static final Logger logger = LoggerFactory.getLogger(NomineePostController.class);

    @Autowired
    private NomineeService nomineeService;

    @PostMapping("/add")
    public NomineePost addNominee(@RequestBody NomineePost request){
        logger.info("Nominee Posted");
        return nomineeService.addNominee(request);
    }




}
