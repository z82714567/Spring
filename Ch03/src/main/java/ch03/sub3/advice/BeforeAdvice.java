package ch03.sub3.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAdvice {

	@Pointcut("execution(* ch03.sub3.Service.insert(..))")
	public void insertPointcut() {}
	
	@Pointcut("execution(* ch03.sub3.Service.select(..))")
	public void selectPointcut() {}
	
	@Before("insertPointcut() || selectPointcut()")
	public void before1() {
		System.out.println("횡단관심 - before1...");
	}
	
	public void before2() {
		System.out.println("횡단관심 - before2...");
	}
	
	public void before3() {
		System.out.println("횡단관심 - before3...");
	}
	
}