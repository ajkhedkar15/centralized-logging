package com.service.core.config;

import com.service.core.rest.RestClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {

  @Bean("loadBalancedRestClient")
  @LoadBalanced
  RestTemplate loadBalancedRestClient() {

    return new RestTemplateBuilder().build();
  }

  @Bean
  public RestClient restClient(
    @Qualifier("loadBalancedRestClient") final RestTemplate loadBalancedRestClient) {

    return new RestClient(loadBalancedRestClient, new RestTemplateBuilder().build());
  }
}
