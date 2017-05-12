package com.accenture.banking;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationBuilder {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
    private TestRestTemplate restTemplate;

   
    @Value("${server.port}")
    private int port;


    @Value("${spring.data.rest.base-path}")
    private String basePath;
	@Test
    public void getAccount() throws Exception {     
        Integer id = 3;
        String response = restTemplate.getForObject("http://localhost:" + port +  "offices/accounts/" +id, String.class);
        
        assertTrue(response.contains("2"));
    }

}
