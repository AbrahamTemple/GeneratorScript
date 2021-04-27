package com.spring.vonggenerat.task;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.spring.vonggenerat.builer.GenDirector;
import com.spring.vonggenerat.builer.GenWorker;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 主入口
 */
public class Script {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        GenDirector.builder(new GenWorker(mpg));
    }

}
