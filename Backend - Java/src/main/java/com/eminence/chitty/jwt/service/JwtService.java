package com.eminence.chitty.jwt.service;

//import com.youtube.jwt.dao.UserDao;
//import com.youtube.jwt.entity.JwtRequest;
//import com.youtube.jwt.entity.JwtResponse;
//import com.youtube.jwt.entity.User;
//import com.youtube.jwt.util.JwtUtil;
import com.eminence.chitty.jwt.dao.UserLoginRepo;
import com.eminence.chitty.jwt.entity.JwtRequest;
import com.eminence.chitty.jwt.entity.JwtResponse;
import com.eminence.chitty.jwt.entity.UserLogin;
import com.eminence.chitty.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserLoginRepo userLoginRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        Long roleId=null;
        Long userId = null;
        String role= "";
        String email = jwtRequest.getEmail();
        String password = jwtRequest.getPassword();
        authenticate(email, password);

        UserDetails userDetails = loadUserByUsername(email);
        System.out.println(userDetails);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        List<UserLogin> login= userLoginRepo.findAll();
        for(UserLogin userLogin:login)
        {
            if((userLogin.getEmail().equalsIgnoreCase(email))){
                userId=userLogin.getUserId();
                roleId = userLogin.getRole().getId();
                role=userLogin.getRole().getRoleName();
                email=userLogin.getEmail();
            }
        }
        UserLogin user = userLoginRepo.findById(userId).get();
        return new JwtResponse(userId,roleId,role,email,newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Long id=null;
        List<UserLogin> login= userLoginRepo.findAll();
        for(UserLogin userLogin:login){
            if((userLogin.getEmail().equalsIgnoreCase(email))){
                id = userLogin.getUserId();
            }
        }
        UserLogin user = userLoginRepo.findById(id).get();

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " +email );

        }
    }

    private Set getAuthority(UserLogin user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        user.getRole().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        authorities.add(new SimpleGrantedAuthority("ROLE_"+ user.getRole().getRoleName()));
        return authorities;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
