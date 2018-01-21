package com.shaogang;

import com.shaogang.service.ProductService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter1ApplicationTests {

    @Autowired
    ProductService mProductService;

//    @Test(expected = Exception.class)
//    public void annoInsertTest() {
//        CurrentUserHolder.set("allen");
//        mProductService.insert();
//    }

    @Test
    public void adminInsertTest() {
//        CurrentUserHolder.set("admin");
        mProductService.insert();
    }
}
