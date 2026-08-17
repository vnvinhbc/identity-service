package com.caovinh.identity_service.mapper;

import com.caovinh.identity_service.dto.request.RoleRequest;
import com.caovinh.identity_service.dto.request.RoleResponse;
import com.caovinh.identity_service.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest roleRequest);

    RoleResponse toRoleResponse(Role role);
}
