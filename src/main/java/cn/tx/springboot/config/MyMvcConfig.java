package cn.tx.springboot.config;

//import cn.tx.springboot.interceptor.LoginInterceptor;

import cn.tx.springboot.interceptor.LoginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@MapperScan("cn.tx.springboot.dao")
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/toLogin").setViewName("login");
        registry.addViewController("/header").setViewName("header");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/menu").setViewName("menu");
        registry.addViewController("/add").setViewName("add");


    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List<String> excludePatterns = new ArrayList<String>();
        excludePatterns.add("/css/**");
        excludePatterns.add("/images/**");
        excludePatterns.add("/toLogin");
        excludePatterns.add("/login");
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludePatterns);


    }


}
