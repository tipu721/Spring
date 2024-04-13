package com.tipu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		
	
		ApplicationContext context = new ClassPathXmlApplicationContext("src/main/java/spring.xml");
		
		Car obj = (Car)context.getBean("car");
		obj.drive();
		
		
//		Vehicle obj = (Vehicle) context.getBean("car");
//		obj.drive();
		
//		Tyre t = (Tyre)context.getBean("tyre");
//		System.out.println(t);
		
	}
}
