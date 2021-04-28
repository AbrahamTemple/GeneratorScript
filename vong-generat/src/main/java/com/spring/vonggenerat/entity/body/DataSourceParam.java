package com.spring.vonggenerat.entity.body;

import com.spring.vonggenerat.entity.InstanceParam;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 数据库配置参数
 */
@Data
public class DataSourceParam implements InstanceParam, Serializable {

    private volatile static DataSourceParam DSP;

    private String host = "8.135.100.252";

    private Integer port = 3306;

    private String table = "spare";

    private String driverName = "com.mysql.cj.jdbc.Driver";

    private String username = "root";

    private String password = "3626356";

    private String url =
            "jdbc:mysql://"+getHost()+":"+getPort()+"/"+getTable()+
            "?useUnicode=true&useSSL=false&characterEncoding=utf8";

    public static DataSourceParam getInstance(){
        if(DSP == null){
            synchronized (DataSourceParam.class) {
                DSP = new DataSourceParam();
            }
        } return DSP;
    }
}
