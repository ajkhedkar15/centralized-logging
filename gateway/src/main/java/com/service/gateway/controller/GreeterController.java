package com.service.gateway.controller;

import com.service.gateway.service.GreeterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("greet")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class GreeterController {

  private final GreeterService greeterService;
}
