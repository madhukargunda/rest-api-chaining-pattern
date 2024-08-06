/**
 * Author: Madhu
 * User:madhu
 * Date:18/7/24
 * Time:9:56 AM
 * Project: rest-api-chaining
 */

package io.madhu.restApiChaining.service;

import io.madhu.restApiChaining.handler.ApiChainHandler;
import io.madhu.restApiChaining.model.RestAPIRequest;
import io.madhu.restApiChaining.model.RestAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@Slf4j
public class ChatBinderService implements ApiChainHandler {

    @Autowired
    private RestTemplate restTemplate;

    private ApiChainHandler nextHandler;

    @Override
    public void setNextHandler(ApiChainHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(RestAPIRequest apiRequest, RestAPIResponse previousRestAPIResponse) {
        Class<String> stringClass = String.class;
        log.info(String.format("Invoking the ChatBinderService "));
        if (!Objects.isNull(nextHandler)) {
            log.info(String.format("Next Service is on %s", this.nextHandler.getClass().getName()));
            nextHandler.handle(apiRequest, new RestAPIResponse());
        }
    }
}
