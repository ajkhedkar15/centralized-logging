package com.service.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("gateway.config")
@RequiredArgsConstructor(onConstructor = @__({@ConstructorBinding}))
public class GatewayApplicationProperties {

  private final String quotesServiceName;

  private final String greeterServiceName;

  public String getQuotesServiceName() {

    return quotesServiceName;
  }

  public String getGreeterServiceName() {

    return greeterServiceName;
  }
}
