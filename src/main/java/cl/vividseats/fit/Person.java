package cl.vividseats.fit;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Person {
    private String name;
    private List<Person> relatedPersons = new ArrayList<>();

    public Person(String name){
        this.name = name;
    }

    public void addKnownPerson(Person person){
        this.relatedPersons.add(person);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }
}
