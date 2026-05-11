package org.mave.simple_application;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<HelloModel> createHelloMessage() {
        HelloModel helloModel = helloService.createHelloMessage();
        return ResponseEntity.status(HttpStatus.CREATED).body(helloModel);
    }

}
