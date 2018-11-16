package name.dnr.bootlab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/sblearn")
    public String sbLearn(){
        return "sblearn";
    }
}
