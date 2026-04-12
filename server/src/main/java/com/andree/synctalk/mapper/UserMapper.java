package com.andree.synctalk.mapper;

import com.andree.synctalk.domain.entities.User;
import com.andree.synctalk.dto.request.auth.RegisterRequest;
import com.andree.synctalk.dto.response.auth.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {


    User toUser(RegisterRequest register);

    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "biography", ignore = true)
    @Mapping(target = "profilePhotoUrl", ignore = true)
    UserResponse toUserResponse(User user);
}
