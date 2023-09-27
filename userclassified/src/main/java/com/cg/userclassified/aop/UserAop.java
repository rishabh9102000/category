package com.cg.userclassified.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class UserAop {
	Logger log = LoggerFactory.getLogger(UserAop.class);
	@Autowired
	ObjectMapper mapper;
	  @Pointcut(value = "execution(* com.cg.Admin.services.*.*(..))")
	    public void myPointCut(){

	    }
	  @Around("myPointCut()")
	    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable{
	        String methodName = pjp.getSignature().getName();
	        String className = pjp.getTarget().getClass().toString();
	        Object[] array = pjp.getArgs();
	        log.info("method invoked "+className+" : "+methodName+"()"+"arguments : "+mapper.writeValueAsString(array));
	        Object object = pjp.proceed();
	        log.info(className+" : "+methodName+"()"+"Response : "+mapper.writeValueAsString(object));
	        return object;

	    }
}
