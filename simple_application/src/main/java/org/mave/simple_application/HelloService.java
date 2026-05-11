package org.mave.simple_application;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;

    public String getHelloMessage() {
        return getLatestMessage();
    }

    public String getLatestMessage() {
        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "id"));
        return helloRepository.findAll(pageable)
            .stream()
            .map(HelloModel::getMessage)
            .findFirst()
            .orElse("No messages yet. Create one using the /hello/create endpoint!");
    }

    public HelloModel createHelloMessage() {
        long count = helloRepository.count();
        long nextNumber = count + 1;
        String message = "Hello World #" + nextNumber;
        
        HelloModel helloModel = new HelloModel();
        helloModel.setMessage(message);
        
        return helloRepository.save(helloModel);
    }
}
