package com.dyd.ssp.smp._generateCode;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.*;

/**
 * @Author: zwt
 * @Version 1.0
 *  MP 生成代码工具
 */
public class MybatisPlusGenerateCode {

    public static void main(String[] args) {
        String[] models = {"smp-persistence","smp-service","smp-api"};
        for (String model : models) {
            shell(model);
        }
    }

    private static void shell(String model){
        final String[] tableNames = new String[] { "user" };
        final String url = "jdbc:mysql://lynwood.wunian7yulian.top:3306/liugh?useUnicode=true&characterEncoding=utf8&useSSL=false";
        final String userName = "root";
        final String passWord = "Zhaowentao123!";
        final String parent = "com.dyd.ssp";
        final String module = "smp";
        File file = new File(model);
        String path = file.getAbsolutePath();
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(path+"/src/main/java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("zwt");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("I%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);

        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(userName);
        dsc.setPassword(passWord);
        dsc.setUrl(url);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[] { "tb_", "m_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(tableNames); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        //strategy.setSuperEntityClass("com.spf.model.Entity");
        // 自定义实体，公共字段
        //strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        //strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        //strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        //strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parent);
        pc.setModuleName(module);
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");

        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();

        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();

        if ("smp-persistence".equals(model)) { // 只有 entity + mapper +  mapper xml
            tc.setController(null);
            tc.setService(null);
            tc.setServiceImpl(null);
//            tc.setMapper(null);
//            tc.setXml(null);
        }  else if ("smp-service".equals(model)) {// 只有 service + impl
            tc.setController(null);
            tc.setMapper(null);
            tc.setXml(null);
            tc.setEntity(null);
        } else if ("smp-api".equals(model)) { // 只有controller
            tc.setMapper(null);
            tc.setXml(null);
            tc.setService(null);
            tc.setServiceImpl(null);
            tc.setEntity(null);
        }
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }
}
