package cl.vividseats.fit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindTheCelebrityTest {

    @Test
    void whenExistOnePersonWithEmptyPersonListByKnownByAll_returnPersonNameAsCelebrity() {
        Person mike = new Person("Mike");
        Person hugo = new Person("Hugo");
        Person maria = new Person("Maria");
        //The celebrity is Donald Trump
        Person donaldTrump = new Person("Donald Trump");

        mike.addKnownPerson(donaldTrump);
        mike.addKnownPerson(hugo);
        hugo.addKnownPerson(maria);
        hugo.addKnownPerson(donaldTrump);
        maria.addKnownPerson(hugo);
        maria.addKnownPerson(donaldTrump);

        List<Person> personList = Arrays.asList(mike, hugo, maria, donaldTrump);

        Assertions.assertEquals(donaldTrump.getName(), FindTheCelebrity.lookForCelebrity(personList));
    }

    @Test
    void whenThereAreNotPersonsWithEmptyPersonList_returnNullBecauseThereAreNotCelebrities() {
        Person mike = new Person("Mike");
        Person hugo = new Person("Hugo");
        Person maria = new Person("Maria");

        mike.addKnownPerson(hugo);
        hugo.addKnownPerson(maria);
        maria.addKnownPerson(hugo);

        List<Person> personList = Arrays.asList(mike, hugo, maria);

        assertNull(FindTheCelebrity.lookForCelebrity(personList));
    }

    @Test
    void whenExistMoreThanOnePersonWithEmptyPersonList_returnNullBecauseThereAreNotCelebrities() {
        Person mike = new Person("Mike");
        Person hugo = new Person("Hugo");
        Person maria = new Person("Maria");
        //Two persons with empty person list
        Person donaldTrump = new Person("Donald Trump");
        Person duffyDuck = new Person("Duffy Duck");

        mike.addKnownPerson(donaldTrump);
        mike.addKnownPerson(hugo);
        hugo.addKnownPerson(maria);
        hugo.addKnownPerson(donaldTrump);
        maria.addKnownPerson(hugo);
        maria.addKnownPerson(donaldTrump);

        List<Person> personList = Arrays.asList(mike, hugo, maria, donaldTrump, duffyDuck);

        assertNull(FindTheCelebrity.lookForCelebrity(personList));
    }
}