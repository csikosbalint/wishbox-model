package hu.fnf.devel.wishbox.model.test;

import hu.fnf.devel.wishbox.model.entity.Wish;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Given a started REST Service with the library
 * And a mondogdb uploaded with test data
 * When a REST <action> with <path> with <payload> is initiated
 * Then a <response> is received
 */

public class ModelMongoSteps {
    @Given("a started REST Service with the library")
    public void givenService() {
        TestApp.main(new String[]{""});
    }

    @When("a REST <action> with <path> with <payload> is initiated")
    public void restRequest(@Named("action") String action, @Named("path") String path, @Named("payload") String payload) {
        RestTemplate restTemplate = new RestTemplate();
        List<Wish> quote = restTemplate.getForObject("http://localhost:8080/wish", List.class);

        for (Wish w : quote) {
            System.out.println(w.getLabel());
        }
    }
}
