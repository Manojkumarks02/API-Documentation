package com.exception.demo.exception.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.exception.demo.exception"))
                .build()
                .apiInfo(apiCustomData());
    }

    private ApiInfo apiCustomData(){
        return new ApiInfo(
                "Product API Application",
                "Product Documentation",
                "1.0",
                "Product Service Terms",
                new Contact("Manoj kumar", "http://manojkumar.com",
                        "manojkumarks063@gmail.com"),
                "manojkumar group License",
                "http://manojkumar.com"
        );
    }
}
