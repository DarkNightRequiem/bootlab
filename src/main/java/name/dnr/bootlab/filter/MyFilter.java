package name.dnr.bootlab.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        System.out.println("this is MyFilter,url :"+ request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
