package com.shaogang;

import com.shaogang.bean.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(new Object[]{
				Application.class
		}, args);
	}
}
