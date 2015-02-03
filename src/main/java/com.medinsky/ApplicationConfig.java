package com.medinsky;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.medinsky.demo.entity.DemoData;
import com.medinsky.demo.util.gson.DemoDataAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Aleksandr on 28.01.2015.
 */
@Configuration
@EnableWebMvc
@Import(DataConfig.class)
public class ApplicationConfig extends WebMvcConfigurerAdapter{

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/html/");
        viewResolver.setSuffix(".html");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DemoData.class, new DemoDataAdapter());
        return gsonBuilder.create();
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/html/**").addResourceLocations("/html/");
        registry.addResourceHandler("/theme/css/**").addResourceLocations("/theme/css/");
        registry.addResourceHandler("/theme/images/**").addResourceLocations("/theme/images/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }
}
