package com.projectEcsiDef.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DocumentosConfig implements WebMvcConfigurer{	

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// OJO: usa "file:///" + la ruta completa con slash al final
        registry.addResourceHandler("/documentos/**")
                .addResourceLocations("file:///G:/PROVEEDORES_2025/");

    }

}
