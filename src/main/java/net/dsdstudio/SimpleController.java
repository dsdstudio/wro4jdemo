package net.dsdstudio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by bhkim on 2016. 10. 27..
 */
@Controller
public class SimpleController {
    @GetMapping("/index.html")
    public String index() {
        return "index";
    }
}
