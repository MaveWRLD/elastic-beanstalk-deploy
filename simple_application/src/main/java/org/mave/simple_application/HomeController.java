package org.mave.simple_application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HelloService helloService;

    @GetMapping("/")
    public String home(Model model) {
        String latestMessage = helloService.getLatestMessage();
        model.addAttribute("message", latestMessage);
        return "home";
    }
}
