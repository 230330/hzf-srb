package com.hzf.service.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Service Core 核心服务模块启动类
 * @author hzf
 * @since 2026/3/17
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.hzf.service", "com.hzf"})  // 显式指定组件扫描包
public class ServiceCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCoreApplication.class, args);
    }
}