package com.example.slowuserservice.rest.controller.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mtumilowicz on 2018-07-28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerHealthCheckTest {
    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void health() {
        assertThat(restTemplate
                        .getForEntity(
                                createURLWithPort("users/health"),
                                null)
                        .getStatusCode(),
                is(HttpStatus.OK));
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}