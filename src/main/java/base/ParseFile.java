package base;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;

public class ParseFile {
    public void fromFileText(String data, ArrayList<Patient> patients) {
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

    public void toJsonFile(ArrayList<Patient> patients) throws IOException {
        JSONArray patientsJson = new JSONArray();
        for (int i = 0; i < patients.size(); i++) {
            JSONObject patient = new JSONObject();
            patient.put("id", patients.get(i).getId());
            patient.put("name", patients.get(i).getName());
            patient.put("surname", patients.get(i).getSurname());
            patient.put("father", patients.get(i).getFather());
            patient.put("address", patients.get(i).getAddress());
            patient.put("diagnose", patients.get(i).getDiagnose());
            patient.put("phone", patients.get(i).getPhone());
            patient.put("id_card", patients.get(i).getId_card());
            patientsJson.put(patient);
        }
        String path = "src/main/java/base/file222.json";
        System.out.println(patientsJson.toString());
        FileWriter fileWrite = new FileWriter(path);
            //We can write any JSONArray or JSONObject instance to the file
            System.out.println(patientsJson);
            fileWrite.write(String.valueOf(patientsJson));
            fileWrite.flush();
            fileWrite.close();



    }
    /*public void fromJsonFile(ArrayList<Patient> patients) throws FileNotFoundException {
        Object o = new JSONParser().parse(new FileReader("file222.json"));

        JSONObject j = (JSONObject) o;

        String Name = (String) j.get("id");

        String College = (String ) j.get("Name");
        */


}
