package com.spring.vonggenerat.entity.body;

import com.spring.vonggenerat.entity.InstanceParam;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 包参数
 */
@Data
public class PackageParam implements InstanceParam, Serializable {

    private volatile static PackageParam PP;

    private String moduleName = "default";
    private String parent = "generator";

    public static PackageParam getInstance(){
        if(PP == null){
            synchronized (PackageParam.class) {
                PP = new PackageParam();
            }
        } return PP;
    }
}
