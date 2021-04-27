package com.spring.vonggenerat.builer;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.spring.vonggenerat.entity.body.DataSourceParam;
import com.spring.vonggenerat.entity.body.GlobalConfigParam;
import com.spring.vonggenerat.entity.body.PackageParam;
import com.spring.vonggenerat.entity.body.StrategyConfigParam;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 生成器配置的具体实现区
 */
@AllArgsConstructor
public class GenWorker extends GenBluePrint{

    AutoGenerator mpg;

    @Override
    void initGlobal() {
        GlobalConfig gc = new GlobalConfig();
        GlobalConfigParam instance = GlobalConfigParam.getInstance();
        gc.setOutputDir(instance.getPath());
        gc.setAuthor(instance.getAuthor());
        gc.setOpen(instance.getOpen());
        mpg.setGlobalConfig(gc);
    }

    @Override
    void initDatSource() {
        DataSourceConfig dsc = new DataSourceConfig();
        DataSourceParam instance = DataSourceParam.getInstance();
        dsc.setUrl(instance.getUrl());
        dsc.setDriverName(instance.getDriverName());
        dsc.setUsername(instance.getUsername());
        dsc.setPassword(instance.getPassword());
        mpg.setDataSource(dsc);
    }

    @Override
    void initPackage() {
        PackageConfig pc = new PackageConfig();
        PackageParam instance = PackageParam.getInstance();
        pc.setModuleName(scanner("请输入你的包名"));
        pc.setParent(instance.getParent());//你哪个父目录下创建包
        mpg.setPackageInfo(pc);
    }

    @Override
    void initSelf() {
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
        /* focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        }); */
        /* cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        }); */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
    }

    @Override
    void initTemple() {
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        // templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
    }

    @Override
    void initStrategy() {
        // 策略配置,数据库表配置
        StrategyConfig strategy = new StrategyConfig();
        StrategyConfigParam instance = StrategyConfigParam.getInstance();
        //数据库表映射到实体的命名策略
        strategy.setNaming(instance.getNaming());
        //数据库表字段映射到实体类的命名策略
        strategy.setColumnNaming(instance.getColumnNaming());
        //自定义继承entity类，添加这一个会在生成实体类的时候继承entity
        //strategy.setSuperEntityClass("com.wy.testCodeGenerator.entity");
        //实体是否为lombok模型
        strategy.setEntityLombokModel(instance.getEntityLombokModel());
        //生成@RestController控制器
        strategy.setRestControllerStyle(instance.getRestControllerStyle());
        //是否继承controller
        // strategy.setSuperControllerClass("com.wy.testCodeGenerator.controller");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // strategy.setSuperEntityColumns("id");
        //驼峰转连字符串
        strategy.setControllerMappingHyphenStyle(instance.getControllerMappingHyphenStyle());
        //表前缀
        // strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
    }

    @Override
    void startBuilder() {
        mpg.execute();
    }
}
