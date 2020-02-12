import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")

public class getHashTest {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * hash put（key,value）
     */
    @Test
    public void setHash(){
        redisTemplate.boundHashOps("hashTest").put("son","唐多多");
        redisTemplate.boundHashOps("hashTest").put("mather","唐余姬");
        redisTemplate.boundHashOps("hashTest").put("father","梁斐");
    }

    /**
     * 获取所有的key值 keys（）
     */
    @Test
    public void getHashKeys(){
        Set hashTest = redisTemplate.boundHashOps("hashTest").keys();
        System.out.println(hashTest);

    }
    /**
     * 获取所有的value值 values（）
     */
    @Test
    public void getHashValues(){
        List hashTest = redisTemplate.boundHashOps("hashTest").values();
        System.out.println(hashTest);

    }

    /**
     * 根据key值获取value值
     */
    @Test
    public void getHashkeyToValue(){
        Object o = redisTemplate.boundHashOps("hashTest").get("son");
        System.out.println(o);

    }
    @Test
    public void  deleteHash(){
        redisTemplate.boundHashOps("hashTest").delete("son");
    }


}
