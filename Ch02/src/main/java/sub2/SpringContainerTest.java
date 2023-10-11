package sub2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2023/09/18 
 * 이름 : 노수현
 * 내용 : 스프링 컨테이너 실습하기
 * 
 * DI
 *  - Dependency Injection은 의존성 주입 의미로 객체를 생성하는 방식이 아닌 컨테이너로부터 주입 받는 방식
 *  - 생성자, 세터, 필드 3가지 주입 방식 있음
 *  - @Component 선언으로 객체를 컨테이너에 관리,등록함
 *  - @Component는 @Controller, @Service, @Repository로 세분화 
 */ 

public class SpringContainerTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		Computer com = (Computer) ctx.getBean("com");
		com.show();
		
	}
}
