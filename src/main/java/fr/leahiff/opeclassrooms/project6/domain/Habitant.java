package fr.leahiff.opeclassrooms.project6.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Habitant {

    private String address;
    private String station;
    private String firstName;
    private String phone;
    private  Integer age;
    private List<Person> persons = new ArrayList<>();
    private List<String> medications;
    private List<String> allergies;
    private  MedicalRecord medicalRecord;



    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }


    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getStation() {
        return station;
    }
    public void setStation(String station) {
        this.station = station;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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

    public void addPerson(Person person){
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public static int getAgeFromBirthDate(String birth){
        try {
            Date birthdate = new SimpleDateFormat("MM/dd/yyyy").parse(birth);
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate localBirthdate = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int age = Period.between(localBirthdate, localDate).getYears();
            return age;
        }
        catch (Exception e){
            return 0;
        }

    }
}
