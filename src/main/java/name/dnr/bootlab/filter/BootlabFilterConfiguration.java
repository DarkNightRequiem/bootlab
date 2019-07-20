package name.dnr.bootlab.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BootlabFilterConfiguration {

    // 将自定义过滤器加入过滤链
    @Bean
    public FilterRegistrationBean MyFilterRegistration(){
        FilterRegistrationBean<MyFilter> registrationBean=new FilterRegistrationBean<MyFilter>();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("MyFilter");
        // order 的值越小优先级越高
        registrationBean.setOrder(6);
        return registrationBean;
    }
}
