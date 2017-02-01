package com.damgigo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;

/* Resources 경로 연결 및 설정 */
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {	
	private static final String[] RESOURCE_LOCATIONS= {
			"classpath:/templates/"
	};
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/**")) {
        registry
        .addResourceHandler("/**")
        .addResourceLocations(RESOURCE_LOCATIONS)
        .setCachePeriod(0)
        .resourceChain(true)
        .addResolver(new PathResourceResolver());
        }
    }
}
