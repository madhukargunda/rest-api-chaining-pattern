/**
 * Author: Madhu
 * User:madhu
 * Date:19/7/24
 * Time:10:26 AM
 * Project: rest-api-chaining
 */

package io.madhu.restApiChaining.service;

import io.madhu.restApiChaining.factory.ApiHandlerFactory;
import io.madhu.restApiChaining.handler.ApiChainHandler;
import io.madhu.restApiChaining.model.RestAPIRequest;
import io.madhu.restApiChaining.model.RestAPIResponse;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class ApiFactoryChainService {

    private ApiChainHandler firstHandler;

    @Value("${spring.application.handlers}")
    private String[] handlerNames;

    @Value("${spring.application.url}")
    private String url;

    @Autowired
    private ApiHandlerFactory apiHandlerFactory;

    @PostConstruct
    public void init() {

        firstHandler = apiHandlerFactory.createChain(Arrays.stream(handlerNames).toList());
    }

    public void executeChain() {
        RestAPIRequest restAPIRequest = new RestAPIRequest();
        RestAPIResponse restAPIResponse = new RestAPIResponse();
        this.firstHandler.handle(restAPIRequest, restAPIResponse);
    }
}
