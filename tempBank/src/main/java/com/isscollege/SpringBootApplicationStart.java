package com.isscollege;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Controller
@MapperScan("com.isscollege.*")
public class SpringBootApplicationStart extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		System.out.println("SpringBoot Start....");
		SpringApplication.run(SpringBootApplicationStart.class, args);
		System.out.println("End....");

	}

	@RequestMapping("/")
	public String init() {
		return "redirect:bank/index";
	}

}