package com.example.apigatewayservice.filter;

import com.sun.deploy.config.Config;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

public class GlobalFilter extends AbstractGatewayFilterFactory<AbstractGatewayFilterFactory.NameConfig> {

//생성자

    @Override
    public GatewayFilter apply(NameConfig config) {
        return null;
    }
}
