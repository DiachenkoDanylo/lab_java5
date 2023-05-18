package base;

import java.util.ArrayList;

public class ParseFile {
    public void parseFile(String data, ArrayList<Patient> patients) {

        String data2 = data.replaceAll("Patient", "");
        data2 = data2.replaceAll("\\[", "");

        data2 = data2.substring(1);
        String[] patientsData2 = data2.split("\\{");
        for(int i =0; i< patientsData2.length;i++){
            String patientData = patientsData2[i];

            int id = Integer.parseInt(patientData.substring(patientData.indexOf("id=") + 3, patientData.indexOf(",")));
            patients.get(i).setId(id);
            patientData = patientData.substring(patientData.indexOf(",")+1);

            String name = patientData.substring(patientData.indexOf("name='") + 6, patientData.indexOf("',"));
            patients.get(i).setName(name);
            patientData = patientData.substring(patientData.indexOf(",")+1);

            String surname = patientData.substring(patientData.indexOf("surname='") + 9, patientData.indexOf("',"));
            patients.get(i).setSurname(surname);
            patientData = patientData.substring(patientData.indexOf(",")+1);


            String father = patientData.substring(patientData.indexOf("father='") + 8, patientData.indexOf("',"));
            patients.get(i).setFather(father);
            patientData = patientData.substring(patientData.indexOf(",")+1);

            String address = patientData.substring(patientData.indexOf("address='") + 9, patientData.indexOf("',"));
            patients.get(i).setAddress(address);
            patientData = patientData.substring(patientData.indexOf(",")+1);

            String diagnose = patientData.substring(patientData.indexOf("diagnose='") + 10, patientData.indexOf("',"));
            patients.get(i).setDiagnose(diagnose);
            patientData = patientData.substring(patientData.indexOf(",")+1);

            String phone = patientData.substring(patientData.indexOf("phone=") + 6, patientData.indexOf(","));
            patients.get(i).setPhone(phone);
            patientData = patientData.substring(patientData.indexOf(",")+1);
            //System.out.println(patientData);
            int id_card = Integer.parseInt(patientData.substring(patientData.indexOf("id_card=") + 8,patientData.length()-3));
            patients.get(i).setId_card(id_card);
        }




        /*
            String patientData = patientsData2[i].substring(prevInd,lastInd);


            int id = Integer.parseInt(patientData.substring(patientData.indexOf("id=") + 3, patientData.indexOf(",")));
            String name = patientData.substring(patientData.indexOf("name='") + 6, patientData.indexOf("',"));
            String surname = patientData.substring(patientData.indexOf("surname='") + 9, patientData.indexOf("',"));
            String father = patientData.substring(patientData.indexOf("father='") + 8, patientData.indexOf("',"));
            String address = patientData.substring(patientData.indexOf("father='") + 8, patientData.indexOf("',"));
            String diagnose = patientData.substring(patientData.indexOf("diagnose='") + 10, patientData.indexOf("',"));
            String phone = patientData.substring(patientData.indexOf("phone=") + 6, patientData.indexOf(","));
            int id_card =Integer.parseInt(patientData.substring(patientData.indexOf("id_card=") + 8));



            patients[i].setId(Integer.parseInt(patientData.substring(patientData.indexOf("id=") + 3, patientData.indexOf(","))));

            patients[i].setName( patientData.substring(patientData.indexOf("name='") + 6, patientData.indexOf("',")));
            patients[i].setSurname(patientData.substring(patientData.indexOf("surname='") + 9, patientData.indexOf("',")));

            patients[i].setFather(patientData.substring(patientData.indexOf("father='") + 8, patientData.indexOf("',")));

            patients[i].setAddress(patientData.substring(patientData.indexOf("father='") + 8, patientData.indexOf("',")));

            patients[i].setDiagnose(patientData.substring(patientData.indexOf("diagnose='") + 10, patientData.indexOf("',")));

            patients[i].setPhone(patientData.substring(patientData.indexOf("phone=") + 6, patientData.indexOf(",")));

            patients[i].setId_card(Integer.parseInt(patientData.substring(patientData.indexOf("id_card=") + 8)));
            */
                /*
                String test = data.replaceAll("id=|name=|surname=|father=|address=|diagnose=|phone=|id_card","");
                String[] patientDataValue = test.split("'|,|\n");
                for(int k = 0; patientDataValue.length > k;k++) {
                    System.out.println(k +"    "+ patientDataValue[k]);


                i++;
                prevInd= data2.indexOf("{");
                //System.out.println(prevInd);
                lastInd= data2.indexOf("}");
                */



                /*patientDataValue[0] = patientData.substring(patientData.indexOf("id="), patientData.indexOf(","));
                patients[k].setId(Integer.parseInt(patientData.substring(patientData.indexOf("id="), patientData.indexOf(","))));

                patients[k].setId(Integer.parseInt(patientData.substring(patientData.indexOf("id="), patientData.indexOf(","))));
                patients[k].setId(Integer.parseInt(patientData.substring(patientData.indexOf("id="), patientData.indexOf(","))));
                patients[k].setId(Integer.parseInt(patientData.substring(patientData.indexOf("id="), patientData.indexOf(","))));
                patients[k].setId(Integer.parseInt(patientData.substring(patientData.indexOf("id="), patientData.indexOf(","))));
                patients[k].setId(Integer.parseInt(patientData.substring(patientData.indexOf("id="), patientData.indexOf(","))));
                patients[k].setId(Integer.parseInt(patientData.substring(patientData.indexOf("id="), patientData.indexOf(","))));

                 */



    }
}
