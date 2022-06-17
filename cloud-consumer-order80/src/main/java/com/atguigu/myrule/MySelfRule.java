package com.atguigu.myrule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther zzyy
 * @create 2020-02-19 19:00
 */
@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule()
    {
        return new RoundRobinRule();//轮询  默认轮询
//        return new RandomRule();//定义为随机
//        return new RetryRule();//先按照轮询策略，如果获取服务失败则在指定的时间内会进行重试，获取当前可用的服务然后进行轮询
//        return new WeightedResponseTimeRule();//对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选择
//        return new BestAvailableRule();//会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
//        return new AvailabilityFilteringRule();//先过滤掉故障实例，再选择并发较小的实例
//        return new ZoneAvoidanceRule();//默认规则,复合判断server所在区域的性能和server的可用性选择服务器

    }
}
