package com.training.restLibrary.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class for swagger configuration
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Configuration
public class SwaggerConfig {

    /**
     * bean for customization openAPI
     *
     * @return openApi
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Simple Rest Application")
                                .version("1.0.0")
                );
    }

}
