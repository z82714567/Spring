package kr.ch08.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import kr.ch08.dto.User1DTO;
import kr.ch08.entity.User1Entity;
import kr.ch08.repository.User1Repository;

@Service
public class User1Service {
	
	@Autowired
	private User1Repository repo;

	public void insertUser1(User1DTO dto) {
		//DTO를 엔티티로 변환
		User1Entity entity = dto.toEntity();
		repo.save(entity); 
	}
	
	public User1DTO selectUser1(String uid) {
		
		Optional<User1Entity> result = repo.findById(uid);
		
		//Entity를 DTO로 변환
		User1DTO dto= result.get().toDTO();
		return dto;
	}
	
	public List<User1DTO> selectUser1s() {
		//List<Entity>를 List<DTO>로 변환
		List<User1DTO> list = repo.findAll()
									.stream()
									.map(Entity -> User1DTO.builder()
											.uid(Entity.getUid())
											.name(Entity.getName())
											.hp(Entity.getHp())
											.age(Entity.getAge())
											.build())
									.collect(Collectors.toList());
		return list;
	}
	
	public void updateUser1(User1DTO dto) {
		//dto를 엔티티로 변환
		User1Entity entity = dto.toEntity();
		repo.save(entity); //pk값을 보고 insert, update 구분처리 해줌
	}
	
	public void deleteUser1(String uid) {
		repo.deleteById(uid);
	}
	
	
	
}
