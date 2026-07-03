package com.caovinh.identity_service.mapper;

import com.caovinh.identity_service.dto.request.UserCreationRequest;
import com.caovinh.identity_service.dto.request.UserUpdateRequest;
import com.caovinh.identity_service.dto.response.UserResponse;
import com.caovinh.identity_service.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest userCreationRequest);
    // @Mapping(target = "password", ignore = true)
    // @Mapping(source = "dob", target = "dob", dateFormat = "yyyy-MM-dd")
    UserResponse toUserResponse(User user);
    List<UserResponse> toUserResponseList(List<User> users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", ignore = true)
    void updateUser(UserUpdateRequest userUpdateRequest, @MappingTarget User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", ignore = true)
    void updateUserPartially(UserUpdateRequest userUpdateRequest, @MappingTarget User user);
}
