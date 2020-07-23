package com.zero.managemeal.role;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RestController
@RequestMapping("api/role")
public class RoleController {
	
	@Autowired
	private RoleService service;
	
	@GetMapping
	public ResponseEntity<List<Role>> AllEntity(){
		return ResponseEntity.ok(service.allEntity());
	}
	
	@PostMapping
	public ResponseEntity<Role> addEntity(@RequestBody @Valid Role entity, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			service.addEntity(entity);
			return ResponseEntity.ok(entity);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Role> updateEntity(@RequestBody @Valid Role entity, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			service.addEntity(entity);
			return ResponseEntity.ok(entity);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping
	public ResponseEntity<Role> deleteEntity(@RequestBody Role entity) {
		service.deleteEntity(entity);
		return ResponseEntity.ok(entity);
	}
}
