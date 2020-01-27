package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
	
		// 2. Spring 컨테이너로부터 필요한 객체를 요청 한다.
		// applictionContext.xml에 bean으로 정의되 있는 것 중에서 id가 tv인 객체를 가져옴.
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. Spring 컨테이너를 종료한다.
		factory.close();
	}

}
