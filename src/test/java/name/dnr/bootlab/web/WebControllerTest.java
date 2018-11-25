package name.dnr.bootlab.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 在Spring Boot中使用MockMVC 进行web测试
 * MockMVC内之许多工具，可以模仿请求，并且判断
 * 返回的结果是否正确
 * 使用注解：
 * SpringBootTest 系统会自动加载Spring Boot容器。日常测试时可以注入Bean以做一些局部业务测试
 * Before 在测试启动时优先执行，一般用作资源初始化
 */
@SpringBootTest
public class WebControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc= MockMvcBuilders.standaloneSetup(new WebController()).build();
    }

    @Test
    public void saveUsers()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/saveUser")
                .param("name","")
                .param("age","777")
                .param("pass","test"));
    }
}
