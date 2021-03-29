package com.penguins.cloud.cloudpenguinsauth;

import com.penguins.cloud.cloudpenguinsauth.security.JwtTokenGenerator;
import com.penguins.cloud.cloudpenguinsauth.security.JwtTokenPair;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CloudPenguinsAuthApplicationTests {


  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private JwtTokenGenerator jwtTokenGenerator;

  @Test
  @WithMockUser(value = "zhengbing", password = "123456")
  public void contextLoads() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/foo/test")).andExpect(SecurityMockMvcResultMatchers.authenticated());
  }

  @Test
  public void jwtTest() {
    HashSet<String> roles = new HashSet<>();
    HashMap<String, String> additional = new HashMap<>();
    additional.put("uname", "penguinscn");

    JwtTokenPair jwtTokenPair = jwtTokenGenerator.jwtTokenPair("133", roles, additional);

    System.out.println("jwtTokenPair = " + jwtTokenPair);
  }
}
