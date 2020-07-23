package com.zero.managemeal.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> allEntity() {
		return (List<User>) repository.findAll();
	}

	@Override
	public void addEntity(User entity) {
		repository.save(entity);
	}

	@Override
	public void signUp(User entity) {
		entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		repository.save(entity);
	}

	@Override
	public Optional<User> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public void deleteEntity(User entity) {
		repository.delete(entity);
	}

	@Override
	public void deleteAllEntity() {
		repository.deleteAll();
	}

}
