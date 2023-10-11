package ch03.sub3.advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowAdvice {

	@Pointcut("execution(* ch03.sub3.Service.delete(..))")
	public void deletePointcut() {}
	
	
	@AfterThrowing("deletePointcut()")
	public void afterThrow1() {
		System.out.println("횡단관심 - afterThrow1...");
	}
	
	public void afterThrow2() {
		System.out.println("횡단관심 - afterThrow2...");
	}
	
	public void afterThrow3() {
		System.out.println("횡단관심 - afterThrow3...");
	}
	
}