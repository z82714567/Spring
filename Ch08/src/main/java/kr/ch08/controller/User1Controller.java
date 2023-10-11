package kr.ch08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ch08.dto.User1DTO;
import kr.ch08.service.User1Service;

@Controller
public class User1Controller {

	@Autowired
	private User1Service service;
	
	@GetMapping("/User1/list")
	public String list(Model model) {
		List<User1DTO> users = service.selectUser1s();
		model.addAttribute("users", users);
		return "/User1/list";
	}
	
	@GetMapping("/User1/register")
	public String register() {
		return "/User1/register";
	}

	@PostMapping("/User1/register")
	public String register(User1DTO dto) {
		service.insertUser1(dto);
		return "redirect:/User1/list";
	}
	
	@GetMapping("/User1/modify")
	public String modify(String uid, Model model) {
		User1DTO user = service.selectUser1(uid);
		model.addAttribute("user", user);
		return "/User1/modify";
	}
	
	@PostMapping("/User1/modify")
	public String modify(User1DTO dto) {
		service.updateUser1(dto);
		return "redirect:/User1/list";
	}
	
	@GetMapping("/User1/delete")
	public String modify(String uid) {
		service.deleteUser1(uid);
		return "redirect:/User1/list";
	}
	

	
	
}
