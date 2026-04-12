package com.andree.synctalk.mapper;

import com.andree.synctalk.domain.entities.User;
import com.andree.synctalk.dto.request.auth.RegisterRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {


    User toUser(RegisterRequest register);

}
