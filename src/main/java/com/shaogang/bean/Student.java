package com.shaogang.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by allen on 17/12/5.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private static final long serialVersionUID = 2120869894112984147L;
    private int id;
    private String name;
    private String age;
    private String gender;
}
