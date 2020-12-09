package com.zzp.nacos.user.test;

import com.alibaba.fastjson.JSON;
import com.zzp.nacos.user.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * @Description IUserServiceTest
 * @Author karyzeng
 * @since 2020.12.02
 **/
@RunWith(SpringRunner.class)
//@SpringBootTest
public class IUserServiceTest {

    @Test
    public void createMockObject() throws Exception{
        List<User> mockList = mock(List.class);
        User user1 = new User();
        user1.setId(100);
        user1.setAge(18);
        User user2 = new User();
        user2.setId(200);
        user2.setAge(28);
        when(mockList.get(0)).thenReturn(user1).thenReturn(user2);
        for (int i = 0; i < 2; i++) {
            System.out.println(JSON.toJSONString(mockList.get(0)));
        }

        Assert.assertTrue(mockList instanceof List);
    }

}
