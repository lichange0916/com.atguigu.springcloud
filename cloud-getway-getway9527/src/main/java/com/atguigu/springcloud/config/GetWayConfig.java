package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetWayConfig
{
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_news",r->r.path("/guonei")
                .uri("https://news.baidu.com/")).build();

        routes.route("path_route_taobao",r->r.path("/taobao")
                .uri("https://www.taobao.com//")).build();

        return routes.build();
    }
}
