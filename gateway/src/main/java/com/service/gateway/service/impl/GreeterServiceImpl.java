package com.service.gateway.service.impl;

import com.service.gateway.config.GatewayApplicationProperties;
import com.service.gateway.service.GreeterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class GreeterServiceImpl implements GreeterService {

  private final RestTemplate restTemplate;

  private final GatewayApplicationProperties properties;
}
