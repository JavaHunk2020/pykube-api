package pykube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HttpToHttpsRedirectController {

    @GetMapping("/**")
    public RedirectView redirectHttpToHttps() {
        return new RedirectView("https://pykube.net");
    }
}
