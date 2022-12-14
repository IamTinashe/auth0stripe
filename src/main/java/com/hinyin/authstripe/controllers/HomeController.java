package com.hinyin.authstripe.controllers;

import com.hinyin.authstripe.payload.ChargeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

  @Value("${STRIPE_PUBLIC_KEY}")
  private String stripePublicKey;
  @GetMapping("/")
  public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
    if (principal != null) {
      model.addAttribute("amount", 1 * 100);
      model.addAttribute("stripePublicKey", stripePublicKey);
      model.addAttribute("currency", ChargeRequest.Currency.EUR);
      model.addAttribute("profile", principal.getClaims());
    }
    return "index";
  }
}
