package com.shaogang.bean;

import lombok.Data;
/**
 * Created by allen on 17/11/28.
 */

//@Configuration
//@ConfigurationProperties(prefix = "com.chen")
//@PropertySource("classpath:test.properties")
@Data
public class ConfigBean {
    private String name;
    private String want;

}
