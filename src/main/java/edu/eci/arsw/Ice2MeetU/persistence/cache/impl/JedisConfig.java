package edu.eci.arsw.Ice2MeetU.persistence.cache.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * The type Jedis config.
 */
@Configuration
public class JedisConfig {

    /**
     * Jedis connection factory jedis connection factory.
     *
     * @return the jedis connection factory
     */
    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration =
                new RedisStandaloneConfiguration("13.85.31.35", 6379);
        return new JedisConnectionFactory(redisStandaloneConfiguration);

    }

    /**
     * Redis template redis template.
     *
     * @return the redis template
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String,Object> template = new RedisTemplate<>();

        JedisConnectionFactory f = jedisConnectionFactory();
        template.setConnectionFactory(f);

        return template;

    }

}
