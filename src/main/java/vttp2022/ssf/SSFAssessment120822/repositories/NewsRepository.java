package vttp2022.ssf.SSFAssessment120822.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class NewsRepository {

    @Autowired
    @Qualifier("redislab")
    private RedisTemplate<String, String> redisTemplate;
    
    public void save(String news, String payload){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String saveArticle = (String) ops.get(news.toLowerCase());
    }

    public Optional<String> get(String news){
        ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
        String value = valueOp.get(news.toLowerCase());

        if (null == value)
            return Optional.empty();  // returns EMPTY BOX
            return Optional.of(value); // returns BOX WITH DATA TYPE: STRING .
        
    }

   
    
}

