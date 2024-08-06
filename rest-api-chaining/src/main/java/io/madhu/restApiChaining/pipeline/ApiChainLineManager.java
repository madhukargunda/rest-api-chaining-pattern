/**
 * Author: Madhu
 * User:madhu
 * Date:28/7/24
 * Time:3:45 PM
 * Project: rest-api-chaining
 */

package io.madhu.restApiChaining.pipeline;

import io.madhu.restApiChaining.handler.Handler;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiChainLineManager {

    @Autowired
    ApplicationContext applicationContext;

    private List<Handler> handlers;

    public void executePipeline(PipelineContext context) {
        for (Handler handler : handlers) {
            handler.handle(context.getRequestData(), context.getResponseData());
        }
    }

}
