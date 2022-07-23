package com.ventas.srvpago.commons.converter;

//mapea todas las etiquetas dentro del paquete.
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.ventas.srvpago")
@PropertySource("classpath:application.properties")
public class ConfiguradorSpring {

}