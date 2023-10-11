package ch03.sub3.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAdvice {

	@Pointcut("execution(void ch03.sub3.*Service.insert())")
	public void insertPointcut() {}
	
	@Around("insertPointcut()")
	public void around1(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("횡단관심 - around1-1...");
		pjp.proceed(); // 핵심관심(포인트컷) 실행
		System.out.println("횡단관심 - around1-2...");
		
	}
	
	public void around2(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("횡단관심 - around2-1...");
		pjp.proceed(); // 핵심관심(포인트컷) 실행
		System.out.println("횡단관심 - around2-2...");
		
	}
	
	public void around3(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("횡단관심 - around3-1...");
		pjp.proceed(); // 핵심관심(포인트컷) 실행
		System.out.println("횡단관심 - around3-2...");
		
	}	
}