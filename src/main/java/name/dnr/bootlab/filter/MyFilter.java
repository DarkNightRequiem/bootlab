package name.dnr.bootlab.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义Filter有两种实现方式：
 * 1 使用@WebFilter
 * 2 使用FilterRegistrationBean
 * 以下使用方式2
 *  - 实现Filter接口(javax.servlet包里的)，实现doFilter()方法
 *  - 添加 @Configuration注解将自定义的Filter加入过滤链
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获取Http请求
        HttpServletRequest request=(HttpServletRequest)servletRequest;

        // 输出过滤信息
        System.out.println(
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+
                "   "+"【MyFilter】"+
                "url:  "+request.getRequestURI()+
                "method:"+request.getMethod());
        // 过滤链继续处理
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
