package com.caovinh.identity_service.controller;

import com.caovinh.identity_service.dto.request.PermissionRequest;
import com.caovinh.identity_service.dto.response.ApiResponse;
import com.caovinh.identity_service.dto.response.PermissionResponse;
import com.caovinh.identity_service.service.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/permission")
public class PermissionController {
    PermissionService permissionService;

    @PostMapping
    ApiResponse<PermissionResponse> createPermission(@RequestBody PermissionRequest permissionRequest) {
        return ApiResponse.<PermissionResponse>builder()
                .message("Permission created successfully")
                .data(permissionService.createPermission(permissionRequest))
                .build();
    }

    @GetMapping
    ApiResponse<List<PermissionResponse>> getAllPermissions() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .message("Get all permissions successfully")
                .data(permissionService.getAllPermissions())
                .build();
    }

    @DeleteMapping("/{permissionId}")
    ApiResponse<Void> deletePermission(@PathVariable("permissionId") String permissionId) {
        permissionService.deletePermission(permissionId);
        return ApiResponse.<Void>builder()
                .message("Permission deleted successfully")
                .build();
    }
}
