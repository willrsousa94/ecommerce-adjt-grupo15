package com.FiapEShopping.model.DTO;

import java.util.UUID;

import com.FiapEShopping.model.enums.UserRole;

public record UserDTO(UUID id, String login, UserRole role) {}
