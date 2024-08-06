/**
 * Author: Madhu
 * User:madhu
 * Date:18/7/24
 * Time:9:55 AM
 * Project: rest-api-chaining
 */

package io.madhu.restApiChaining.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestAPIResponse {
    private Object previousResponse;
}
