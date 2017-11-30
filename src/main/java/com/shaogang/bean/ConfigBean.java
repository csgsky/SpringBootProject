package com.shaogang.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/**
 * Created by allen on 17/11/28.
 */
@Configuration
@ConfigurationProperties(prefix = "com.chen")
@PropertySource("classpath:test.properties")
@Data
public class ConfigBean {
    private String name;
    private String want;
}
