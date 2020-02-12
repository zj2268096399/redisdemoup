import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")

public class getSetTest{
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 通过add（“值”）向set集合添加值
     */
    @Test
    public  void addSet(){
        redisTemplate.boundSetOps("setTest").add("好多鱼");
        redisTemplate.boundSetOps("setTest").add("好有趣");
        redisTemplate.boundSetOps("setTest").add("好丽友");
        redisTemplate.boundSetOps("setTest").add("好朋友");
    }

    /**
     * 通过members（） 获取set的所有值
     */
    @Test
    public void getSet(){
        Set setTest = redisTemplate.boundSetOps("setTest").members();
        System.out.println(setTest);
    }

    /**
     * 删除set集合中的单个值 remove("值")
     */

    @Test
    public void removeSet(){
        redisTemplate.boundSetOps("setTest").remove("好朋友");
        Set setTest = redisTemplate.boundSetOps("setTest").members();
        System.out.println(setTest);
    }

    /**
     * 删除set集合中的所有值delete（）
     */

    @Test
    public void deleteSet(){
        redisTemplate.delete("setTest");
        Set setTest = redisTemplate.boundSetOps("setTest").members();
        System.out.println(setTest);
    }
}
