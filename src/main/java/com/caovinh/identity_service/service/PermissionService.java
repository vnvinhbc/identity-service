package com.caovinh.identity_service.service;


import com.caovinh.identity_service.dto.request.PermissionRequest;
import com.caovinh.identity_service.dto.response.PermissionResponse;
import com.caovinh.identity_service.mapper.PermissionMapper;
import com.caovinh.identity_service.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse createPermission(PermissionRequest permissionRequest) {
        var permission = permissionMapper.toPermission(permissionRequest);
        var savedPermission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(savedPermission);
    }

    public List<PermissionResponse> getAllPermissions() {
        var permissions = permissionRepository.findAll();
        return permissions.stream()
                .map(permissionMapper::toPermissionResponse)
                .toList();
    }

    public void deletePermission(String permissionId) {
        permissionRepository.deleteById(permissionId);
    }

}
