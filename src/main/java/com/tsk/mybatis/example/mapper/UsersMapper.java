package com.tsk.mybatis.example.mapper;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.tsk.mybatis.example.model.Users;

@Mapper
public interface UsersMapper {

	@Select("select * from users")
	public List<Users> findAll();
	
	@Select("select * from users where name=#{name}")
	public Users findByName(@PathParam("name") final String name);
	
	@Insert("insert into users(name, salary) values(#{name},#{salary})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
	before = false, resultType = Integer.class)
	void insert(Users users);

}
