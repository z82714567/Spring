package kr.ch07.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = MainController.class)
public class MainControllerTest {
	
	//MVC 테스트를 위한 가상 mvc객체
	@Autowired
	private MockMvc mvc;
	
	
	
	@BeforeAll //처음 1번
	public static void beforeAll() {
		System.out.println("beforeAll...");
	}
	@BeforeEach //2 
	public void beforeEach() {
		System.out.println("beforeEach...");
	}
	@AfterAll //마지막 1번
	public static void AfterAll() {
		System.out.println("AfterAll...");
	}
	@AfterEach //4
	public void AfterEach() {
		System.out.println("AfterEach...");
	}
	
	
	
	 //3
	public void index() throws Exception {
		mvc
		.perform(get("/index")) //index 요청 테스트
		.andExpect(status().isOk()) //요청 결과 상태 테스트
		.andExpect(view().name("/index")) //반환되는 View 이름 테스트
		.andDo(print()); //요청 테스트 결과 출력
	}
	
	@Test
	public void include() throws Exception {
		mvc
		.perform(
				get("/include")
				.param("name", "홍길동")
				.param("age", "22")
		)
		.andExpect(status().isOk())
		.andExpect(view().name("/include"))
		.andDo(print());
		
	
	
	}
	
	
	public void layout() {
		System.out.println("layout...");
	}

}
