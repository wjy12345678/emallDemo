package com.emall.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by Administrator on 2017/12/1 0001.
 */
public class propertiesUtil {
    private static Logger logger = LoggerFactory.getLogger(propertiesUtil.class);
    private static Properties props;
    static {
        String fileName = "emall.properties";
        props = new Properties();
        try{
            props.load(new InputStreamReader(propertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"utf-8"));
        }catch (IOException e){
            logger.error("配置文件读取异常",e);
        }

    }
    public static String getPropertity(String key){
        String value = props.getProperty(key.trim());
        if (StringUtils.isBlank(value)){
            return null;
        }
        return value.trim();
    }
    public static String getPropertity(String key,String defaultValue){
        String value = props.getProperty(key.trim());
        if (StringUtils.isBlank(value)){
            value = defaultValue;
        }
        return value.trim();
    }
}
