package com.zero.managemeal.role;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

	public Role findByName(String name);
}
