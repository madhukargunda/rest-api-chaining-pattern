package io.madhu.restApiChaining;

import io.madhu.restApiChaining.service.ApiChainService;
import io.madhu.restApiChaining.service.ApiFactoryChainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RestAPIChaining implements CommandLineRunner {

    @Autowired
    ApiChainService apiChainService;

    @Autowired
    ApiFactoryChainService apiFactoryChainService;

    public static void main(String[] args) {
       new SpringApplication().run(RestAPIChaining.class);
    }

    @Override
    public void run(String... args) throws Exception {
        // apiChainService.executeChain();
        apiFactoryChainService.executeChain();
    }
}