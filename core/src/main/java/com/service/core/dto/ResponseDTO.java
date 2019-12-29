package com.service.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;

@Builder(builderClassName = "ResponseDTOBuilder", toBuilder = true)
@JsonDeserialize(builder = ResponseDTO.ResponseDTOBuilder.class)
@JsonInclude(Include.NON_NULL)
public class ResponseDTO<R, E> {

  private final int code;

  private final String message;

  private final R response;

  private final E error;

  @JsonPOJOBuilder(withPrefix = "")
  public static class ResponseDTOBuilder<R, E> {

  }
}
