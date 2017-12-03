package com.shaogang.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Created by allen on 17/12/3.
 */
@Data
@Component
public class BlogProperties {
    @Value("${com.shaogang.name}")
    private String name;

    @Value("${com.shaogang.want}")
    private String want;

}
