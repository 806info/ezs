package com.gpt806.ezs.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("EZS 806 SpringBoot 框架")
                        .description("快速开始")
                        .version("v1.0.0")
//                        .termsOfService("http://")
                        .contact(new Contact()
                                .name("Herb")
//                                .url("http://contact.url")
                                .email("herb2sy@gmail.com"))
//                        .license(new License()
//                                .name("许可证名称")
//                                .url("http://license.url"))
                )
                .addServersItem(new Server()
                        .url("http://localhost:9999")
                        .description("本地开发服务器"));
    }
}
