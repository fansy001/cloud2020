package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @auther zzyy
 * @create 2020-02-20 18:22
 */
@Component//注意这个注解不要忘记加 不要忘记 不要忘记
public class PaymentFallbackService implements PaymentHystrixService
{
    @Override
    public String paymentInfo_OK(Integer id)
    {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id)
    {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
