package mvc.dao;

import java.util.ArrayList;
import mvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(1, "Tom"));
        people.add(new Person(2, "Chmo"));
        people.add(new Person(3, "Chert"));
        people.add(new Person(4, "Loh"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
