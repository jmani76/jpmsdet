package org.jpmsdet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.dto.Posts;
import org.helpers.Postman;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class PostsStepDefinitions {

    /**
     * Postman is a helper class to make 'Rest' api requests with ease.
     */
    private final Postman postman;

    private JsonPath postmanResponse;

    public PostsStepDefinitions() {
        postman = new Postman();
    }

    @Given("the following endpoint is available")
    public void theFollowingEndpointIsAvailable(String endpoint) {
        postman.setEndPointUrl(endpoint);
    }

    @When("a {string} rest api call is made to uri {string}")
    public void aGetRestApiCallIsMadeToUriPosts(String method, String uri) throws Exception {
        if (method.equalsIgnoreCase("get")) {
            postmanResponse = postman.Get(uri);
            assertThat(postman.getRestStatusCode()).isEqualTo(200);
            assertThat(postman.getRestStatusDescription()).isEqualTo("HTTP/1.1 200 OK");
        }
        else {
            throw new Exception("Method: " + method + " not supported in the current version!");
        }
    }

    @Then("endpoint returns status code as {int}")
    public void endpointReturnsStatusCodeAs(int expectedStatusCode) {
        assertThat(postman.getRestStatusCode()).isEqualTo(expectedStatusCode);
    }

    @Then("response obtained contains one or more posts")
    public void responseObtainedContainsOneOrMorePosts() {
        assertThat(postmanResponse).isNotNull();
        List<Posts> responsePosts = postmanResponse.getList("", Posts.class);
        assertThat(responsePosts.size()).isGreaterThan(0);
    }

    @Then("a post in the response contains values for the following keys")
    public void aPostInTheResponseContainsValuesForTheFollowingKeys(List<String> expectedJsonKeys) throws Exception{

        assertThat(postmanResponse).isNotNull();

        // Just sampling the first of the post record to ensure it actually contains some values and is not blank.
        List<Posts> responsePosts = postmanResponse.getList("", Posts.class);
        if(responsePosts.size() > 0) {
            Posts post = responsePosts.get(0);
            for(String key : expectedJsonKeys) {
                switch (key)
                {
                    case "userId":
                        assertThat(post.getUserId()).isNotBlank();
                        break;
                    case "id":
                        assertThat(post.getId()).isNotBlank();
                        break;
                    case "title":
                        assertThat(post.getTitle()).isNotBlank();
                        break;
                    case "body":
                        assertThat(post.getBody()).isNotBlank();
                        break;
                    default:
                        throw new Exception("Unsupported Json key provided!");
                        //code
                }
            }
        }
    }

    @Then("response obtained contains {int} posts")
    public void responseObtainedContainsPosts(int expectedNumberOfPosts) {
        List<Posts> responsePosts = postmanResponse.getList("", Posts.class);
        assertThat(responsePosts.size()).isEqualTo(expectedNumberOfPosts);
    }

}
