package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @FeignClient注解
 *      value 通过feign去调用的服务名称
 *      fallback 当调用服务发生异常或超时或服务提供者宕机时，通过fallbakc指定的类中的方法(该类实现被@FeignClient标识的接口并重新方法)，去执行服务降级
 *
 *
 *
 *
 * @auther zzyy
 * @create 2020-02-20 11:55
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT" ,fallback = PaymentFallbackService.class)
public interface PaymentHystrixService
{
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
