package com.hans.common.infrastructure.redis;

import com.hans.common.config.RedisConfig;
import com.hans.common.handler.RedisHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisDataServiceImpl implements RedisDataService {

    private final RedisHandler redisHandler;
    private final RedisConfig redisConfig;

    @Override
    public boolean setSingleData(String key, Object value) {
        if (value instanceof Integer) {
            value = String.valueOf(value);
        }
        Object saveValue = value;
        return redisHandler.executeOperation(() -> redisHandler.getValueOperations().set(key, saveValue));
    }

    @Override
    public boolean setSingleData(String key, Object value, Duration duration) {
        return redisHandler.executeOperation(() -> redisHandler.getValueOperations().set(key, value, duration));
    }

    @Override
    public String getSingleData(String key) {
        if (redisHandler.getValueOperations().get(key) == null) return "";
        return String.valueOf(redisHandler.getValueOperations().get(key));
    }

    @Override
    public boolean deleteSingleData(String key) {
        return redisHandler.executeOperation(() -> redisConfig.redisTemplate().delete(key));
    }

    @Override
    public boolean setAndVerify(String key, Object value) {
        String lua = "redis.call('SET', KEYS[1], ARGV[1]);" +
                "local stored = redis.call('GET', KEYS[1]);" +
                "if stored == ARGV[1] then return 1 else return 0 end";

        DefaultRedisScript<Long> script = new DefaultRedisScript<>(lua, Long.class);
        Long result = redisConfig.redisTemplate().execute(script, List.of(key), value.toString());

        return result != null && result == 1L;
    }
}
