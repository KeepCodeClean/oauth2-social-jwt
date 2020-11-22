package com.keepcodeclean.jwtsocial;

import com.keepcodeclean.jwtsocial.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class JwtSocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtSocialApplication.class, args);
    }

}
