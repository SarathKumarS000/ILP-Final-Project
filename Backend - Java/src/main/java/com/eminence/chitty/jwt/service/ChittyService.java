package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dto.ChittyPost;
import com.eminence.chitty.jwt.entity.Chitty;


import java.util.Optional;

public interface ChittyService {

    ChittyPost addChitty(ChittyPost request);
    ChittyPost updateChitty(ChittyPost request);
    public Optional<Chitty> findById(String chitNumber);
    void deleteChitty(Long id);





}
