# 优化的MyBatisPlus代码生成器

## 在源的基础上用建造者模式进行切分

``` java
public abstract class GenBluePrint extends MyScanner{
    abstract void initGlobal();
    abstract void initDatSource();
    abstract void initPackage();
    abstract void initSelf();
    abstract void initTemple();
    abstract void initStrategy();
    abstract void startBuilder();
}
```

## 实体类采用了单例模式的设计思想

``` java
@Data
public class GlobalConfigParam implements InstanceParam, Serializable {

    private volatile static GlobalConfigParam GCP;

    private String pathPrefix = System.getProperty("user.dir");

    private String pathSuffix = "/vong-generat/src/main/java";

    private String path = getPathPrefix() + getPathSuffix();

    private String author = "Abraham";

    private Boolean open = false;

    public static GlobalConfigParam getInstance(){
        if(GCP == null){
            synchronized (GlobalConfigParam.class) {
                GCP = new GlobalConfigParam();
            }
        } return GCP;
    }

}
```

## 多情况设置预处理

``` Bash
请输入你的子项目名(没有就输入/)：
vong-socket
请输入你当前项目的父目录(eg: com.example)：
com.cloud
请输入你的当前包名(eg: demo)：
vongsocket
请输入目标表名，多个用逗号隔开：
v_user,v_cover_gallery,v_user_cover,v_gallery,v_cover
```

![Screenshot](demo.gif)
