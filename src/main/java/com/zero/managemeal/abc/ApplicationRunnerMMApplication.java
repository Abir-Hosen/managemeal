package com.zero.managemeal.abc;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.zero.managemeal.role.Role;
import com.zero.managemeal.role.RoleService;
import com.zero.managemeal.user.User;
import com.zero.managemeal.user.UserService;

@Component
public class ApplicationRunnerMMApplication implements ApplicationRunner {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationRunnerMMApplication.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		logger.info("Application started with application-runner arguments: {} \n"
				+ "- Author: Abir Hosen Ashik");
		if(isInstalled()==true) {
			System.out.println("System already up to date!");
		}else if(isInstalled()==false){
			System.out.println("System is way to up to date...");
			initRole();
			initUser();
			System.out.println("System is ready to use!");
		}
	}
	
	private Boolean isInstalled() {
		
		if(roleService.allEntity().isEmpty() && userService.allEntity().isEmpty()) {
			return false;
		}
		return true;
	}
	
	private void initRole() {
		
		roleService.addEntity(new Role(1, ConstantFactory.ADMIN, ConstantFactory.ADMIN_DEF));
		roleService.addEntity(new Role(2, ConstantFactory.MANAGE, ConstantFactory.MANAGE_DEF));
		roleService.addEntity(new Role(3, ConstantFactory.MEMBER, ConstantFactory.MEMBER_DEF));
		roleService.addEntity(new Role(4, ConstantFactory.USER, ConstantFactory.USER_DEF));
	}
	
	private void initUser() {

		User admin = new User(1, "Admin", "Admin", "username", "admin@gmail.com", new Date(), 
				"admin", "admin", true, roleService.findByName(ConstantFactory.ADMIN), null);

		User manager = new User(2, "Manager", "Manager", "manager", "manager@gmail.com", new Date(), 
				"manager", "manager", true,	roleService.findByName(ConstantFactory.MANAGE), admin);

		User member = new User(3, "Member", "Member", "member", "member@gmail.com", new Date(), 
				"member", "member", true, roleService.findByName(ConstantFactory.MEMBER), manager);

		User user = new User(4, "User", "User", "user", "user@gmail.com", new Date(), 
				"user", "user", true, roleService.findByName(ConstantFactory.USER), member);


		userService.signUp(admin);
		userService.signUp(manager);
		userService.signUp(member);
		userService.signUp(user);
	}

}
