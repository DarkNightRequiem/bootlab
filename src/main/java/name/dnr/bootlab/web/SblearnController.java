package name.dnr.bootlab.web;

import name.dnr.bootlab.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sblearn")
public class SblearnController {

    /*前端for循环和后端传到前端的表格的使用测试*/
    @RequestMapping("/testUserLists")
    public String getUserLists(ModelMap map){
        // 不好的编程规范，因为一般controller只做跳转
        // 这里仅是测试，所以就先在这里弄了
        List<User> users=new ArrayList<User>();
        User user=new User();
        user.setName("假面骑士555");
        user.setAge(16);
        user.setPass("123");
        users.add(user);

        user=new User();
        user.setName("假面骑士build");
        user.setAge(17);
        user.setPass("456");
        users.add(user);

        user=new User();
        user.setName("假面骑士w");
        user.setAge(18);
        user.setPass("789");
        users.add(user);

        map.addAttribute("users",users);
        return "sblearn/testUserLists";
    }
}
