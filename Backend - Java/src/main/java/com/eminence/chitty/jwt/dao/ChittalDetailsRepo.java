package com.eminence.chitty.jwt.dao;


import com.eminence.chitty.jwt.entity.ChittalDetails;
//import com.experion.mainbackend.entity.ChittalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "chittaldetails",path="chittal-details")
public interface ChittalDetailsRepo extends JpaRepository<ChittalDetails,Long> {
}
