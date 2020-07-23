package com.zero.managemeal.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	public User findByEmail(String email);

}
