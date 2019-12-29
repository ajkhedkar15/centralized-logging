package com.service.core.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class RestClient {

  private final RestTemplate loadBalancedRestClient;

  private final RestTemplate restClient;

  public <T> ResponseEntity<T> loadBalancedExchange(final RequestEntity<?> request,
    final ParameterizedTypeReference<T> response) {

    return loadBalancedRestClient.exchange(request, response);
  }

  public <T> ResponseEntity<T> exchange(final RequestEntity<?> request,
    final ParameterizedTypeReference<T> response) {

    return restClient.exchange(request, response);
  }
}
