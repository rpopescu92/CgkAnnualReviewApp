package com.cegeka.app.CgkAnnualReviewApp.dao;

import java.util.List;

import com.cegeka.app.CgkAnnualReviewApp.model.User;

public interface UserDao {

	User findByName(String name);
	
	List<User> findAll();

}