package com.spring.vonggenerat.builer;

import com.baomidou.mybatisplus.generator.AutoGenerator;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 用于控制生成器配置的执行顺序
 */
public class GenDirector {
    public static void builder(GenBluePrint genBluePrint){
        genBluePrint.initGlobal();
        genBluePrint.initDatSource();
        genBluePrint.initPackage();
        genBluePrint.initSelf();
        genBluePrint.initTemple();
        genBluePrint.initStrategy();
        genBluePrint.startBuilder();
    }
}
