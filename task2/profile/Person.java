package profile;

import java.util.List;

public class Person {
    private String name;
    private String surname;
    private List<String> phones;
    private List<String> sites;
    private Address address;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<String> getPhones() {
        return phones;
    }

    public List<String> getSites() {
        return sites;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phones=" + phones +
                ", sites=" + sites +
                ", address=" + address +
                '}';
    }
}