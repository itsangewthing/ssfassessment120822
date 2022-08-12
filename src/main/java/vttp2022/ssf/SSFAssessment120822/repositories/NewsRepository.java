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
        String value = (String) ops.get(news.toLowerCase());
    }

    public Optional<String> get(String news){
        ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
        String value2 = valueOp.get(news.toLowerCase());

        if (null == value2)
            return Optional.empty();  // returns EMPTY BOX
            return Optional.of(value2); // returns BOX WITH DATA TYPE: STRING .
        
    }

   
    
}

