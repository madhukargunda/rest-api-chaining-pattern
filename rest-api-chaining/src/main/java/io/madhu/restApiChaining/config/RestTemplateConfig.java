/**
 * Author: Madhu
 * User:madhu
 * Date:19/7/24
 * Time:8:10 AM
 * Project: rest-api-chaining
 */

package io.madhu.restApiChaining.config;

import io.madhu.restApiChaining.RestAPIChaining;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
