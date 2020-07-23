package com.zero.managemeal.user;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.zero.managemeal.role.Role;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	@NotBlank(message = "Please enter your first name!")
	@Size(min = 1, max = 50)
	private String firstname;
	@Column(nullable = false)
	@NotBlank(message = "Please enter your last name!")
	@Size(min = 1, max = 50)
	private String lastname;
	@Column(nullable = false)
	@NotBlank(message = "Please enter your username!")
	@Size(min = 1, max = 30)
	private String username;
	@Column(nullable = false)
	@NotBlank(message = "Please enter your email!")
	@Email(message = "Invalid email address!")
	private String email;
	@Column(nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateOfBirth = new Date();
	@Column(nullable = false)
	@NotBlank(message = "Please enter your password!")
	@Size(min = 4, max = 100)
	private String password;
	@Transient
	private String confirmPassword;
	@Column(nullable = false)
	private boolean active = true;

	// Mapping
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_roles")
	private Role role;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "super_user")
	private User superUser;

	public User() {
		super();
	}
 
	public User(long id, @NotBlank(message = "Please enter your first name!") @Size(min = 1, max = 50) String firstname,
			@NotBlank(message = "Please enter your last name!") @Size(min = 1, max = 50) String lastname,
			@NotBlank(message = "Please enter your username!") @Size(min = 1, max = 30) String username,
			@NotBlank(message = "Please enter your email!") @Email(message = "Invalid email address!") String email,
			Date dateOfBirth,
			@NotBlank(message = "Please enter your password!") @Size(min = 4, max = 100) String password,
			String confirmPassword, boolean active, Role role, User super_user) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.active = active;
		this.role = role;
		this.superUser = super_user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getSuperUser() {
		return superUser;
	}

	public void setSuperUser(User superUser) {
		this.superUser = superUser;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", active=" + active + ", role=" + role + ", superUser=" + superUser + "]";
	}

}
