package com.jsms.java.service;

import com.jsms.java.model.User;

public interface SignInService {
	User findByUserId(User user);
}
