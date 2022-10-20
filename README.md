# JPM SDET Project

This project is developed using Java-8, Maven, RestAssured and Cucumber

You should be able to import this file as a maven project in an IDE such as IntelliJ Idea (from Jetbrains)

Once the project is imported into Intellij you can simply Run the `posts.feature` file using IDE's built in runner.

Alternatively from the command prompt or terminal you can run the tests using the following maven command:

Assuming maven (mvn) is in your system environment path, execute the following:

`mvn test`

Additionally, I have also enabled Github Actions, so the tests can be built and run using Github Actions.

You can also execute the `Java CI with Maven` CI Workflow manually from Github Actions.
