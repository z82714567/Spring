package kr.ch10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ch10.entity.User3Entity;
import kr.ch10.service.User3Service;

@RestController //일반controller+@ResponseBody
public class User3Controller {

	@Autowired
	private User3Service service;
	
	@GetMapping("/user3")
	public List<User3Entity> list() {
		List<User3Entity> user3s = service.selectUser3s();
		return user3s;
	}
	
	@GetMapping("/user3/{id}")
	public User3Entity user3(@PathVariable("id") String id) {
		return service.selectUser3(id);
	}
	
	@PostMapping("/user3")
	public void register(User3Entity user3) {
		service.insertUser3(user3);
	}
	
	@PutMapping("/user3")
	public void modify(User3Entity user3) {
		service.updateUser3(user3);
	}
	
	@DeleteMapping("/user3/{id}")
	public void delete(@PathVariable("id") String id) {
		service.deleteUser3(id);
	}
	
}
