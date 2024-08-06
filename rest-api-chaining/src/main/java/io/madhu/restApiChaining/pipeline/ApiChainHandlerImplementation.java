/**
 * Author: Madhu
 * User:madhu
 * Date:28/7/24
 * Time:3:40 PM
 * Project: rest-api-chaining
 */

package io.madhu.restApiChaining.pipeline;

import io.madhu.restApiChaining.handler.Handler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ApiChainHandlerImplementation {

    @Autowired
    private RestTemplate restTemplate;

    public Handler tokenApiHandler() {
        log.info("tokenApiHandler method triggered");
        return (request, response) -> {
            response.setPreviousResponse(null);
        };
    }

    public Handler binderApiHandler() {
        log.info("binderApiHandler method triggered");
        return (request, response) -> {
            response.setPreviousResponse(null);
        };
    }

    public Handler conversationApiHandler() {
        log.info("conversationApiHandler method triggered");
        return (request, response) -> {
            response.setPreviousResponse(null);
        };
    }
}
