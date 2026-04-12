package com.andree.synctalk.service;

import com.andree.synctalk.dto.Response;
import com.andree.synctalk.dto.request.auth.RegisterRequest;
import com.andree.synctalk.dto.response.auth.UserResponse;

public interface AuthService {

    Response<UserResponse> registerUser(RegisterRequest register);
}
