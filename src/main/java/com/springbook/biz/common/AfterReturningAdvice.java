package com.springbook.biz.common;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.user.UserVO;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
		}
		
//		System.out.println("[사후 처리] "+method+"() 메소드 리턴값 : "+returnObj.toString());
	}
}
