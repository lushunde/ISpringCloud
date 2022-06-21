package top.incoding.cloud.iuser.config;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/21 10:23
 * @Version 1.0.0
 **/

@Component
@Order(0)
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        System.err.println("============================== servletRequest = " + servletRequest + ", servletResponse = " + servletResponse + ", filterChain = " + filterChain);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
