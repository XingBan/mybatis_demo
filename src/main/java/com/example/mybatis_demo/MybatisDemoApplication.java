package com.example.mybatis_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//如果有很多mapper可以使用使用一下注解，它会自动扫描包的文件
@MapperScan(basePackages= {"com.example.mybatis_demo.mybatis_annotation.dao"})
@SpringBootApplication
//@MapperScan("com.example.mybatis_demo.mapper")
public class MybatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);
	}
}
