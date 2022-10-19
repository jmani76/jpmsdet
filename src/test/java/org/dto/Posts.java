package org.dto;

public class Posts {
    private final String userId;
    private final String id;
    private final String title;
    private final String body;

    /**
     * Default public constructor for the POJO class
     */
    public Posts() {
        userId = "";
        id = "";
        title = "";
        body = "";
    }

    /**
     * Gets the userId from the mapped object
     * @return userId of a given post
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Gets the id from the mapped object
     * @return id of a given post
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the title from the mapped object
     * @return title of a given post
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the body from the mapped object
     * @return body of a given post
     */
    public String getBody() {
        return body;
    }
}
