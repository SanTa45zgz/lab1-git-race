package es.unizar.webeng.hello

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
@Import(SpringDataRestConfiguration::class)
open class SpringSwaggerConf {
    @Bean
    open fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("es.unizar.webeng.hello"))
                .paths(PathSelectors.ant("/*"))
                .build()
    }
}