package com.crud.prices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
//@SpringBootApplication
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricesApplication.class, args);
	}
		
		  private ApiInfo apiInfo() { return new
		  ApiInfoBuilder().title("Mantenimiento de Prices")
		  .description("Prices API reference for developers, teh error handler is implement using \n"
		  +
		  " The IETF devised RFC 7807 effor, which creates a generalized error-handling schema.\n"
		  + "https://tools.ietf.org/html/rfc7807") .termsOfServiceUrl(
		  "linkedin.com/in/carlos-javier-zevallos-soto-csm®-csd®-kmp®-72b62b51")
		  .license("CarlosZ License") .licenseUrl(
		  "linkedin.com/in/carlos-javier-zevallos-soto-csm®-csd®-kmp®-72b62b51")
		  .version("1.0") .build(); }
		 
	
	  @Bean public Docket pricesApi() { return new
	  Docket(DocumentationType.SWAGGER_2) .groupName("prices-spis")
	  .apiInfo(apiInfo()) .select()
	  .apis(RequestHandlerSelectors.basePackage("com.crud"))
	  .paths(PathSelectors.any()) .build();
	  
	  }
	 
	 
}
