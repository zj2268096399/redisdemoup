import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")


public class getListTest {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 向list集合 右压栈存储
     * 【张三，李四，王五】
     */
    @Test
    public  void setRightList(){
        redisTemplate.boundListOps("listTest1").rightPush("张三");
        redisTemplate.boundListOps("listTest1").rightPush("李四");
        redisTemplate.boundListOps("listTest1").rightPush("王五");
    }

    /**
     * 通过索引获取list的下标为几的数据
     * 通过range 获取list的下表的范围，并且包含头和尾
     */
    @Test
    public void getRightList(){
        Object index1 = redisTemplate.boundListOps("listTest1").index(1);
        System.out.println(index1);
        List range1 = redisTemplate.boundListOps("listTest1").range(0, 2);
        System.out.println(range1);
    }

    /**
     * list集合左压栈
     */
    @Test
    public  void setLeftList(){
        redisTemplate.boundListOps("listTest2").leftPush("张福");
        redisTemplate.boundListOps("listTest2").leftPush("张富");
        redisTemplate.boundListOps("listTest2").leftPush("张富贵");
}

    @Test
    public void getLeftList(){
        Object index1 = redisTemplate.boundListOps("listTest2").index(1);
        System.out.println(index1);
        List range1 = redisTemplate.boundListOps("listTest2").range(0, 2);
        System.out.println(range1);
    }

    /**
     * 移除某个元素
     */

    @Test
    public void deleteList(){
        // remove(long l,object obj)第一个参数 要删除元素的个数 （0全部删除） 第二个参数 元素值
        // 并且，如果元素值后面的个数不到参数一的个数，则删除当前元素后所有
        redisTemplate.boundListOps("listTest2").remove(2,"张福");
        List range1 = redisTemplate.boundListOps("listTest2").range(0, 2);
        System.out.println(range1);
    }
}
