package com.spring.vonggenerat.builer;

import com.baomidou.mybatisplus.generator.AutoGenerator;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 代码生成器构建蓝图
 */
public abstract class GenBluePrint extends MyScanner{
    abstract void initGlobal();
    abstract void initDatSource();
    abstract void initPackage();
    abstract void initSelf();
    abstract void initTemple();
    abstract void initStrategy();
    abstract void startBuilder();
}
