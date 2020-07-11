package com.superHyperCars.AppConfig;


import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

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

    @Bean
    public RestTemplate restTemplate() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotal);
        connectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        connectionManager.closeIdleConnections(idleConnectionTimeout, TimeUnit.SECONDS);

        CloseableHttpClient httpClient = HttpClientBuilder.create().setConnectionManager(connectionManager).build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        factory.setConnectionRequestTimeout(connectionRequestTimeout);
        factory.setConnectTimeout(connectTimeout);
        factory.setReadTimeout(readTimeout);
        return new RestTemplate(factory);
    }
}
