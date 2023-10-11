package ch03.sub3.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAdvice {

	@Pointcut("execution(void ch03.sub3.*Service.insert())")
	public void insertPointcut() {}
	
	@Pointcut("execution(* ch03.sub3.Service.select(..))")
	public void selectPointcut() {}
	
	@After("insertPointcut()")
	public void after1() {
		System.out.println("횡단관심 - after1...");
	}
	
	@After("selectPointcut()")
	public void after2() {
		System.out.println("횡단관심 - after2...");
	}
	
	public void after3() {
		System.out.println("횡단관심 - after3...");
	}
	
}
