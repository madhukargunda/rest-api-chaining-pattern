/**
 * Author: Madhu
 * User:madhu
 * Date:18/7/24
 * Time:9:57 AM
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
public class ConversationsService implements ApiChainHandler {

    @Autowired
    private RestTemplate restTemplate;

    private ApiChainHandler nextHandler;

    @Override
    public void setNextHandler(ApiChainHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(RestAPIRequest apiRequest, RestAPIResponse restAPIResponse) {
        log.info(String.format("Invoking the Conversation Service"));
        if (!Objects.isNull(nextHandler)) {
            log.info(String.format("Next Service on %s", this.nextHandler.getClass().getName()));
            nextHandler.handle(apiRequest, restAPIResponse);
        }
    }
}
