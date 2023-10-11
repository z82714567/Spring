package kr.ch11.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.ch11.entity.UserEntity;
import kr.ch11.repository.UserRepository;

@Service
public class SecurityUserService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 패스워드에 대한 검사는 이전 컴포넌트(AuthenticationProvider)에서 처리되어 사용자 아이디만 넘어옴		
		UserEntity user = repo.findById(username).get();
		
		// 사용자 인증객체 생성(세션에 저장)
		UserDetails userDetails = MyUserDetails.builder()
									.user(user)
									.build();
		
		return userDetails;
	}

}