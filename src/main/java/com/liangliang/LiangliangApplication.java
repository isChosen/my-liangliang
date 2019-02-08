package com.liangliang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liangliang.dao")
public class LiangliangApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiangliangApplication.class, args);
	}

}
