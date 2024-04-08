package com.tipu.spring_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringAopApplication.class, args);

        AopClass aopClass = context.getBean(AopClass.class);
        aopClass.hello();
        Integer res = aopClass.sum(10, 15);
        System.out.println(res);

        aopClass.printSomething("Hi Spring AOP");


        AnotherClass anotherClass = context.getBean(AnotherClass.class);
        anotherClass.anotherMethod(25);

    }

}
