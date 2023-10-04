package com.cg.ad.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.fasterxml.jackson.databind.ObjectMapper;

public class LoggingAdvice {
Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Autowired ObjectMapper mapper;
	
	@Pointcut(value = "execution(* com.cg.ad.service.*.*(..) )")
	public void myAd() {
		
	}
	
	@Around("myAd()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();//the actual instance of the class
		Object[] array = pjp.getArgs();

		log.info("Method invoked " + className + " : " + methodName + "()" + "arguments "
				+ mapper.writeValueAsString(array));//json
		log.info("Hello");

		mapper.writeValueAsString(array);
		Object object = pjp.proceed();

		 //Capture the response
		log.info(className + " : " + methodName + "()" + "Response : " + mapper.writeValueAsString(object));

		return object;
	}
}

