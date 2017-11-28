package com.dfggweb.util;

import java.util.UUID;

/**
 * 工具类
 * @author dfggking@hotmail.com
 * @create 2017-07-13
 * @since 1.0
 */
public class CommonsUtil {
    
    /**
     * 创建UUID, 长度36位
     * @author dfggking@hotmail.com
     * @create 2017-07-13
     * @return String
     * @since 1.0
     */
    public static String uuid(){
        return UUID.randomUUID().toString();
    }
}
