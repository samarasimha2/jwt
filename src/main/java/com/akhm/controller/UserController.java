package com.akhm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhm.bo.UserBO;
import com.akhm.dao.model.User;
import com.akhm.dao.model.UserRequest;
import com.akhm.dao.model.UserResponse;
import com.akhm.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserBO userBO;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user)
	{
		 Integer id=userBO.saveUser(user);
		 String body="User'"+id+"'saved";
		 
		return new ResponseEntity<String>(body,HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest request)
	{
		
		String token=jwtUtil.generateToken(request.getUsername());
		
		return ResponseEntity.ok(new UserResponse(token,"success"));
	}

}
