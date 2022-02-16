package com.zee.zee5app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserServiceAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(@org.springframework.stereotype.Repository *) "
			+ "|| within(@org.springframework.stereotype.Service *)"
			+ "|| within(@org.springframework.web.bind.annotation.RestController  *)")
	public void springPointCutExp() {

	}

	@Pointcut("within(com.zee.zee5app.controller..*) " + "|| within(com.zee.zee5app.service.Impl..*)")
	public void springPointCutExp2() {

	}

	@AfterThrowing(pointcut = "springPointCutExp() && springPointCutExp2()", throwing = "e")
	public void logAfterThrowingException(JoinPoint joinPoint, Throwable e) {
		log.error("exception {}.{}() with cause {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
	}
	
//	@Around(value = "execution(* com.zee.zee5app.service.impl.*.get*(..))")
//	public void aroundAllServiceMethods(JoinPoint joinPoint) {
//		System.out.println("Hello");
//		System.out.println(joinPoint);
//	}

	@Before(value = "execution(* com.zee.zee5app.service.Impl.*.get*(..))")
	public void beforeAllServiceMethods(JoinPoint joinPoint) {
		System.out.println("hello");
		System.out.println(joinPoint);
	}
}
