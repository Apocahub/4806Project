package sysc4806.pm4y.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    public void login() throws Exception {
        ResponseEntity<String> responseEntity = testRestTemplate.exchange("/", HttpMethod.GET, HttpEntity.EMPTY,String.class);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertNotNull(responseEntity.getBody());
    }

}