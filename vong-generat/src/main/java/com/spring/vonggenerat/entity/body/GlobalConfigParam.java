package com.spring.vonggenerat.entity.body;

import com.spring.vonggenerat.entity.InstanceParam;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 全局配置参数
 */
@Data
public class GlobalConfigParam implements InstanceParam, Serializable {

    private volatile static GlobalConfigParam GCP;

    private String pathPrefix = System.getProperty("user.dir");

    private String childPath = "";

    private String pathSuffix = "/src/main/java";

    private String path = getPathPrefix() + getChildPath() + getPathSuffix();

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
