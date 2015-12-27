package hu.fnf.devel.wishbox.model.test;

import de.flapdoodle.embed.mongo.MongodExecutable;
import hu.fnf.devel.wishbox.model.ModelApplication;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jbehave.core.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DatabaseCRUDSteps {

    private Object o;
    private MongodExecutable mongodExecutable;
    private ConfigurableApplicationContext applicationContext;
    private HttpResponse httpResponse;

    @AfterStory
    public void after() {
        System.out.println("AFTER STORY");
        SpringApplication.exit(applicationContext);
    }

    @BeforeStory
    public void before() throws IOException {
        System.out.println("BEFORE STORY");
        // http://stackoverflow.com/questions/6437226/embedded-mongodb-when-running-integration-tests
//        MongodStarter starter = MongodStarter.getDefaultInstance();
//
//        int port = 27017;
//        IMongodConfig mongodConfig = new MongodConfigBuilder()
//                .version(Version.Main.PRODUCTION)
//                .net(new Net(port, Network.localhostIsIPv6()))
//                .build();
//
//        mongodExecutable = null;
//        mongodExecutable = starter.prepare(mongodConfig);
//        MongodProcess mongod = mongodExecutable.start();
//
//        MongoClient mongo = new MongoClient("localhost", port);
//
        applicationContext = SpringApplication.run(ModelApplication.class);
//        System.out.println("a");
    }

    @AfterStories
    public void afters() {
        System.out.println("AFTER STORIES");
//        SpringApplication.exit(applicationContext);
//        mongodExecutable.stop();
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

                ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8081/" + path, Object[].class);
                Object[] objs = responseEntity.getBody();
                MediaType contentType = responseEntity.getHeaders().getContentType();
                HttpStatus statusCode = responseEntity.getStatusCode();

                o = objs[0];
                break;
            }
            case "POST": {
                org.apache.http.client.HttpClient httpClient = HttpClientBuilder.create().build();
                HttpPost httpPost = new HttpPost("http://localhost:8081/" + path);
                StringEntity entity = new StringEntity(payload);
                httpPost.setEntity(entity);

                httpResponse = httpClient.execute(httpPost);
            }

        }

    }

    @SuppressWarnings("unchecked")
    @Then("a <response> is received")
    public void thenResponse(@Named("response") String response) {
        switch (response) {
            case "List<Wish>": {
                assertTrue(((Map<String, String>) o).get("label").equals("a"));
                break;
            }
            case "List<Notification>": {
                assertTrue(((Map<String, String>) o).get("text").equals("b"));
                break;
            }
            default: {
                assertEquals(204, httpResponse.getStatusLine().getStatusCode());
            }
        }
    }

}
