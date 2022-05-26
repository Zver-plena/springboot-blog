package com.example.blog.config;

import com.example.blog.interceptor.Login;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MvcConfig
 * @Author mrl
 * @Date 2022/5/1 22:12
 * @Version 1.6
 * @Description TODO
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    /**
     * @ClassName : MvcConfig
     * @Author : mrl
     * @Date: 2022/5/2 00:15
     * @return:
     * @Description : Interceptros ：拦截器 ，addPathPatterns:拦截路径 ，
     *                excludePathPatterns:除去不拦截的路径
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Login())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/",
                        "/user/login",
                        "/login.html",
                        "/css/**",
                        "/js/**",
                        "/fonts/**",
                        "/images/**",
                        "/user/register",
                        "/register.html"
                );
    }
}
