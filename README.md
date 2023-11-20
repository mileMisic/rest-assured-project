Purpose of this project is an exercise of test automation of https://swapi.dev/ in Java using restAssured library and JUnit framework.

Use case 
1. Find film with a title ”A New Hope”

2. Using previous response (1) find person with name “Biggs Darklighter” among the characters that were part of that film.

3. Using previous response (2) find which starship he/she was flying on.

4. Using previous response (3) check next:
   
    a. starship class is “Starfighter”
   
    b. “Luke Skywalker” is among pilots that were also flying this kind of starship