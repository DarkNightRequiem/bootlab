package name.dnr.bootlab.web;

import name.dnr.bootlab.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class WebController {

    // 使用URL传参
    @RequestMapping(value = "/get/{name}",method = RequestMethod.GET)
    public String get(@PathVariable String name){
        // GET方式请求的编码只支持ISO_8859_1，所以在这里做编码转换
        name=new String(name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        return name;
    }


    @RequestMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result){
        // @Valid代表此对象使用了参数校验
        // 参数校验结果存放在BidingResult中
        System.out.println("user:"+user);
        if(result.hasErrors()){
            List<ObjectError> list=result.getAllErrors();
            for(ObjectError error:list){
                System.out.print(error.getCode()+"-"+error.getDefaultMessage());
            }
        }
    }
}
