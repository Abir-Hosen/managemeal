package com.zero.managemeal.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
	
	public List<User> allEntity();
	public Optional<User> findById(Long id);
	public User findByEmail(String email);
	public void addEntity(User entity);
	public void signUp(User entity);
	public void deleteEntity(User entity);
	public void deleteAllEntity();
}
