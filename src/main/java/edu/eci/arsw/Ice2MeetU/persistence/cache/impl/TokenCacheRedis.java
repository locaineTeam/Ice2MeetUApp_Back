package edu.eci.arsw.Ice2MeetU.persistence.cache.impl;

import edu.eci.arsw.Ice2MeetU.entities.Token;
import edu.eci.arsw.Ice2MeetU.persistence.cache.ITokenCache;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.time.Duration;


@Repository
@Qualifier("TokenCacheRedis")
public class TokenCacheRedis implements ITokenCache {

    public static  final String TOKEN_KEY = "twilio_token";

    private HashOperations hashOperations;

    private ValueOperations valueOperations;

    private RedisTemplate redisTemplate;

    public TokenCacheRedis(RedisTemplate redisTemplate){

        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
        this.valueOperations = this.redisTemplate.opsForValue();


    }

    @Override
    public boolean exists(String name) {
        return redisTemplate.hasKey(getKey(name));

    }

    @Override
    public Token get(String name) {
        return (Token) valueOperations.get(getKey(name));
    }

    @Override
    public void set(String name, Token payload, long TTL) {
        valueOperations.set(getKey(name), payload, Duration.ofSeconds(TTL));


    }


    private String getKey(String name){
        return String.format("%s_%s", TOKEN_KEY,name);
    }
}
