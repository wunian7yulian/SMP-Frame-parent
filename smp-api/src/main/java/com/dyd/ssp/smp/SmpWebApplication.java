package com.dyd.ssp.smp;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dyd.ssp.smp.mapper")
public class SmpWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmpWebApplication.class, args);

	}

}
