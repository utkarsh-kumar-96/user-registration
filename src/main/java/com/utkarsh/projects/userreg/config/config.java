package com.utkarsh.projects.userreg.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class config {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.port}")
    private String port;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(Integer.parseInt(port));
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.putAll(getPropMap());
        return mailSender;
    }

    private Map<String, String> getPropMap() {
        Map<String, String> map = new HashMap<>();
        map.put("spring.properties.mail.smtp.auth","true");
        map.put("spring.properties.mail.smtp.starttls.enable","true");
        map.put("spring.properties.mail.smtp.starttls.required","true");
        map.put("spring.properties.mail.smtp.connectiontimeout","5000");
        map.put("spring.properties.mail.smtp.timeout","3000");
        map.put("spring.properties.mail.smtp.writetimeout","3000");
        return map;
    }
}
