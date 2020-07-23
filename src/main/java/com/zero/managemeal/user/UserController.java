package com.zero.managemeal.user;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zero.managemeal.abc.ConstantFactory;
import com.zero.managemeal.abc.RequestParameter;
import com.zero.managemeal.role.RoleService;


@Transactional
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	@Autowired
	private RoleService roleService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping
	public ResponseEntity<Page<User>> findAllBySortAndOrder(RequestParameter requestParameter, HttpSession session) {
		logger.info("Entering GET method");
		Page<User> page = service.findAllBySortAndOrder(requestParameter);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> SingleEntityById(@PathVariable Long id){
		Optional<User> entity = service.findById(id);
		if(entity.isPresent()) {
			return ResponseEntity.ok(entity);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<User> addEntity(@RequestBody @Valid User entity, BindingResult bindingResult, HttpSession httpSession) {
		if(!bindingResult.hasErrors()) {
			entity.setRole(roleService.findByName(ConstantFactory.USER));
			System.out.println((User) httpSession.getAttribute("user"));
			entity.setSuperUser((User) httpSession.getAttribute("user"));
			entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
			service.addEntity(entity);
			return ResponseEntity.ok(entity);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateEntity(@PathVariable Long id, @RequestBody @Valid User entity, BindingResult bindingResult, HttpSession httpSession) {
		if(!bindingResult.hasErrors()) {
			if(bCryptPasswordEncoder.matches(entity.getConfirmPassword(), service.findByEmail((String) httpSession.getAttribute("email")).getPassword())) {
				service.addEntity(entity);
				return ResponseEntity.ok(entity);
			}
			else {
				System.out.println("Password doesn't match!");
				return ResponseEntity.badRequest().build();
			}
		}else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteEntity(@PathVariable Long id) {
		service.deleteEntity(id);
		return ResponseEntity.ok(null);
	}
}