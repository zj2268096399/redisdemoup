import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")

public class getValueTest {

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 设置
     */
@Test
    public void setValue(){
      redisTemplate.boundValueOps("name").set("zhangsanlisi");

    }

    /**
     * 获取数据
     */
    @Test
    public  void getValue(){
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    /**
     * 删除数据
     */
    public void deleteValue(){
        redisTemplate.delete("name");
    }
}
