package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
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
    }
}
