package ru.kpfu.itis.kononenko.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

@WebFilter("/*")
public class TimeFilter implements Filter {

    private static final Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void init(FilterConfig filterConfig) {
        ServletContext servletContext = filterConfig.getServletContext();
        servletContext.log("TimeFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long endTime = System.currentTimeMillis();

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        LOG.info("TimeFilter executed in {} ms, Request URL: {}, Method: {}",
                (endTime - startTime),
                httpRequest.getRequestURL(),
                httpRequest.getMethod());
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
