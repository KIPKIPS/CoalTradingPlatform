package com.isscollege;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.isscollege.interceptor.LoginInterceptor;

@SpringBootApplication
@Configuration
@Controller("/")
@MapperScan("com.isscollege.*")
public class SpringBootApplicationStart extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		System.out.println("SpringBoot Start....");
		SpringApplication.run(SpringBootApplicationStart.class, args);
		System.out.println("End....");

	}

	@GetMapping("/")
	public String init() {
		return "redirect:admin/index";
	}

	@Override
	// 定义拦截器注册方法
	public void addInterceptors(InterceptorRegistry registry) {
		// 添加自定义拦截器和拦截路径，此处对所有请求(除了登录界面，验证码方法和登录方法)进行拦截
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(
				"/admin/createValicode", "/admin/index", "/admin/login", "/finance/login", "/trader/login",
				"/trader/registpage", "/trader/firstregist", "/trader/getAccountInfoBycName",
				"/trader/updateUserAccountInfoBycName", "/purch/*");
		;
	}

}