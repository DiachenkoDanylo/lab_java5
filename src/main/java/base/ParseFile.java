package base;

import java.util.ArrayList;

public class ParseFile {
    public void parseFile(String data, ArrayList<Patient> patients) {
        try {
            String data2 = data.replaceAll("Patient", "");
            data2 = data2.replaceAll("\\[", "");

            data2 = data2.substring(1);
            String[] patientsData2 = data2.split("\\{");
            for (int i = 0; i < patientsData2.length; i++) {
                try {
                    String patientData = patientsData2[i];

                    int id = Integer.parseInt(patientData.substring(patientData.indexOf("id=") + 3, patientData.indexOf(",")));
                    patients.get(i).setId(id);
                    patientData = patientData.substring(patientData.indexOf(",") + 1);

                    String name = patientData.substring(patientData.indexOf("name='") + 6, patientData.indexOf("',"));
                    patients.get(i).setName(name);
                    patientData = patientData.substring(patientData.indexOf(",") + 1);

                    String surname = patientData.substring(patientData.indexOf("surname='") + 9, patientData.indexOf("',"));
                    patients.get(i).setSurname(surname);
                    patientData = patientData.substring(patientData.indexOf(",") + 1);


                    String father = patientData.substring(patientData.indexOf("father='") + 8, patientData.indexOf("',"));
                    patients.get(i).setFather(father);
                    patientData = patientData.substring(patientData.indexOf(",") + 1);

                    String address = patientData.substring(patientData.indexOf("address='") + 9, patientData.indexOf("',"));
                    patients.get(i).setAddress(address);
                    patientData = patientData.substring(patientData.indexOf(",") + 1);

                    String diagnose = patientData.substring(patientData.indexOf("diagnose='") + 10, patientData.indexOf("',"));
                    patients.get(i).setDiagnose(diagnose);
                    patientData = patientData.substring(patientData.indexOf(",") + 1);

                    String phone = patientData.substring(patientData.indexOf("phone=") + 6, patientData.indexOf(","));
                    patients.get(i).setPhone(phone);
                    patientData = patientData.substring(patientData.indexOf(",") + 1);

                    int id_card = Integer.parseInt(patientData.substring(patientData.indexOf("id_card=") + 8, patientData.length() - 3));
                    patients.get(i).setId_card(id_card);
                } catch (Exception e) {
                    System.err.println("Error parsing patient data: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error parsing file data: " + e.getMessage());
        }
    }
}
