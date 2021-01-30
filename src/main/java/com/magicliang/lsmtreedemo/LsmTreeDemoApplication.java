package com.magicliang.lsmtreedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 一定要加上排除注解，否则 SpringBoot 会默认寻找数据源
 * (exclude = {DataSourceAutoConfiguration.class})
 */
@SpringBootApplication
public class LsmTreeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LsmTreeDemoApplication.class, args);
	}

}
