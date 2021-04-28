package com.spring.vonggenerat.builer;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 输入
 */
public class MyScanner {

    public static String scanner(String someThing) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + someThing + "：");
        if (scanner.hasNext()) {
            String sc = scanner.next();
            if (StringUtils.isNotEmpty(sc)) {
                return sc;
            }
        } throw new MybatisPlusException("请输入正确的" + someThing + "！");
    }

}
