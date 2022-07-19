package fr.leahiff.opeclassrooms.project6.controller;

import fr.leahiff.opeclassrooms.project6.DataLoader;
import fr.leahiff.opeclassrooms.project6.Project6Application;
import fr.leahiff.opeclassrooms.project6.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
public class FireStationController {

    @Autowired
    DataLoader dataLoader;

    static Logger logger = LoggerFactory.getLogger(Project6Application.class);

    @RequestMapping(value = "/phoneAlert", method = RequestMethod.GET)
    public Set<String> PersonPhone (@RequestParam(name = "firestation", required = false) String firestation) {
        logger.info("Entre dans la methode phoneAlert avec le parametre firestation");
       Set<String> result = new HashSet<>();
        for (FireStation current: dataLoader.fireStations) {
            if (firestation.equalsIgnoreCase(current.getStation())) {
                String stationCode = current.getStation();
                String stationAddress = current.getAddress();
                List<Person> persons = findPersonByStationAddress(stationAddress);
                for (Person person : persons) {
                   result.add(person.getPhone());
                }
            }
        }
        return result;
    }

    private List<Person> findPersonByStationAddress(String stationAddress){
        List<Person> result = new ArrayList<>();
        for(Person person: dataLoader.persons){
            if(person.getAddress().equalsIgnoreCase(stationAddress)){
                result.add(person);
            }
        }
        logger.debug("Sortie de la methode avec Json");
        return result;

    }

        @RequestMapping(value = "/fire", method = RequestMethod.GET)
        public Habitant habitant (@RequestParam(name ="address", required = false) String address) {
            logger.info("Entre dans la methode fire avec le parametre address");
            Habitant result = new Habitant();
            for(Person person : dataLoader.persons){

            if(address.equalsIgnoreCase(person.getAddress())){
                Habitant habitant = findHabitantByAddress(address);
                String tmp = Utils.getBirthdate(person.getFirstName(), person.getLastName(), dataLoader.medicalRecords);

                int age = person.getAgeFromBirthDate(tmp);

                Person person1 = new Person();
                String stationCode = getStationCodeByAddress(address);
                habitant.setAddress(address);
                person1.setStation(stationCode);
                person1.setAge(age);
                person1.setFirstName(person.getFirstName());
                person1.setAddress(person.getAddress());
                person1.setPhone(person.getPhone());
                MedicalRecord mr = getMedicalRecordForPerson(dataLoader.medicalRecords, person);
                person1.setMedicalRecord(Utils.getUsefulMedicalInformation(mr));

                result.addPerson(person1);

            }
        }
            logger.debug("Sortie de la methode avec Json");
        return result;

    }

    private String getStationCodeByAddress(String address){
        for (FireStation fireStation : dataLoader.fireStations) {
            if(fireStation.getAddress().equalsIgnoreCase(address)){
                return fireStation.getStation();
            }
        }
        return null;
    }

    private Habitant findHabitantByAddress(String address){
        Habitant result = new Habitant();
        for (Person person : dataLoader.persons){
            if(person.getAddress().equalsIgnoreCase(address)){
            }
        }
        return result;
    }

    private List<Person> findPersonsByAddress(String address) {
        List<Person> result = new ArrayList<>();
        for (Person person : dataLoader.persons) {
            if (person.getAddress().equalsIgnoreCase(address)) {
                result.add(person);
            }
        }
        return result;
    }


    private MedicalRecord getMedicalRecordForPerson(List<MedicalRecord> mr, Person person) {
        for (int i = 0; i < mr.size(); i++) {
            MedicalRecord medicalRecords = mr.get(i);
            if (medicalRecords.getFirstName().equalsIgnoreCase(person.getFirstName()) && medicalRecords.getLastName().equalsIgnoreCase(person.getLastName())) {
                return medicalRecords;
            }
        }
        return null;
    }

    private Person findPersonsStation(String station){
        Person result = new Person();
        for(FireStation fireStation : dataLoader.fireStations ){
            if(fireStation.getStation().equalsIgnoreCase(station)){
                result.getStation();
            }
        }
        return result;
    }


    @RequestMapping(value = "/firestation", method = RequestMethod.GET)
    public ResultatFireStation station(@RequestParam(name = "stationNumber", required = false) String stationNumber) {
        logger.info("Entre dans la methode firestation avec le parametre stationNumber");
        ResultatFireStation results = new ResultatFireStation();
        for (FireStation fireStation : dataLoader.fireStations) {
            String address = fireStation.getAddress();

            if (stationNumber.equalsIgnoreCase(fireStation.getStation())) {
                List<Person> persons = findPersonsByAddress(address);
                for (Person person : persons) {
                    String tmp = Utils.getBirthdate(person.getFirstName(), person.getLastName(), dataLoader.medicalRecords);

                    int age = person.getAgeFromBirthDate(tmp);
                    person.setAge(age);
                    results.addPerson(person);
                }
            }
        }
        logger.debug("Sortie de la methode avec Json");
        return results;

        }



}






