package kr.ch07.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor //파라미터 없는 생성자를 생성
@Builder
//@Data (get,set,to만 됨)
public class User1DTO {

	private String uid;
	private String name;
	private String hp;
	private int age;
	
}
