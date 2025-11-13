package com.projectEcsiDef.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DocumentosConfig implements WebMvcConfigurer{	

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//Ruta HTTP que usara la APP
		String rutaBase = "file://10.10.11.91/equipo principal/Documentos/DATOS PROVEEDORES CREADOS/2025";
        registry.addResourceHandler("/documentos/**")
                .addResourceLocations(rutaBase)
                .setCachePeriod(0);// Sin caché para desarrollo
    

    }

}
