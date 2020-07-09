package com.tcs.project.sash.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_credentails")
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	private String username;
	private String password;
	private UserType type;
	
	public User()	{	}
	
	public User(String username, String password, UserType type)
	{
		this.username = username;
		this.password = password;
		this.type = type;
	}	
	
	public long getUserId() 	{	return userId;}
	public String getUsername() {	return username;	}
	public String getPassword() {	return password;	}
	public UserType getType() 	{	return type;		}
	
	public User setUserId(long userId) 			{	this.userId = userId;		return this;	}
	public User setUsername(String username) 	{	this.username = username;	return this;	}
	public User setPassword(String password) 	{	this.password = password;	return this;	}
	public User setType(UserType type) 			{	this.type = type;			return this;	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", type=" + type + "]";
	}
}
