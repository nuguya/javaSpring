package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LogAdvice {

	@Before("PointcutCommon.allPointcut()")
	public void printLog() {
		System.out.println("[���� �α�] �����Ͻ� ���� ���� �� ����");
	}
}
