package name.dnr.bootlab.web;

import name.dnr.bootlab.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WebController {



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
