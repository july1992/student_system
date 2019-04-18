package com.vily.student_system.config;


import com.vily.student_system.intercepter.MyInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-03-27
 *  
 **/

@SpringBootConfiguration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    MyInterceptor localInterceptor(){
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login");
    }

    // 跨域支持
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
