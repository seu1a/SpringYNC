package me.seula.ync;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/rhs")
    @ResponseBody
    public String index() {
        return "RHS에 오신걸 환영해 !!";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }

}
