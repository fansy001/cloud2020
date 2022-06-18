package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @DefaultProperties 注解
 *      defaultFallback属性： 表示当请求的方法发生异常或超时或服务提供者宕机时，在请求方法上只是单纯的加了@HystrixCommand注解，该注解
 *          没有配置fallbackMethod属性时，就执行defaultFallback属性指定的方法，去执行服务降级，
 *          当配置了fallbackMethod属性时，就执行fallbackMethod属性指定的方法，去执行服务降级
 *
 * @HystrixCommand注解
 *      fallbackMethod属性:当请求的方法发生异常或超时或服务提供者宕机后，去执行fallbackMethod属性指定的方法，去执行服务降级
 *      commandProperties属性：通过@HystrixProperty注解的name和value配置相应的参数
 *          @HystrixProperty
 *              name:
 *                  execution.isolation.thread.timeoutInMilliseconds 表示被@HystrixCommand注解标识的方法最大执行时间，超过该时间时就执行fallbackMethod属性指定的方法，去执行服务降级
 *
 * @auther zzyy
 * @create 2020-02-20 11:57
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystirxController
{
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    /**
     * 服务异常或者超时，做服务降级处理，降级的方案是执行 paymentInfo_TimeOutHandler 方法
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    })
    //@HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id)
    {
       //int age = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id)
    {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
