package swagger.training.swaggerDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(this.apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("swagger.training.swaggerDemo"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Swagger Demo")
				.description("Online/Offline Swagger Demo")
				.termsOfServiceUrl("http://localhost:6688/")
				.contact(this.contact())
				.version("0.1")
				.build();
	}

	public Contact contact() {
		String name = "Swagger Demo";
		String url = "localhost:6688";
		String email = "swagger@demo";
		return new Contact(name, url, email);
	}
}
