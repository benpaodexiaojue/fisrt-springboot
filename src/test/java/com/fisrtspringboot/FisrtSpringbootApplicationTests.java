package com.fisrtspringboot;


import com.fisrtspringboot.model.AyUser;
import com.fisrtspringboot.repository.AyUserRepository;
import com.fisrtspringboot.service.AyUserService;
import com.fisrtspringboot.service.impl.AyUserServiceImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootTest
class FisrtSpringbootApplicationTests {

  @Resource
  private JdbcTemplate jdbcTemplate;

  @Test
  void contextLoads() {
  }

  @Test
  public void mysqlTest() {
    String sql = "Select id,name, password from ay_user";
    List<AyUser> userList = jdbcTemplate.query(sql, new RowMapper<AyUser>() {
      @Override
      public AyUser mapRow(ResultSet resultSet, int i) throws SQLException {
        AyUser ayUser = new AyUser();
        ayUser.setId(resultSet.getString("id"));
        ayUser.setName(resultSet.getString("name"));
        ayUser.setPassword(resultSet.getString("password"));
        return ayUser;
      }
    });
    for (AyUser ayUser : userList) {
      System.out.println("id: " + ayUser.getId() +"  name: "+ ayUser.getName());
    }
  }

  @Resource
  private AyUserRepository ayUserRepository;

  @Test
  public void testRepository() {
    List<AyUser> ayUsers = ayUserRepository.findAll();
    System.out.println(ayUsers.size());

    Page<AyUser> page = ayUserRepository.findAll(PageRequest.of(0, 1));
    System.out.println(page.getTotalPages());
    System.out.println(page.getContent().get(0).getName());


  }

  @Resource
  private AyUserService ayUserService;

  @Test
  void testTransaction() {
    AyUser ayUser = new AyUser();
    ayUser.setId("3");
    ayUser.setName("阿傻");
    ayUser.setPassword("654321");
    ayUserService.save(ayUser);
  }


}
