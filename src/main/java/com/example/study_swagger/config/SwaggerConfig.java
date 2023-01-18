package com.example.study_swagger.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //    SWAGGER_2 : 상수
//    basePackage : 어디로 범위하여 스캔할지 정의
//    htts 설정시 여기에서 수정 필요
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.study_swagger"))
//                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumeContentTypes = new HashSet<>();

        consumeContentTypes.add("application/json;charset=UTF-8");
        consumeContentTypes.add("application/x-www-form-urlencoded");

        return consumeContentTypes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produceContentTypes = new HashSet<>();

        produceContentTypes.add("application/json;charset=UTF-8");

        return produceContentTypes;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("cleancode API")
                .description("document init API")
                .version("1.0.0")
                .build();
    }
}
