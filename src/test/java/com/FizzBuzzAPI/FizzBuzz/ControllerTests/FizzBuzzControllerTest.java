package com.FizzBuzzAPI.FizzBuzz.ControllerTests;

import java.util.List;
import com.FizzBuzzAPI.FizzBuzz.Service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzBuzzControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testYourEndpoint() {
        List success = restTemplate.getForObject("http://localhost:" + port + "/api/getFizzBuzz?value=5", List.class);
        assertEquals(fizzBuzzService.getFizzBuzzList(5), success);
        String fail = restTemplate.getForObject("http://localhost:" + port + "/api/getFizzBuzz?value=dfs561", String.class);
        assertEquals("Only digits are allowed", fail);

    }
}
