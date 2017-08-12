package com.szabom5.controller;

import com.szabom5.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/greeting")
public class GreetingController {

  private final GreetingService greetingService;

  @Autowired
  public GreetingController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String greeting(
      @RequestParam(value = "name", required = false, defaultValue = "World") String name,
      Model model,
      @AuthenticationPrincipal User user) {
    model.addAttribute("greeting", greetingService.greet(user.getUsername()));
    return "page/greeting";
  }

}
