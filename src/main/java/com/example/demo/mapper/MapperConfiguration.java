package com.example.demo.mapper;

import org.mapstruct.MapperConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages = "com.example.demo.mapper")
@MapperConfig(componentModel = "spring")
public class MapperConfiguration {
}
