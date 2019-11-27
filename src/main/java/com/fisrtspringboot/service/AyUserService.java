package com.fisrtspringboot.service;

import com.fisrtspringboot.model.AyUser;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AyUserService {
  AyUser findById(String id);
  List<AyUser> findAll();
  AyUser save(AyUser ayUser);
  void delete(AyUser ayUser);
  List<AyUser> saveAll(List<AyUser> users);
  Page<AyUser> findAll(Pageable pageable);

}
