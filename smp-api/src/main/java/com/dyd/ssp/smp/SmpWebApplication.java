package com.dyd.ssp.smp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//启用缓存
@EnableCaching
@MapperScan("com.dyd.ssp.smp.mapper")
public class SmpWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmpWebApplication.class, args);

	}




}
