package kr.ch11.controller;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ch11.dto.UserRequestDTO;
import kr.ch11.entity.UserEntity;
import kr.ch11.jwt.JwtProvider;
import kr.ch11.security.MyUserDetails;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //생성자 방식으로 주입(여러개 한 번에 주입)
@RestController
public class UserController {

	private final AuthenticationManager authenticationManager;
	private final JwtProvider jwtProvider;

	@PostMapping("/login") //폼데이터 아닌 JSON
	public Map<String, String> login(@RequestBody UserRequestDTO dto) {
		
		try {
			//security 인증처리(SecurityUserService의 메서드 실행 됨-DB조회)
			UsernamePasswordAuthenticationToken AuthenticationToken 
			= new UsernamePasswordAuthenticationToken(dto.getUid(), dto.getPass());
		
			Authentication authentication = authenticationManager.authenticate(AuthenticationToken); 
			MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
			
			UserEntity user = userDetails.getUser();
			
			//토큰 발급
			String accessToken = jwtProvider.createToken(user, 1); // 1일
			String refreshToken = jwtProvider.createToken(user, 7); // 7일
			
			Map<String, String> resultMap = Map.of("grantType", "Bearer",
													"accessToken", accessToken,
													"refreshToken", refreshToken);
			return resultMap;
			
		}catch(Exception e) {
			Map<String, String> resultMap = Map.of("grantType", "None",
													"message", e.getMessage());
			
			return resultMap;
			
		}
		
	}
	
}
