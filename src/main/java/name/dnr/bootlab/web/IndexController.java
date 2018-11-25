package name.dnr.bootlab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    // 这种写法必须在pom.xml中加入依赖spring-boot-starter-thymeleaf
    // 否则会出现url和视图重名的错误
    @RequestMapping("/")
    public String hello(ModelMap map){
        map.addAttribute("name","Spring Boot");
        return "index";
    }

    @RequestMapping("/sblearn")
    public String sbLearn(){
        return "sblearn";
    }
}
