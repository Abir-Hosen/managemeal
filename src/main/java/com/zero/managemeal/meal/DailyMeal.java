package com.zero.managemeal.meal;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zero.managemeal.user.User;

@Entity
public class DailyMeal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long cost;
	private String item;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date();
	
	//Mapping
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "manager")
	private User manager;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	@JoinTable(name = "meal_attend_user", joinColumns = @JoinColumn(name = "meal_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> attend_user;
	
	public DailyMeal() {
		super();
	}

	public DailyMeal(long id, long cost, String item, Date date, User manager, List<User> attend_user) {
		super();
		this.id = id;
		this.cost = cost;
		this.item = item;
		this.date = date;
		this.manager = manager;
		this.attend_user = attend_user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public List<User> getAttend_user() {
		return attend_user;
	}

	public void setAttend_user(List<User> attend_user) {
		this.attend_user = attend_user;
	}

	@Override
	public String toString() {
		return "DailyMeal [id=" + id + ", cost=" + cost + ", item=" + item + ", date=" + date + ", manager=" + manager
				+ ", attend_user=" + attend_user + "]";
	}

}
