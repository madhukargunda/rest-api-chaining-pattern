package io.madhu.restApiChaining.handler;

import io.madhu.restApiChaining.model.RestAPIRequest;
import io.madhu.restApiChaining.model.RestAPIResponse;

@FunctionalInterface
public interface Handler {
    public void handle(RestAPIRequest apiRequest, RestAPIResponse restAPIResponse);
}
