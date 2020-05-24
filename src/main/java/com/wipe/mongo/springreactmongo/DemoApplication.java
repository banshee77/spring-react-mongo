package com.wipe.mongo.springreactmongo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Docket get() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.paths(PathSelectors.ant("/api/**"))
		.apis(RequestHandlerSelectors.basePackage("com.wipe.mongo.springreactmongo.controller"))
		.build()
		.apiInfo(createApiInfo());
	}

	private ApiInfo createApiInfo () {
		return new ApiInfo("Tutorial API",
		"Tutorial database",
		"1.00",
		"https://portfolio.wieslawpedzich.com/",
		new Contact("Wieslaw - website", "https://portfolio.wieslawpedzich.com/", "wieslaw.pedzich@gmail.com"),
		"WIPE licence",
		"https://portfolio.wieslawpedzich.com/",
		Collections.emptyList()
		);
	}

	@Bean
	public UiConfiguration uiConfig() {
		return UiConfigurationBuilder
		.builder()		
		.operationsSorter(OperationsSorter.METHOD)
		.build();
	}
}


