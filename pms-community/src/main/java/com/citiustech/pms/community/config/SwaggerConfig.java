package com.citiustech.pms.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("A Community page for User's interaction")
				.description("Rest API's developed to make a community page for interaction between Admin, Physician/Nurse and Patient's in terms of Posts and Comments")
				.termsOfServiceUrl("").version("0.0.1-SNAPSHOT").contact(new Contact("Agastin Raj",
						"https://github.com/AgastinRaj-A", "agastin.raja@citiustech.com"))
				.build();
	}

	@Bean
	public Docket configureControllerPackageAndConvertors() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.citiustech.pms.community.controller")).build()
				.apiInfo(apiInfo());
	}

}
