package com.dfggking.cache;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import net.sf.ehcache.CacheManager;

/**
 * 基于Ehcache的缓存工具类
 * <p>
 * </p>
 * 
 * <pre></pre>
 * 
 * @author jinyf
 * @date 2017年3月22日 下午5:27:48
 * @since 1.0
 */
// @Component
public class CacheUtil{
    private final static Logger log = LogManager.getLogger(CacheUtil.class);
    /** Ehcache配置文件路径 */
    private final static String DEFAULT_PATH = "ehcache.xml";
    /** 这是2级cache，第1级存储类型，第2级存储某一类型的key-value */
    private static CacheManager manager = null;
    static{
        manager = CacheManager.create(DEFAULT_PATH);
    }
    
}
