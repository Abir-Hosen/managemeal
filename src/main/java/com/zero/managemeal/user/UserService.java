package com.zero.managemeal.user;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.zero.managemeal.abc.RequestParameter;

public interface UserService {
	
	public Page<User> findAllBySortAndOrder(RequestParameter requestParameter);
	public Optional<User> findById(Long id);
	public User findByEmail(String email);
	public void addEntity(User entity);
	public void signUp(User entity);
	public void deleteEntity(Long id);
	public void deleteAllEntity();
}
