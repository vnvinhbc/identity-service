package com.caovinh.identity_service.controller;

import com.caovinh.identity_service.dto.request.UserCreationRequest;
import com.caovinh.identity_service.dto.request.UserUpdateRequest;
import com.caovinh.identity_service.entity.User;
import com.caovinh.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest user) {
        return userService.createUser(user);
    }
    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{userId}")
    User getUserById(@PathVariable("userId") String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId, request);
    }
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return "User with id " + userId + " has been deleted.";
    }
    @PatchMapping("/{userId}/partial")
    public ResponseEntity<User> updateUserPartially(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request){
            User updatedUser = userService.updateUserPartially(userId, request);
            return ResponseEntity.ok(updatedUser);
    }
}
