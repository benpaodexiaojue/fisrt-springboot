package com.fisrtspringboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AyUserContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("------------AyUser Context Listener init--------------");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("------------AyUser Context Listener destroyed--------------");
  }
}
