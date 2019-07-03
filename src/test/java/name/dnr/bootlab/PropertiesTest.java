package name.dnr.bootlab;

import name.dnr.bootlab.comm.OtherProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
    @Value("${name.dnr.bootlab.author}")
    String applicationAuthor;
    @Resource
    OtherProperties otherProperties;

    @Test
    public void testValueAnnotation(){
        Assert.assertEquals(applicationAuthor,"Eric Wang");
    }

    /*测试将.properties文件中的属性映射为对象接收*/
    @Test
    public void testOtherProperties(){
        System.out.println("Application Author:"+otherProperties.getAuthor());
        System.out.println("Application Name:"+otherProperties.getApplication());
    }
}
