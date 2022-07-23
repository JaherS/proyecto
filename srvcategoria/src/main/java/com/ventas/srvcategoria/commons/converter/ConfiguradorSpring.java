package com.ventas.srvcategoria.commons.converter;

//mapea todas las etiquetas dentro del paquete.
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.ventas.srvcategoria")
@PropertySource("classpath:application.properties")
public class ConfiguradorSpring {
}
