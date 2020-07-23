package com.zero.managemeal.role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

	public List<Role> allEntity();
	public Optional<Role> findById(Long id);
	public Role findByName(String name);
	public void addEntity(Role entity);
	public void deleteEntity(Role entity);
	public void deleteAllEntity();
}
