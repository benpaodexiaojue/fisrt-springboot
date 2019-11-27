package com.fisrtspringboot.repository;

import com.fisrtspringboot.model.AyUser;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AyUserRepository extends JpaRepository<AyUser, String> {
  List<AyUser> queryByNameLike(String name);
  List<AyUser> findByNameIn(Collection<String> names);
}
