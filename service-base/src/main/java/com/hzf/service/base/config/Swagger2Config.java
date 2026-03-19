package com.hzf.service.base.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket adminApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")//分组名称 见Controller上的@ApiOperation注解
                .apiInfo(adminApiInfo())//调用adminApiInfo方法
                .select()
                //只显示admin路径下的页面  //根据正则表达式筛选具体路径
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))  //根据正则表达式筛选具体路径
                .build();

    }
    /**
     * 创建webApi需要的Docket
     * @return
     */

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")//分组名称 见Controller上的@ApiOperation注解
                .apiInfo(webApiInfo())//调用webApiInfo方法  //创建webApi需要的Docket
                .select()
                //只显示web路径下的页面  //根据正则表达式筛选具体路径
                .paths(Predicates.and(PathSelectors.regex("/web/.*")))  //根据正则表达式筛选具体路径
                .build();

    }

    /**
     * 创建restApi需要的Docket
     * @return
     */
    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder()
                .title("尚融宝后台管理系统-API文档") //标题
                .description("本文档描述了尚融宝后台管理系统的接口") //描述
                .version("1.0") //版本号
                .contact(new Contact("hzf", "http://baidu.com", "3123958330@qq.com"))   //联系人
                .build();
    }

    /**
     * 创建restApi需要的Docket
     * @return
     */
    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("尚融宝前台管理系统-API文档") //标题
                .description("本文档描述了尚融宝前台管理系统的接口") //描述
                .version("1.0") //版本号
                .contact(new Contact("hzf", "http://baidu.com", "3123958330@qq.com"))   //联系人
                .build();
    }
}
