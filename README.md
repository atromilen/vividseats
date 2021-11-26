# Vivid Seats Fit

Problem: Find the Celebrity

- In a team of N people, a celebrity is known by everyone but he/she doesn't know anybody.

THe solution is very straightforward and is using mainly streams to filter the data in the class "FindTheCelebrity". Was necessary to override the method Equals 
in order to do comparison between objects.

The scenarios are expressed as tests cases in the JUnit test "FindTheCelebrityTest". Those scenarios are the next:
- Exists a list of N persons and one of them is present in each other person, but this person doesn't reference to any person (Celebrity Found)
- There are no person with empty person list references (There is no celebrity).
- There is more than 1 person with an empty list person (There is no celebrity).

Coded using: Java 11, Junit 5, Gradle, Lombok.

Code Coverage with a 100%.
