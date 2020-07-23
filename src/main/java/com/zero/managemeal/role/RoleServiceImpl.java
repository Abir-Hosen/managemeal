package com.zero.managemeal.role;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository repository;

	@Override
	public List<Role> allEntity() {
		return (List<Role>) repository.findAll();
	}

	@Override
	public Optional<Role> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Role findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public void addEntity(Role entity) {
		repository.save(entity);
	}

	@Override
	public void deleteEntity(Role entity) {
		repository.delete(entity);
	}

	@Override
	public void deleteAllEntity() {
		repository.deleteAll();
	}

}
