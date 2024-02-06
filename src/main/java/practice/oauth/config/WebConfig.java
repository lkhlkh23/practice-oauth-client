package practice.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/***")
                .addResourceLocations("classpath:/static/css/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
        registry.addResourceHandler("/js/***")
                .addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/img/***")
                .addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/templates/***")
                .addResourceLocations("classpath:/templates/");
    }

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }

}
