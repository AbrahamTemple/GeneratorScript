package com.spring.vonggenerat.entity.body;

import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.spring.vonggenerat.entity.InstanceParam;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 策略配置参数
 */
@Data
public class StrategyConfigParam implements InstanceParam, Serializable {

    private volatile static StrategyConfigParam SCP;

    private NamingStrategy naming = NamingStrategy.underline_to_camel;

    private NamingStrategy columnNaming = NamingStrategy.underline_to_camel;

    private Boolean entityLombokModel = true;

    private Boolean restControllerStyle = true;

    private Boolean controllerMappingHyphenStyle = true;

    public static StrategyConfigParam getInstance(){
        if(SCP == null){
            synchronized (StrategyConfigParam.class) {
                SCP = new StrategyConfigParam();
            }
        } return SCP;
    }
}
