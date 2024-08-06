/**
 * Author: Madhu
 * User:madhu
 * Date:18/7/24
 * Time:9:52 AM
 * Project: rest-api-chaining
 */

package io.madhu.restApiChaining.handler;

public interface ApiChainHandler extends Handler {
    public void setNextHandler(ApiChainHandler nextHandler);
}
