/**
 * Author: Madhu
 * User:madhu
 * Date:28/7/24
 * Time:1:53 PM
 * Project: rest-api-chaining
 */

package io.madhu.restApiChaining.schedulor;

import io.madhu.restApiChaining.service.ApiChainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@Slf4j
public class ScheduledTask {

    private final ApiChainService apiChainService;

    @Autowired
    public ScheduledTask(ApiChainService apiChainService) {
        this.apiChainService = apiChainService;
    }

    /**
     * Takes which ever is max (executionTime or delay )
     *  will be considered here.
     */
    //@Scheduled(fixedDelay = 15,timeUnit = TimeUnit.SECONDS)
    public void triggerArchival() {
        log.info("Legal Archiving Invoked............");
        apiChainService.executeChain();
    }
}
