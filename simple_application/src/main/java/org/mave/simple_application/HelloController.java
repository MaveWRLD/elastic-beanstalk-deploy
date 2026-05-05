package org.mave.simple_application;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;


    @GetMapping
    public ResponseEntity<String> getHelloMessage() {
        String message = helloService.getHelloMessage();
        return ResponseEntity.ok(message);
    }


    @GetMapping("/")
    public String home() {
        return "App deployed successfully ✅";
    }

}
