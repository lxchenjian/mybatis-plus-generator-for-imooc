package com.imooc.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


public class MPDBConfig {

    public static void main(String[] args) {

        // 一、代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // (1) 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("风间影月");      // 设置作者
        gc.setFileOverride(true);      // 多次生成是否覆盖之前的
//        gc.setActiveRecord(true);      // 设置是否开启AR模式
//        gc.setIdType(IdType.ASSIGN_ID);      // 设置主键策略
        gc.setServiceName("%sService");      // 设置service名称，默认为IxxxService，去掉I
        gc.setBaseResultMap(true);          // 生成的mapper.xml中包含基本的ResultMap结果集
        gc.setBaseColumnList(true);         // 生成基本的sql查询片段
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        autoGenerator.setGlobalConfig(gc);

        // (2) 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://192.168.1.170:3306/liepin?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("imooc");
        autoGenerator.setDataSource(dsc);


        // (3) 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true);      // 开启全局大小写(true: 大写)
        strategy.setNaming(NamingStrategy.underline_to_camel);          // 下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);    // 下划线转驼峰命名
//        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        strategy.setInclude("stu");

        // 表名配置
        strategy.setInclude("users");
        strategy.setInclude("admin");
        strategy.setInclude("company");
        strategy.setInclude("industry");
        strategy.setInclude("data_dictionary");
        strategy.setInclude("company_photo");
        strategy.setInclude("resume");
        strategy.setInclude("resume_education");
        strategy.setInclude("resume_project_exp");
        strategy.setInclude("resume_work_exp");
        strategy.setInclude("sys_params");
        strategy.setInclude("job_type");
        strategy.setInclude("resume_expect");
        strategy.setInclude("job");
        strategy.setInclude("hr_collect_resume");
        strategy.setInclude("article");
        strategy.setInclude("chat_message");
        strategy.setInclude("interview");
        strategy.setInclude("orders");
        autoGenerator.setStrategy(strategy);

        // 包名策略配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.imooc");
        pc.setEntity("pojo");
        pc.setMapper("mapper");
        pc.setXml("mapper.xml");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
//        pc.setController(null);
        autoGenerator.setPackageInfo(pc);

        // 执行逆向生成
        autoGenerator.execute();
    }
}
