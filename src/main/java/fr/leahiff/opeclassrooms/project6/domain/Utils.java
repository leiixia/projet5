package fr.leahiff.opeclassrooms.project6.domain;


import java.util.List;

public class Utils {

    public static String getBirthdate(String firstName, String lastName, List<MedicalRecord> medicalRecords) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (firstName.equalsIgnoreCase(medicalRecord.getFirstName()) && lastName.equalsIgnoreCase(medicalRecord.getLastName())) {
                return medicalRecord.getBirthdate();
            }
        }
        return null;
    }


    public static MedicalRecord getUsefulMedicalInformation(MedicalRecord mr) {
        if (mr == null) {
            return null;
        } else {
            MedicalRecord tmp = new MedicalRecord();
            if (mr.getMedications() != null && mr.getMedications().size() > 0) {
                tmp.setMedications(mr.getMedications());
            }

            if (mr.getAllergies() != null && mr.getAllergies().size() > 0) {
                tmp.setAllergies(mr.getAllergies());
            }
            if (tmp.getAllergies() != null || tmp.getMedications() != null) {
                return tmp;
            } else {
                return null;
            }
        }

    }
}

