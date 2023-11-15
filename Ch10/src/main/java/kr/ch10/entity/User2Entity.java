package kr.ch10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.ch10.dto.User2DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="User2")
public class User2Entity {
	
	@Id
	private String uid;
	private String name;
	private String hp;
	private int age;
	
	// DTO 변환 메서드
	public User2DTO toDTO() {
		
		return User2DTO.builder()
				.uid(uid)
				.name(name)
				.hp(hp)
				.age(age)
				.build();
	}
}