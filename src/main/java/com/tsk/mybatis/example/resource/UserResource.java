package com.tsk.mybatis.example.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsk.mybatis.example.mapper.UsersMapper;
import com.tsk.mybatis.example.model.Users;

@RestController
@RequestMapping("/rest/users")
public class UserResource {
	
	@Autowired
	private UsersMapper usersMapper;

	public UserResource(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	@GetMapping("/all")
	public List<Users> getAllUsers(){
		return usersMapper.findAll();
	}
	
	@GetMapping("/{name}")
	public Users getUsers(@PathVariable("name") String name) {
		return usersMapper.findByName(name);
	}
	
	
	@GetMapping("/update")
	private List<Users> update(){
		Users users = new Users();
		users.setName("tsr");
		users.setSalary(14500);
		
		usersMapper.insert(users);
		
		return usersMapper.findAll();
	}
	
}
