package kr.ch07.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ch07.dto.User1DTO;
import kr.ch07.dto.User6DTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class User6MapperTest {
	
	@Autowired
	private User6Mapper mapper;

	//@Test
	public void insertUser6() {
		User6DTO user6 = User6DTO.builder()
				.uid("A102")
				.name("홍동동")
				.birth("1999-10-02")
				.gender("M")
				.age(44)
				.addr("서울")
				.hp("010-4444-1003")
				.build();
		mapper.insertUser6(user6);
	}
	//@Test
	public User6DTO selectUser6(String uid) {
		
		
		User6DTO user = mapper.selectUser6(uid);
		
			log.info(user.toString());
			
			return user;
	}
	
	//@Test
	public void selectUser6s() {
		List<User6DTO> users = mapper.selectUser6s();
		
		for(User6DTO user : users) {
			log.info(users.toString());
		}
		
	}
	
	public void updateUser6(User6DTO dto) {
		
	}
	public void deleteUser6(String uid) {
		
	}
	
}
