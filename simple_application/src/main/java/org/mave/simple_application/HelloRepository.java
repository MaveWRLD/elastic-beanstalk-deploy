package org.mave.simple_application;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HelloRepository {

    private final HelloModel helloModel;

    public Optional<String> getHelloMessage() {
        return Optional.ofNullable(helloModel.getMessage());
    }
}
