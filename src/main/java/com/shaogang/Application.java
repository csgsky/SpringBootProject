package com.shaogang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
// 强制使用 cglib 代理
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(new Object[]{
				Application.class
		}, args);
	}
}

