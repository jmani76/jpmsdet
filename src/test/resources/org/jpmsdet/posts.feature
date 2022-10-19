Feature: Validate posts
  This feature file validates the response from jsonplaceholder endpoint to contain minimum of 100 posts
  and other relevant scenarios to provide more coverage, thus ensures more robustness of the response.

  Background:
    Given the following endpoint is available
      |https://jsonplaceholder.typicode.com|
    When a 'get' rest api call is made to uri 'posts'

  Scenario: validate endpoint returns 200 OK
    Then endpoint returns status code as 200

  Scenario: validate posts contain valid information
    Then a post in the response contains values for the following keys
      | userId |
      | id     |
      | title  |
      | body   |

  Scenario: validate response contains posts
    Then response obtained contains one or more posts

  Scenario: validate minimum of 100 posts are returned
    Then response obtained contains 100 posts

