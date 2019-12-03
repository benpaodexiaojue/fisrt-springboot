package com.fisrtspringboot.filter;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfiguration {

  @Bean
  public ServletRegistrationBean druidStatViewServlet(){
    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

    servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
    servletRegistrationBean.addInitParameter("loginUserName", "admin");
    servletRegistrationBean.addInitParameter("loginPassword", "123456");
    servletRegistrationBean.addInitParameter("resetEnable", "false");
    return servletRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean druidStatFilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
    filterRegistrationBean.addUrlPatterns("/*");
    filterRegistrationBean.addInitParameter("exclusions", "*.js, *.gif, *.jpg, *,css, /druid/*");

    return filterRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean buildAFilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setOrder(4);
    filterRegistrationBean.setFilter(new AiUserFilter());
    filterRegistrationBean.setName("filter1");
    filterRegistrationBean.addUrlPatterns("/*");
    return filterRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean buildDFilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setOrder(3);
    filterRegistrationBean.setFilter(new AyUserFilter());
    filterRegistrationBean.setName("filter4");
    filterRegistrationBean.addUrlPatterns("/*");
    return filterRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean buildBFilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setOrder(1);
    filterRegistrationBean.setFilter(new BFilter());
    filterRegistrationBean.setName("filter2");
    filterRegistrationBean.addUrlPatterns("/*");
    return filterRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean buildCFilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setOrder(2);
    filterRegistrationBean.setFilter(new CFilter());
    filterRegistrationBean.setName("filter3");
    filterRegistrationBean.addUrlPatterns("/*");
    return filterRegistrationBean;
  }


}
