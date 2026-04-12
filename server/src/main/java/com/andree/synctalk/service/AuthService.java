package com.andree.synctalk.service;

import com.andree.synctalk.dto.Response;
import com.andree.synctalk.dto.request.auth.RegisterRequest;

public interface AuthService {

    Response<Void> registerUser(RegisterRequest register);
}
