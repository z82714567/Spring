package kr.ch10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="User1")
public class User1Entity {
	
	@Id
	private String uid;
	private String name;
	private String hp;
	private int age;
	
}