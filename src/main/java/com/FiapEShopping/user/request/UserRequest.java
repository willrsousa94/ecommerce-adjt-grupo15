package com.FiapEShopping.user.request;

import com.FiapEShopping.model.enums.UserRole;

public record UserRequest(String login, String password, UserRole role) {
}

