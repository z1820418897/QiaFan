package com.wz.qiafan.config;

import com.wz.qiafan.util.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

//    @Value("${gcFilePath}")
//    private String gcFilePath;
//
//    /**
//     * 视图解析器
//     * */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
////        registry.addViewController("/").setViewName("login");
////        registry.addViewController("/index").setViewName("index");
////        registry.addViewController("/version-page").setViewName("version");
//    }
//
//    /**
//     * 拦截器管理
//     * */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns(
//                        /*app访问接口 不需要登录*/
//                        "/find-version",
//
////                        /*映射本地文件*/
////                        "/file/**",
//
//                        /*登录相关*/
//                        "/",
//
//                        /*放过登录接口*/
//                        "/login",
//
//                        /*静态资源*/
//                        "/js/**",
//                        "/css/**",
//                        "/layui/**");
//    }
//
//
//    /**
//     * 本地资源映射
//     * */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/file/**").addResourceLocations("file:"+gcFilePath);
//    }

}
