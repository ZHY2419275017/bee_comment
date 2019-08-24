package com.mall.comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MallCommentApplication {
	
	@Bean // 向Spring容器中注册RestTemplate对象
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

    public static void main(String[] args) {
        SpringApplication.run(MallCommentApplication.class, args);
    }

}
