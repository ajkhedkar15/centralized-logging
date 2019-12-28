package com.service.gateway.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;

@Builder
@JsonInclude(Include.NON_NULL)
public class ResponseDTO<R, E> {

  private final int code;

  private final String message;

  private final R response;

  private final E error;
}
