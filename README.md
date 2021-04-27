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

## 实体类采取了单例模式的设计思想

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


