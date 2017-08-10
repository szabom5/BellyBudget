package com.szabom5;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

  public String greet(String name) {
    if (name != null && !name.isEmpty()) {
      return "Hello " + name;
    } else {
      return "Hello World";
    }
  }

}
