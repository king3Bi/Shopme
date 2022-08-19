package com.shopeme;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @GetMapping("")
  @ResponseBody
  public String hello() {
    return "Hello, this is page for customer";
  }
}
