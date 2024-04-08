package com.tipu.spring_aop;

import org.springframework.stereotype.Component;

@Component
public class AopClass {

    public void hello(){
        System.out.println("Hello World!");
    }

    public void printSomething(String something){
        System.out.println(something);
    }

    public Integer sum(Integer a, Integer b){
        return a + b;
    }
}
