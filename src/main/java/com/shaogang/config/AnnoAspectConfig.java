package com.shaogang.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by allen on 18/1/21.
 */
@Aspect
@Component
public class AnnoAspectConfig {

    @Pointcut("@annotation(com.shaogang.anno.AdminOnly)")
    public void matchAnno(){}

    @Before("matchAnno()")
    public void beforeMatch(){
        System.out.println("====== anno =========");
    }
}
