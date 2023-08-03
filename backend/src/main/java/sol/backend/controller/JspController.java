package sol.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {
    @GetMapping(value={"/", "index"})
    public String hello(Model model) {
        model.addAttribute("data", "Goodbye JSP");
        return "index";
    }
}
