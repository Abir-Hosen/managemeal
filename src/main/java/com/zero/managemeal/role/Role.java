package com.zero.managemeal.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	@NotBlank(message = "Please enter role name!")
	@Size(min = 1, max = 50)
	private String name;
	@Column(nullable = false)
	@NotBlank(message = "Please enter role description!")
	@Size(min = 1, max = 500)
	private String description;
	
	public Role() {
		super();
	}

	public Role(long id, @NotBlank(message = "Please enter role name!") @Size(min = 1, max = 50) String name,
			@NotBlank(message = "Please enter role description!") @Size(min = 1, max = 500) String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
