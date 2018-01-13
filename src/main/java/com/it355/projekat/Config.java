package com.it355.projekat;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter {

    @Autowired
    private EntityManagerFactory emf;


    @Bean
    public SessionFactory getSessionFactory(){
        if(emf.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("Not a hibernate factory!");
        }
        return emf.unwrap(SessionFactory.class);
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/images/**", "/resources/**", "/webjars/**", "/**", "/images/icon.ico", "/css/**").addResourceLocations("classpath:/META-INF/resources/images",
                "classpath:/images/", "classpath:/META-INF/resources/webjars/", "classpath:/META-INF/resources/", "classpath:/META-INF/static/", "/", "classpath:/css/");
    }
}
