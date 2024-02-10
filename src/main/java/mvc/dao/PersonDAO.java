package mvc.dao;

import java.util.ArrayList;
import mvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 42, "tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Chmo", 17, "chmo@mail.ru" ));
        people.add(new Person(++PEOPLE_COUNT, "Chert", 32, "chert@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Loh", 24, "loh@mail.ru"));

    }

    public List<Person> index() {
        return people;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void edit(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
