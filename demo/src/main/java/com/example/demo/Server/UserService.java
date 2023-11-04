package com.example.demo.Server;

import com.example.demo.Models.User;
import com.example.demo.Repos.UserRepo;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.authentication.AuthenticationManager;



@Service
public class UserService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;


    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(
            UserRepo userRepo,
            BCryptPasswordEncoder passwordEncoder,
            @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService,
            AuthenticationManager authenticationManager) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    public User registerUser(User user) {
        //user加入雜湊加密
        user.setpassword(passwordEncoder.encode(user.getpassword()));
        return userRepo.save(user);

    }

    public User loginUser(String email, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        System.out.println("Loaded user details: " + userDetails);

        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            System.out.println("Authentication details: " + authentication);


            if (authentication.isAuthenticated()) {
                System.out.println("Authentication succeeded: " + authentication);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return userRepo.findByEmail(email);
            } else {
                System.out.println("Authentication failed.");
            }
        }

            return null;
        }
    }

