package kr.ch09.security;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MyUserDetails implements UserDetails{ //MyUserDetails 인증 객체 -> sessUser로 저장됨
	private static final long serialVersionUID = -5532680704133363159L;
	
	
	private String uid;
	private String pass;
	private String name;
	private int age;
	private String hp;
	private String role;
	private LocalDateTime regDate;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//계정이 갖는 권한(여러 권한 있을 수 있어서 리스트) 목록
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		//반드시 접두어로 ROLE_ 입력해야 됨 그래야 hasRole(), hasAnyRole() 메서드가 처리됨 (기능 동일, 의미상의 차이)
		//만약 ROLE_ 접두어를 안쓰면 hasAuthority(), hasAnyAuthority() 메서드로 해야됨 (기능 동일, 의미상의 차이)
		authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
		return authorities;
	}

	@Override
	public String getPassword() {
		//계정이 갖는 비밀번호 
		return pass;
	}

	@Override
	public String getUsername() {
		//계정이 갖는 아이디(이름 아님)
		return uid;
	}

	@Override
	public boolean isAccountNonExpired() {
		//계정 만료 여부(true:만료안됨, false:만료)
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		//계정 잠김 여부(true:잠김안됨, false:잠김)
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//계정 비밀번호 만료 여부(true:만료안됨, false:만료)(3개월마다 비밀번호 주기적으로 변경)
		return true;
	}

	@Override
	public boolean isEnabled() {
		//계정 활성화 여부(true:활성화, false:비활성화)
		return true;
	}

}
