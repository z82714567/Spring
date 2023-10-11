package kr.ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ch07.dto.User6DTO;
import kr.ch07.service.User6Service;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class User6Controller {

	@Autowired
	private User6Service service;
	
	@GetMapping("/User6/register")
	public String register() {
		return "User6/register";
	}
	
	@GetMapping("/User6/list")
	public String list(Model model) {
		List<User6DTO> users = service.selectUser6s();
		model.addAttribute("users", users);
		return "User6/list";
	}
	
	@PostMapping("/User6/register")
	public String register(User6DTO dto) {
		service.insertUser6(dto);
		return "redirect:/User6/list";
	}
	
	@GetMapping("/User6/modify")
	public String modify(String uid, Model model) {
		User6DTO user = service.selectUser6(uid);
		model.addAttribute("user", user);
		return "User6/modify";
	}
	
	@PostMapping("/User6/modify")
	public String modify(User6DTO dto) {
		service.updateUser6(dto);
		return "redirect:/User6/list";
	}
	
	@GetMapping("/User6/delete")
	public String modify(String uid) {
		service.deleteUser6(uid);
		return "redirect:/User6/list";
	}
	
	
	
}
