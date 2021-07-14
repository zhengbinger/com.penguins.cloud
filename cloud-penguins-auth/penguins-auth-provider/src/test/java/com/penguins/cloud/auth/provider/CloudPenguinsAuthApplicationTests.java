package com.penguins.cloud.auth.provider;

import com.penguins.cloud.auth.provider.security.jwt.JwtTokenGenerator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CloudPenguinsAuthApplicationTests {

  @Autowired private MockMvc mockMvc;
  @Autowired private JwtTokenGenerator jwtTokenGenerator;

  @Test
  //  @WithMockUser(value = "zhengbing", password = "123456")
  public void contextLoads() throws Exception {
    //    mockMvc
    //        .perform(MockMvcRequestBuilders.get("/foo/test"))
    //        .andExpect(SecurityMockMvcResultMatchers.authenticated());
  }

  @Test
  public void jwtTest() {
    HashSet<String> roles = new HashSet<>();
    HashMap<String, String> additional = new HashMap<>();
    additional.put("uname", "penguinscn");

    //    JwtTokenPair jwtTokenPair = jwtTokenGenerator.jwtTokenPair("133", roles, additional);
    //
    //    System.out.println("jwtTokenPair = " + jwtTokenPair);
  }
}
