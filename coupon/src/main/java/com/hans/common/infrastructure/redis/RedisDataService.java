package com.hans.common.infrastructure.redis;

import java.time.Duration;

public interface RedisDataService {
    boolean setSingleData(String key, Object value);

    boolean setSingleData(String key, Object value, Duration duration);

    String getSingleData(String key);

    boolean deleteSingleData(String key);

    boolean setAndVerify(String key, Object value);
}
