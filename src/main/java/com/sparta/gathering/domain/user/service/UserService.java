package com.sparta.gathering.domain.user.service;

import com.sparta.gathering.domain.user.dto.request.UserRequest;
import com.sparta.gathering.domain.user.entity.User;
import com.sparta.gathering.domain.user.enums.IdentityProvider;

import java.util.UUID;

public interface UserService {

    User createUser(UserRequest userRequest);

    User findById(UUID userId);

    void deleteUser(String tokenUserId);

    User findByEmail(String email);

    User findByProviderIdAndIdentityProvider(String providerId, IdentityProvider identityProvider);

    User authenticateUser(String email, String password);

}
