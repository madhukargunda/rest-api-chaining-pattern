/**
 * Author: Madhu
 * User:madhu
 * Date:19/7/24
 * Time:10:22 AM
 * Project: rest-api-chaining
 */

package io.madhu.restApiChaining.factory;

import io.madhu.restApiChaining.handler.ApiChainHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ApiHandlerFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public ApiChainHandler getHandler(String handlerName) {
        return (ApiChainHandler) applicationContext.getBean(handlerName);
    }

    public ApiChainHandler createChain(List<String> handleNames) {
        log.info("Create Chain method invoked...............");
        ApiChainHandler firstHandler = null;
        ApiChainHandler currentHandler = null;

        for (String handlerName : handleNames) {
            log.info("Creating the handler Chain.... {}", handlerName);
            ApiChainHandler handler = getHandler(handlerName);
            if (firstHandler == null) {
                firstHandler = handler;
                currentHandler = handler;
            } else {
                log.info("Current handler {}  and Next Handler {} ", currentHandler, handler);
                currentHandler.setNextHandler(handler);
                currentHandler = handler;
            }
        }
        return firstHandler;
    }
}
