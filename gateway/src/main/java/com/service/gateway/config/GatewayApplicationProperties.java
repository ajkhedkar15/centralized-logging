package com.service.gateway.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConfigurationProperties("gateway.config")
@RequiredArgsConstructor(onConstructor = @__({@ConstructorBinding}))
public class GatewayApplicationProperties {

  private final String quotesServiceName;

  private final String greeterServiceName;
}
