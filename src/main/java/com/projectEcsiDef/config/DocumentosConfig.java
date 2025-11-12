package com.projectEcsiDef.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DocumentosConfig implements WebMvcConfigurer{
	
	@Value("${documentos.path}")
    private String documentosPath;

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/docs/**")
                .addResourceLocations("file:///" + documentosPath)
                .setCachePeriod(0);
    }

}
