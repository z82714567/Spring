package kr.ch10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public OpenAPI openAPI() {
        Info info = new Info()
                .title("Swagger API")
                .version("1.0")
                .description("API 설명");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
