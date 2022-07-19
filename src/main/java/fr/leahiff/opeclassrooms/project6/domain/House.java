package fr.leahiff.opeclassrooms.project6.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class House {

    private String address;
    private List<String> medications;
    private List<String> allergies;
    private List<Person> persons = new ArrayList<>();

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getMedications() {
        return medications;
    }
    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public List<String> getAllergies() {
        return allergies;
    }
    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }


    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }


    public void addPerson(Person person){
        persons.add(person);
    }
    public void put(Person person1, Integer existing) {
    }

    public Integer get(Person person1) {
        return null;
    }

}
