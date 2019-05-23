package com.lizhi.demo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

/**
 * 过滤器
 *
 * @author xulizhi-lenovo
 * @date 2019/5/23
 */
@Slf4j
@WebFilter(filterName = "ayUserFilter", urlPatterns = "/*")
public class AyUserFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(new Date()+"---------->>> init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println(new Date()+"---------->>> doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println(new Date()+"---------->>> destory");
    }
}
