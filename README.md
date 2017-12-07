

Design and create a RESTful API that could be used to manage a list of dog images. 

* List all of the available dog pictures grouped by breed
* List all of the available dog pictures of a particular breed
* Vote up and down a dog picture
* The details associated with a dog picture

The information the Dog Breed App needs to function is:

* A URL to a dog picture
* The number of time the picture was favorited
* The dog's breed
* Any other information required to identify a specific dog

The Dog Breed App expects the response to be sorted by the number of times the picture was favorited. The pictures may be sorted


Each client is allowed to vote once for any particular dog picture.


The project is already configured go use Spring MVC and talks to an in memory HSQLDB to store the results. 

The Spring Boot Started Test module is included to facilitate both unit and integration tests.

This project uses Maven for builds and Java 8 features.


