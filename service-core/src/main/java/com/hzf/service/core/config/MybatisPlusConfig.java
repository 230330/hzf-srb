package com.hzf.service.core.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis Plus 配置类
 * 用于配置 MyBatis Plus 的相关插件和功能，包括分页插件、Mapper扫描、事务管理等
 */
@Configuration // 标识该类为Spring配置类，会被Spring容器扫描并加载
@MapperScan("com.hzf.service.core.mapper")  // 扫描指定包路径下的Mapper接口，将其注册为Spring Bean
@EnableTransactionManagement    // 启用Spring声明式事务管理，支持@Transactional注解
public class MybatisPlusConfig {

    /**
     * 配置 MyBatis Plus 拦截器
     * 主要用于注册分页插件，使分页查询生效
     * 使用时需配合 Page 对象进行分页查询
     *
     * @return MybatisPlusInterceptor 拦截器实例
     */
    @Bean // 将方法返回的对象注册为Spring容器中的Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // 创建 MyBatis Plus 拦截器实例
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加分页内部拦截器，指定数据库类型为MySQL，以便生成正确的分页SQL语句
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
