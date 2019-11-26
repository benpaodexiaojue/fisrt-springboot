package com.fisrtspringboot;

import com.fisrtspringboot.model.AyUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
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
}
