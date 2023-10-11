package ch03.sub3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



/*
 * 날짜 : 2023/09/19 
 * 이름 : 노수현
 * 내용 : 어노테이션 기반 AOP 실습하기
 *
 * - 어드바이스 유형
 *  before : 포인트컷이 실행되기 전에 실행되는 어드바이스
 *  after : 포인트컷이 실행된 후 실행되는 어드바이스
 *  after-returning : 포인트컷이 리턴한 다음 실행되는 어드바이스, after 직전에 먼저 실행
 *  after-throwing : 포인트컷이 예외가 발생했을때 실행되는 어드바이스
 *  around : 포인트컷이 실행되기 전,후에 실행되는 어드바이스
 * 
 */
public class AnnotationAOPTest {

	public static void main(String[] args) {
		
				//스프링 컨텍스트 객체 생성(컨테이너)
				ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
				
				//Service 객체 가져오기
				Service service = (Service) ctx.getBean("service2");
				
				//핵심관심 실행
				service.insert();
				service.select();
				service.update(1);
				service.delete(1, "홍길동");
				
				try {
					service.delete(2, null);	
				}catch (Exception e) {
					System.out.println("예외발생!");
				}
		
	}
}
