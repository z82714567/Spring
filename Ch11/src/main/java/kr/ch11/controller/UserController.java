package kr.ch11.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ch11.dto.UserRequestDTO;
import kr.ch11.entity.UserEntity;
import kr.ch11.jwt.JwtProvider;
import kr.ch11.repository.UserRepository;
import kr.ch11.security.MyUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RestController
public class UserController {

	private final AuthenticationManager authenticationManager;
	private final JwtProvider jwtProvider;
	private final UserRepository userRepository; 
	

	@CrossOrigin("*")
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody UserRequestDTO dto) {
		
		log.info("dto : " + dto);
		
		// Security 인증처리
		UsernamePasswordAuthenticationToken authenticationToken
			= new UsernamePasswordAuthenticationToken(dto.getUid(), dto.getPass());
		
		Authentication authentication = authenticationManager.authenticate(authenticationToken);  
		MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
		
		UserEntity user = userDetails.getUser();
		user.setPass(null);
		
		
		// 토큰발행
		String accessToken = jwtProvider.createToken(user, 3);  // 1일
		String refreshToken = jwtProvider.createToken(user, 10); // 7일
		
		Map<String, Object> resultMap = Map.of("grantType", "Bearer", 
											   "accessToken", accessToken,
											   "refreshToken", refreshToken,
											   "user", user);
		
		return resultMap;
			
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/users")
	public ResponseEntity<Object> getUsers(Authentication authentication) {
		
		if(authentication != null && authentication.isAuthenticated()) {
			List<UserEntity> users = userRepository.findAll();
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(users);
			
		}else {
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body("UNAUTHORIZED");
			
		}
	}
	
	
}