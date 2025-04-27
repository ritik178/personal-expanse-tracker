package net.javaguides.expansetrackerapp.service.impl;


import lombok.AllArgsConstructor;
import net.javaguides.expansetrackerapp.dto.LoginDto;
import net.javaguides.expansetrackerapp.dto.RegisterDto;
import net.javaguides.expansetrackerapp.entity.Role;
import net.javaguides.expansetrackerapp.entity.User;
import net.javaguides.expansetrackerapp.exception.EtaApiException;
import net.javaguides.expansetrackerapp.repository.RoleRepository;
import net.javaguides.expansetrackerapp.repository.UserRepository;
import net.javaguides.expansetrackerapp.security.JwtTokenProvider;
import net.javaguides.expansetrackerapp.service.AuthService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String register(RegisterDto registerDto) {
        // username exists or not
        if(userRepository.existsByUsername(registerDto.getUsername())) {
            throw new EtaApiException(HttpStatus.BAD_REQUEST,"username already exist");
        }

        // email already exist in database
        if(userRepository.existsByEmail(registerDto.getEmail())) {
            throw new EtaApiException(HttpStatus.BAD_REQUEST,"Email already exist in database");
        }

        User user = new User();
        user.setName(registerDto.getUsername());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);


        return "User registered successfully";
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }
}
