package cl.vividseats.fit;

import java.util.List;
import java.util.stream.Collectors;

public class FindTheCelebrity {

    /**
     * Find a Person that is a celebrity, given by the rule "known by everyone" (every person in the list)... "but he/she
     * doesn't know anybody" (in other words, a celebrity keeps its person list empty).
     * @param personList
     * @return celebrity's name as String or null if there is no celebrity
     */
    public static String lookForCelebrity(List<Person> personList) {
        var lonelyPeople = personList.stream()
                .filter(person -> person.getRelatedPersons().isEmpty())
                .collect(Collectors.toList());

        //In order to satisfy the rule "a celebrity is known by everyone but he/she doesn't know anybody.", it´s
        //necessary to find exactly 1 record. Otherwise, the rule is not valid.
        if(lonelyPeople.size() == 1){
            var celebrityCandidate = lonelyPeople.get(0);
            var isCelebrity = personList.stream().filter(person -> !person.equals(celebrityCandidate))
                    .allMatch(personMatch -> personMatch.getRelatedPersons().contains(celebrityCandidate));

            if(isCelebrity){
                return celebrityCandidate.getName();
            }
        }

        return null;
    }
}
