package com.songify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.songify.*"})
@SpringBootApplication
public class SongifyApplication{

    public static void main(String[] args) {
        SpringApplication.run(SongifyApplication.class, args);
    }

}
