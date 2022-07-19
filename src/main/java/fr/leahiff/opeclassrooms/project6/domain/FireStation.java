package fr.leahiff.opeclassrooms.project6.domain;

import java.util.ArrayList;
import java.util.List;

public class FireStation {

    private String station;
    private String address;
    private List<Person> persons = new ArrayList<>();

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public String getStation() {
        return station;
    }
    public void setStation(String station) {
        this.station = station;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    public void addPerson(Person person) {
        persons.add(person);
    }
}
