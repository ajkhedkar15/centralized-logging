package com.service.gateway.controller;

import com.service.core.dto.ResponseDTO;
import com.service.core.rest.RestClient;
import com.service.gateway.config.GatewayApplicationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RestController
@RequestMapping("quotes")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class QuotesController {

  private final RestClient restClient;

  private final GatewayApplicationProperties gatewayApplicationProperties;

  @GetMapping(value = "qod", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO<Object, String>> quoteOfTheDay() {

    try {

      log.info("Retrieving the quote of the day...");

      final var qodURI = UriComponentsBuilder
        .fromHttpUrl(gatewayApplicationProperties.getQuotesServiceName()).pathSegment("qod").build()
        .toUri();

      final var responseDTOResponseEntity = restClient
        .loadBalancedExchange(RequestEntity.get(qodURI).build(),
          new ParameterizedTypeReference<ResponseDTO<Object, String>>() {
          });

      log.info("Retrieved the quote of the day");

      return responseDTOResponseEntity;
    } catch (Exception e) {

      log.error("Error while retrieving the quote of the day :: ", e);

      final var errorResponse = ResponseDTO.<Object, String>builder()
        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).error(e.getMessage()).build();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
  }
}
