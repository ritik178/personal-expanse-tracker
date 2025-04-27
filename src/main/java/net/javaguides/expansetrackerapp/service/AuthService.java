package net.javaguides.expansetrackerapp.service;

import net.javaguides.expansetrackerapp.dto.LoginDto;
import net.javaguides.expansetrackerapp.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
