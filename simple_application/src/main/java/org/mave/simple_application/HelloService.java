package org.mave.simple_application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;

    public String getHelloMessage() {
        return helloRepository.getHelloMessage().orElse("Hello World!");
    }
}
