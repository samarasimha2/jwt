package com.akhm.bo.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.akhm.bo.UserBO;
import com.akhm.dao.UserDAO;
import com.akhm.dao.model.User;

@Service
public class UserBOImpl implements UserBO{
	@Autowired
	private UserDAO userDAO;


	@Override
	public Integer saveUser(User user) {
		return userDAO.save(user).getId();
		
	}

}
