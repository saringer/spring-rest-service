package de;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.net.URL;
import java.net.URLClassLoader;

@Configuration
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
