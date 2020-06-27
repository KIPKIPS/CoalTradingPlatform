package com.isscollege;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.isscollege.interceptors.CheckLoginInterceptor;
@SpringBootApplication
@Controller
public class SpringBootApplicationStart extends WebMvcConfigurerAdapter {
	public static void main(String[] args) {
		System.out.println("开始...");
		SpringApplication.run(SpringBootApplicationStart.class, args);
		System.out.println("结束...");
	}

	@RequestMapping(value = "/init")
	@ResponseBody
	public String init() {
		System.out.println("init...");
		return "hello,springboot";
	}

	// 配置错误页面
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return (container -> {
			ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
			ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
			container.addErrorPages(error401Page, error404Page, error500Page);
		});
	}

	@Autowired
	private CheckLoginInterceptor checkLoginInterceptor;

	// 注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(checkLoginInterceptor).addPathPatterns("/user/login");
	}

}
