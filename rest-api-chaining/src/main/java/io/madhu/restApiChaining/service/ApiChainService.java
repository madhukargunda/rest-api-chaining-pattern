/**
 * Author: Madhu
 * User:madhu
 * Date:18/7/24
 * Time:2:58 PM
 * Project: rest-api-chaining
 */

package io.madhu.restApiChaining.service;

import io.madhu.restApiChaining.model.RestAPIRequest;
import io.madhu.restApiChaining.model.RestAPIResponse;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApiChainService {

    private final TokenApiChainService tokenApiService;
    private final ChatBinderService chatBinderService;
    private final ConversationsService conversationsService;

    public ApiChainService(TokenApiChainService tokenApiService, ChatBinderService chatBinderService, ConversationsService conversationsService) {
        this.tokenApiService = tokenApiService;
        this.chatBinderService = chatBinderService;
        this.conversationsService = conversationsService;
    }

    /**
     * Setting Api chain Handlers
     * here for all the services
     */
    @PostConstruct
    public void init() {
        tokenApiService.setNextHandler(chatBinderService);
        chatBinderService.setNextHandler(conversationsService);
        chatBinderService.setNextHandler(null);
    }

    public void executeChain() {
        log.info(String.format("executeChain method"));
        RestAPIRequest tokenApiRequest = new RestAPIRequest();
        RestAPIResponse tokenApiResponse = new RestAPIResponse();
        tokenApiService.handle(tokenApiRequest, tokenApiResponse);
    }
}
