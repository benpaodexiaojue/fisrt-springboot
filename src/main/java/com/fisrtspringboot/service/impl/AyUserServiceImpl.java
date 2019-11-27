package com.fisrtspringboot.service.impl;

import com.fisrtspringboot.model.AyUser;
import com.fisrtspringboot.repository.AyUserRepository;
import com.fisrtspringboot.service.AyUserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AyUserServiceImpl  implements AyUserService {

  @Resource
  private AyUserRepository ayUserRepository;

  @Override
  public AyUser findById(String id) {
    return ayUserRepository.findById(id).get();
  }

  @Override
  public List<AyUser> findAll() {
    return ayUserRepository.findAll();
  }

  @Override
  public AyUser save(AyUser ayUser) {
    return ayUserRepository.save(ayUser);
  }

  @Override
  public void delete(AyUser ayUser) {
    ayUserRepository.delete(ayUser);
  }

  @Override
  public List<AyUser> saveAll(List<AyUser> users) {
    return ayUserRepository.saveAll(users);
  }

  @Override
  public Page<AyUser> findAll(Pageable pageable) {
    return ayUserRepository.findAll(pageable);
  }
}
