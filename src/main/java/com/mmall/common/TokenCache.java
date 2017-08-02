package com.mmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by lance on 2017/7/24.
 */
public class TokenCache {

    public static final String TOKEN_PREFIX = "token_";

    public static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS).build(new CacheLoader<String, String>() {
        // 默认的数据加载实现
        @Override
        public String load(String s) throws Exception {
            return "null";
        }
    });

    public static void setkey(String key, String value) {
        localCache.put(key, value);
    }

    public static String getkey(String key) {
        String value = null;
        try {
            value = localCache.get(key);
            if ("null".equals(value)) {
                return null;
            }
            return value;
        }catch (Exception e) {
            logger.error("localCache get error", e);
        }
        return null;
    }
}
