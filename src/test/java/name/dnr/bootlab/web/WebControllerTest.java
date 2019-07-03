package name.dnr.bootlab.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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

    /*测试URL获取参数并打印*/
    @Test
    public void testGetMrthodWithParameterInURL()throws Exception{
        // 这种写法是直接打印Http相应内容
        // mockMvc.perform(MockMvcRequestBuilders.get("/get/eric")).andDo(print());

        // 这里由于通过URL使用GET方法传递参数,然后controller直接返回获取到的参数
        // 要直接获取参内容是这样的
        String response=mockMvc.perform(MockMvcRequestBuilders.get("/get/小明"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        // GET方式提交的参数编码只支持ISO-8859-1，所以在获取过后再在此处进行编码转换
        response=new String(response.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println(response);
    }
}
