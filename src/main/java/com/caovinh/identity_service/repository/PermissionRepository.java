package com.caovinh.identity_service.repository;

import com.caovinh.identity_service.dto.request.PermissionRequest;
import com.caovinh.identity_service.dto.response.PermissionResponse;
import com.caovinh.identity_service.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

}
