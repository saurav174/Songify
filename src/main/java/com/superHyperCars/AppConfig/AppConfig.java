package com.superHyperCars.AppConfig;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${http.max.total:10}")
    private int maxTotal;

    @Value("${http.max.per.route:4}")
    private int defaultMaxPerRoute;

    @Value("${http.connection.request.timeout:5000}")
    private int connectionRequestTimeout;

    @Value("${http.connect.timeout:10000}")
    private int connectTimeout;

    @Value("${http.read.timeout:45000}")
    private int readTimeout;

    @Value("${http.idle.connection.timeout:60000}")
    private int idleConnectionTimeout;


}
