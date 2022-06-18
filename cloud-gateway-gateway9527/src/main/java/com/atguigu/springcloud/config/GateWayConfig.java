package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置了一个id为route-name的路由规则，
 *     当访问地址 http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
 * @auther zzyy
 * @create 2020-02-21 11:42
 */
@Configuration
public class GateWayConfig
{
    /**
     * gateway网关实现有两种方式
     *      方式一：在application.yml文件中配置即可
     *      方式二：写代码，如本方法
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        //参数一：代表application.yml配置文件中的 routes：id
        //参数二：代表application.yml配置文件中的 routes：predicates: - Path
        //参数三：代表application.yml配置文件中的 routes：uri
        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
