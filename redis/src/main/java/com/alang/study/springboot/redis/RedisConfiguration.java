package com.alang.study.springboot.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {
	
	@SuppressWarnings("rawtypes")
	@Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        RedisTemplate redisTemplate = new RedisTemplate<String,String>();
        redisTemplate.setConnectionFactory(factory);
        //by default spring redis will use JdkSerializationRedisSerializer as key serializer to serialize the key to
        //byte array, thus it will display mess codes in redis.
        //as restricted, the key has to be passed with string. in case of Long/Integer, then you need to use .toString() before pass
        //to redis.
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        
        //using json format instead of byte[]
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
}
