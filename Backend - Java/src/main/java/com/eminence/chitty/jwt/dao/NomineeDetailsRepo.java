package com.eminence.chitty.jwt.dao;

import com.eminence.chitty.jwt.entity.NomineeDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "nomineedetails",path="nominee-details")
public interface NomineeDetailsRepo extends JpaRepository<NomineeDetails,Long> {
}
