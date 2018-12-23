package ru.savimar.printpages.Controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PrintControllerTest {

    @LocalServerPort
    private int randomServerPort;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private String getResult(String url) throws URISyntaxException {
        if (randomServerPort == 0) {
            randomServerPort = 8080;
        }
        final String baseUrl = "http://localhost:" + randomServerPort + url;
        URI uri = new URI(baseUrl);
        return restTemplate.getForObject(uri, String.class);
    }

    @Test
    public void getStatistics() throws URISyntaxException {
        String result = getResult("/statistics?type=fax&device=device1");
        Assert.assertEquals(true, result.contains(
                "jobId\" : 3"));

    }

    @Test
    public void indexTest() throws URISyntaxException {

        String result = getResult("/job");
        Assert.assertEquals(true, result.contains("user1\":\"22\""));
    }


}

