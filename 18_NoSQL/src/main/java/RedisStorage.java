import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.Date;

public class RedisStorage {
    String storageName;
    Jedis jedis = new Jedis();


    RedisStorage (String storageName){
        this.storageName = storageName;
    }

    void addUser (int member){
        jedis.zadd(storageName, new Date().getTime(), String.valueOf(member));
    }

    void updateUser (int member){
        jedis.zadd(storageName, new Date().getTime(), String.valueOf(member));
    }

    String getLastUserValue(){
        String value = Collections.min(jedis.zrange(storageName, 0, 0));
        jedis.zadd(storageName, new Date().getTime(), String.valueOf(value));
        return value;
    }

    void flush(){
        jedis.flushDB();
    }
}
