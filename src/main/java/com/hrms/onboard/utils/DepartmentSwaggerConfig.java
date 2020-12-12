package com.hrms.onboard.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class DepartmentSwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.hrms.onboard")).paths(PathSelectors.regex("/.*"))
				.build().apiInfo(mataInfo());
	}

	private ApiInfo mataInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("mappings", "This application will provide HR management details", "version 1.0",
				"termsOfServiceUrl", "op-hrms-app support Team", "license", "licenseUrl");
		return apiInfo;
	}
}
