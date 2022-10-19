package org.helpers;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postman {
    private String EndpointUrl;

    private int RestStatusCode;

    private String RestStatusDescription;

    public void setEndPointUrl(String url) {
        this.EndpointUrl = url;
    }

    public String getEndpointUrl() {
        if(this.EndpointUrl.endsWith("/")) {
            return this.EndpointUrl.substring(0, this.EndpointUrl.lastIndexOf("/"));
        }
        return this.EndpointUrl;
    }

    public void setRestStatusCode(int status) {
        this.RestStatusCode = status;
    }

    public int getRestStatusCode() {
        return this.RestStatusCode;
    }

    public void setRestStatusDescription(String desc) {
        this.RestStatusDescription = desc;
    }

    public String getRestStatusDescription() {
        return this.RestStatusDescription;
    }

    public Postman() {}

    public JsonPath Get(String uri) {

        RestAssured.baseURI = this.getEndpointUrl();

        RequestSpecification request = RestAssured.given();

        if (!uri.startsWith("/")) {
            uri = "/" + uri;
        }

        Response response = request.get(uri);

        setRestStatusCode(response.getStatusCode());
        setRestStatusDescription(response.getStatusLine());

        return response.getBody().jsonPath();
    }
}
