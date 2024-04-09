package com.thrive.tagbackend.core.repository;

import com.thrive.tagbackend.core.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.core.RedisTemplate;

public interface TagRepository extends JpaRepository<Tag, String> {

    RedisTemplate<String, byte[]> redisTemplate();

}
