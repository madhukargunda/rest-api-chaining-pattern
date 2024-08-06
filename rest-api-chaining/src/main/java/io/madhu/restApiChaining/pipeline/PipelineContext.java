/**
 * Author: Madhu
 * User:madhu
 * Date:28/7/24
 * Time:4:01 PM
 * Project: rest-api-chaining
 */

package io.madhu.restApiChaining.pipeline;

import io.madhu.restApiChaining.model.RestAPIRequest;
import io.madhu.restApiChaining.model.RestAPIResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PipelineContext {

    private RestAPIRequest requestData;

    private RestAPIResponse responseData;
}
