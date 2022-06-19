package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2020-02-21 18:08
 */
@RestController
@RefreshScope
public class ConfigClientController
{
    /**
     * 根据bootstrap.yml配置文件可知：连接springcloud配置中心服务端(http://config-3344.com:3344)，然后由
     * springcloud配置中心服务端去读取它连接的github上的配置文件，注入到configInfo变量中
     *
     */
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
