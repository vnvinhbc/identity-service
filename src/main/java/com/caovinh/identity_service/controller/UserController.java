package com.caovinh.identity_service.controller;

import com.caovinh.identity_service.dto.request.UserCreationRequest;
import com.caovinh.identity_service.dto.request.UserUpdateRequest;
import com.caovinh.identity_service.dto.response.ApiResponse;
import com.caovinh.identity_service.dto.response.UserResponse;
import com.caovinh.identity_service.entity.User;
import com.caovinh.identity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest user){
//        C1
//        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
//        apiResponse.setData(userService.createUser(user));
//        apiResponse.setMessage("User created successfully");
//        return apiResponse;

        // C2
        return ApiResponse.<UserResponse>builder()
                .data(userService.createUser(user))
                .message("User created successfully")
                .build();
    }

    @GetMapping
    ApiResponse<List<UserResponse>> getAllUsers() {
        return ApiResponse.<List<UserResponse>>builder()
                .data(userService.getAllUsers())
                .message("Get all users successfully")
                .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUserById(@PathVariable("userId") String userId) {
        return ApiResponse.<UserResponse>builder()
                .data(userService.getUserById(userId))
                .message("Get user by ID successfully")
                .build();
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request){
        return ApiResponse.<UserResponse>builder()
                .data(userService.updateUser(userId, request))
                .message("User updated successfully")
                .build();
    }

    @PatchMapping("/{userId}/partial")
    ApiResponse<UserResponse> updateUserPartially(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request){
            return ApiResponse.<UserResponse>builder()
                    .data(userService.updateUserPartially(userId, request))
                    .message("User updated successfully")
                    .build();
    }

    @DeleteMapping("/{userId}")
    ApiResponse<Void> deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return ApiResponse.<Void>builder()
                .message("User deleted successfully")
                .build();
    }

}
