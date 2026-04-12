package com.andree.synctalk.service.impl;

import com.andree.synctalk.domain.entities.User;
import com.andree.synctalk.dto.Response;
import com.andree.synctalk.dto.request.auth.RegisterRequest;
import com.andree.synctalk.mapper.UserMapper;
import com.andree.synctalk.repository.UserRepository;
import com.andree.synctalk.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {



    private final UserMapper userMapper;

    private final UserRepository userRepository;

    @Override
    public Response<Void> registerUser(RegisterRequest register) {

        if (userRepository.existsByEmail(register.getEmail()) || userRepository.existsByUsername(register.getUsername())) {
            throw new DataIntegrityViolationException("Email or username already exists");
        }

        User user = userMapper.toUser(register);
        user.setId(null);
        userRepository.save(user);

        return Response.<Void>builder().
                success(true).
                message("User registered successfully").
                build();
    }

}
