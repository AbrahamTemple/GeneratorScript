package com.spring.vonggenerat.event;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 代码生成器源
 */
public class MyGenerator {

    public static String scanner(String someThing) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + someThing + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String sc = scanner.next();
            if (StringUtils.isNotEmpty(sc)) {
                return sc;
            }
        }
        throw new MybatisPlusException("请输入正确的" + someThing + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/vong-generat/src/main/java");
        gc.setAuthor("Abraham");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://8.135.100.252:3306/ms?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("3626356");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("请输入你的包名"));
        pc.setParent("generator");//你哪个父目录下创建包
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        // String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        /*
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        */
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        // templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置,数据库表配置
        StrategyConfig strategy = new StrategyConfig();
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体类的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //自定义继承entity类，添加这一个会在生成实体类的时候继承entity
        //strategy.setSuperEntityClass("com.wy.testCodeGenerator.entity");
        //实体是否为lombok模型
        strategy.setEntityLombokModel(true);
        //生成@RestController控制器
        strategy.setRestControllerStyle(true);
        //是否继承controller
        // strategy.setSuperControllerClass("com.wy.testCodeGenerator.controller");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // strategy.setSuperEntityColumns("id");
        //驼峰转连字符串
        strategy.setControllerMappingHyphenStyle(true);
        //表前缀
        // strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
