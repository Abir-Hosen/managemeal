package com.zero.managemeal.user;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.zero.managemeal.role.RoleService;


@Transactional
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService service;
	@Autowired
	private RoleService roleService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping
	public ResponseEntity<List<User>> AllEntity(){
		return ResponseEntity.ok(service.allEntity());
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
	public ResponseEntity<User> addEntity(@RequestBody @Valid User entity, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			entity.setRole(roleService.findByName(ConstantFactory.USER));
			entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
			service.addEntity(entity);
			return ResponseEntity.ok(entity);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<User> updateEntity(@RequestBody @Valid User entity, BindingResult bindingResult, HttpSession httpSession) {
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

	@DeleteMapping
	public ResponseEntity<User> deleteEntity(@RequestBody User entity) {
		service.deleteEntity(entity);
		return ResponseEntity.ok(entity);
	}
}