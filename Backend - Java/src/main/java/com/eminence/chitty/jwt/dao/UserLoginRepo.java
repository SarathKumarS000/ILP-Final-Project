package com.eminence.chitty.jwt.dao;

//import com.youtube.jwt.entity.User;
import com.eminence.chitty.jwt.entity.UserLogin;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "userlogin", path="users")
@CrossOrigin
@DynamicUpdate
public interface UserLoginRepo extends JpaRepository<UserLogin, Long> {
}
