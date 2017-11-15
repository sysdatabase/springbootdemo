package com.hirisun.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testStandardPasswordEncoder(){
		StandardPasswordEncoder standardPasswordEncoder = new StandardPasswordEncoder();
		System.out.println(standardPasswordEncoder.encode("123456"));
	}

}
