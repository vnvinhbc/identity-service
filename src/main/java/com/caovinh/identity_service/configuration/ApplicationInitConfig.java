package com.caovinh.identity_service.configuration;

import com.caovinh.identity_service.entity.User;
import com.caovinh.identity_service.enums.Role;
import com.caovinh.identity_service.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner ( UserRepository userRepository) {
        return args -> {
            if (!userRepository.existsByUsername("admin")) {
                HashSet<String> roles = new HashSet<>();
                roles.add(Role.ADMIN.name());

                User adminUser = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
//                        .roles(roles)
                        .build();
                userRepository.save(adminUser);
                log.warn("Admin user created with username: 'admin' and password: 'admin'. Please change the password immediately.");
            }
        };
    }
}
