package com.service.gateway.controller;

import com.service.gateway.service.QuotesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("quotes")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class QuotesController {

  private final QuotesService quotesService;
}
