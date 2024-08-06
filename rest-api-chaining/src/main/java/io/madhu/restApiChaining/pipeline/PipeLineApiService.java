/**
 * Author: Madhu
 * User:madhu
 * Date:28/7/24
 * Time:4:09 PM
 * Project: rest-api-chaining
 */

package io.madhu.restApiChaining.pipeline;

import io.madhu.restApiChaining.model.RestAPIRequest;
import io.madhu.restApiChaining.model.RestAPIResponse;
import org.springframework.stereotype.Service;

@Service
public class PipeLineApiService {

    private ApiChainLineManager lineManager;

    public void executeChain() {
        RestAPIRequest restAPIRequest = new RestAPIRequest();
        RestAPIResponse restAPIResponse = new RestAPIResponse();
        PipelineContext pipelineContext = new PipelineContext(restAPIRequest, restAPIResponse);
        lineManager.executePipeline(pipelineContext);
    }
}
