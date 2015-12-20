package hu.fnf.devel.wishbox.model.test;

import hu.fnf.devel.wishbox.model.entity.Notification;
import hu.fnf.devel.wishbox.model.entity.Wish;
import hu.fnf.devel.wishbox.model.entity.mongo.WishMongo;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jbehave.core.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class DatabaseCRUDSteps {
    private Object o;

    @AfterStory
    public void after() {
        System.out.println("AFTER STORY");
    }

    @BeforeStory
    public void before() throws IOException {
        System.out.println("BEFORE STORY");
        // http://stackoverflow.com/questions/6437226/embedded-mongodb-when-running-integration-tests
    }

    @AfterStories
    public void afters() {
        System.out.println("AFTER STORIES");
    }

    @BeforeStories
    public void befores() {
        System.out.println("BEFORE STORIES");
    }

    @Given("a started REST Service with the library and a mondogdb uploaded with test data")
    public void givenService() {

    }

    @When("a REST <action> with <path> with <payload> is initiated")
    public void restRequest(@Named("action") String action, @Named("path") String path, @Named("payload") String payload) throws IOException {
        switch (action) {
            case "GET": {
                RestTemplate restTemplate = new RestTemplate();

                ResponseEntity<WishMongo[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/" + path, WishMongo[].class);
                Object[] objs = responseEntity.getBody();
                MediaType contentType = responseEntity.getHeaders().getContentType();
                HttpStatus statusCode = responseEntity.getStatusCode();

                o = objs[0];
                break;
            }
            case "POST": {
                org.apache.http.client.HttpClient httpClient = HttpClientBuilder.create().build();
                HttpPost httpPost = new HttpPost("http://localhost:8080/" + path);
                StringEntity entity = new StringEntity(payload);
                httpPost.setEntity(entity);

                httpClient.execute(httpPost);
            }

        }

    }

    @Then("a <response> is received")
    public void thenResponse(@Named("response") String response) {
        switch (response) {
            case "List<Wish>": {
                assertTrue(o instanceof Wish);
                break;
            }
            case "List<Notification>": {
                assertTrue(o instanceof Notification);
                break;
            }
        }
    }

}
