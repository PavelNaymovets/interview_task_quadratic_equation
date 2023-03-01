package com.interview.task.quadraticEquation;

import com.interview.task.quadraticEquation.controller.rest.EquationRequest;
import com.interview.task.quadraticEquation.controller.rest.EquationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void equationTestOne() throws Exception {
        EquationResponse response = restTemplate.postForObject(
                new URL("http://localhost:" + port + "/task/api/v1/equation/resolve").toString(),
                new EquationRequest(1., 2., -3.),
                EquationResponse.class);

        Assertions.assertEquals(1., response.getX1());
        Assertions.assertEquals(-3., response.getX2());
    }

    @Test
    void equationTestTwo() throws Exception {
        EquationResponse response = restTemplate.postForObject(
                new URL("http://localhost:" + port + "/task/api/v1/equation/resolve").toString(),
                new EquationRequest(1., 1., -2.),
                EquationResponse.class);

        Assertions.assertEquals(1., response.getX1());
        Assertions.assertEquals(-2., response.getX2());
    }

}
