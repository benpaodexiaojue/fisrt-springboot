package com.fisrtspringboot.controller;

import com.fisrtspringboot.model.AyUser;
import com.fisrtspringboot.service.AyUserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ayUser")
public class AyUserController {

  @Resource
  private AyUserService ayUserService;


  @RequestMapping("/test")
  public String test(Model model){
    List<AyUser> ayUsers = ayUserService.findAll();
    model.addAttribute("users", ayUsers);
    return "ayUser";
  }

 @RequestMapping("/viewUser")
 @ResponseBody
  public AyUser viewUser(@RequestParam String id){
    AyUser ayUsers = ayUserService.findById(id);
   return ayUsers;
  }

}
