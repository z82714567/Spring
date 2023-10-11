package kr.ch09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.ch09.entity.UserEntity;
import kr.ch09.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void insertUser(UserEntity user) {
		user.setPass(encoder.encode(user.getPass())); //user의 비밀번호를 bean으로 만들어둔 암호화 설정해서 비밀번호 set
		repo.save(user);
		
	}
	public UserEntity selectUser(String uid, String pass) {
		
		return repo.findUserEntityByUidAndPass(uid, pass);
	}
	
	
}
