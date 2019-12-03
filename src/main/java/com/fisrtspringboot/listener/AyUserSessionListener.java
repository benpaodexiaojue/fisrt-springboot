package com.fisrtspringboot.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class AyUserSessionListener implements HttpSessionListener {

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    System.out.println("-----------AyUser session Listener created.-----------------");
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    System.out.println("-----------AyUser session Listener destroyed.-----------------");
  }
}
