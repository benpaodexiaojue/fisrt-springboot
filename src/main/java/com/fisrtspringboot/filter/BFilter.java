package com.fisrtspringboot.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(filterName = "bFilter", urlPatterns = "/*")
public class BFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("----------B Filter init------------");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("----------B Filter doFilter------------");
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
    System.out.println("----------B Filter destroy------------");
  }
}
