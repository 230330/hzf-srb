package com.hzf.service.core;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

/**
 * 类描述：代码生成器测试类
 * @author hzf
 * @date 2026/03/16 22:11:11
 * @description 代码生成器测试类
 */
public class CodeGenerator {
    @Test
    public void genCode() {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取项目路径，用于输出生成的代码
        String projectPath = System.getProperty("user.dir");
        // 设置生成的代码输出目录
        gc.setOutputDir(projectPath + "/src/main/java");
        // 设置作者
        gc.setAuthor("hzf"); // 设置作者，生成代码的作者名称
        // 设置生成后是否打开资源管理器
        gc.setOpen(false);
        // 设置Service接口的首字母是否去掉I,不写接口默认生成I开头的Service接口，如果去掉I，可以使用gc.setServiceName("%sService");
        //gc.setServiceName("%sService");	//去掉Service接口的首字母I
        // 设置主键策略
        gc.setIdType(IdType.AUTO);
        // 开启Swagger2模式
        gc.setSwagger2(true);//开启Swagger2模式
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // 设置数据库连接 URL
        dsc.setUrl("jdbc:mysql://localhost:3306/srb_base?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        // 设置数据库用户名
        dsc.setUsername("root");
        // 设置数据库密码
        dsc.setPassword("123456");
        // 设置数据库驱动
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        // 设置数据库类型
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        // 设置父包名
        pc.setParent("com.hzf.service.core");
        // 设置实体类包名
        pc.setEntity("entity");
        // 设置 Mapper 包名
        pc.setMapper("mapper");
        // 设置 Service 包名
        pc.setService("service");
        // 设置 Controller 包名
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 设置数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 设置生成Lombok模型
        strategy.setEntityLombokModel(true);
        // 设置逻辑删除字段名
        strategy.setLogicDeleteFieldName("is_deleted");
        // 去掉布尔值的is_前缀（确保tinyint(1)）
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        // 设置生成 RESTful api风格控制器  返回json数据
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }
}
