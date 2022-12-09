package com.hinyin.authstripe.controllers;

import lombok.extern.java.Log;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log
@Controller
public class MembersController {

  @GetMapping("/member")
  public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
    System.out.println(principal);
    if (principal != null) {
      model.addAttribute("profile", principal.getClaims());
    }
    return "member";
  }
}
