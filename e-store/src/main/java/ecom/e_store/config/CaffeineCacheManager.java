package ecom.e_store.config;

import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineCacheManager {

    @Bean(name = "myCaffeineCacheManager")
    public CacheManager caffeineCacheManager() {
        CaffeineCache productCache = new CaffeineCache(
                "products",
                Caffeine.newBuilder()
                .expireAfterWrite(60, TimeUnit.MINUTES)
                .initialCapacity(1000)
                .build());
        CaffeineCache roleCache = new CaffeineCache(
                "roles",
                Caffeine.newBuilder()
                        .expireAfterWrite(1, TimeUnit.DAYS)
                        .initialCapacity(1000)
                        .build());
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(productCache, roleCache));
        return simpleCacheManager;
    }
}
