package base;

import java.util.ArrayList;

public class ViewConsole {

    public void responseClear(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    public void responseStart(){
        System.out.println("\nВведіть 1 для відображення поточної бази пацієнтів" +
                "\nВведіть 2 для відображення лише прізвищ та діагнозів" +
                "\nВведіть 3 для пошуку за словом" +
                "\nВведіть 4 для пошуку в діапазоні Id карти" +
                "\nВведіть 5 для створення бази з файлу file2.txt" +
                "\nВведіть 6 для збереження поточної бази у файл file2.txt"+
                "\nВведіть 7 для створення нової бази із випадковими данними"+
                "\nВведіть 0 для виходу");
    }

    public void view1(ArrayList<Patient> patients){
        String leftAlignFormat = "| %-4s | %-10s | %-15s | %-15s | %-29s | %-25s| %-14s | %-7d |%n";

        System.out.format("+------+------------+-----------------+-----------------+-------------------------------+-------------------" +
                "-------+----------------+---------+%n");
        System.out.format("|  Id  |    Name    |     Surname     |     Father      |             Address           |        Diagnose " +
                "         |  Phone number  | Id_Card |%n");
        System.out.format("+------+------------+-----------------+-----------------+-------------------------------+-------------------" +
                "-------+----------------+---------+%n");
        for (int i = 0; i < patients.size(); i++) {
            outputForTable(patients, leftAlignFormat, i);
        }
    }

    public void view2(ArrayList<Patient> patients){
        String leftAlignFormat = "| %-15s | %-24s |%n";

        System.out.format("+-----------------+-------------------" +
                "-------+%n");
        System.out.format("|     Surname     |        Diagnose " +
                "         |%n");
        System.out.format("+-----------------+-------------------" +
                "-------+%n");
        for (int i = 0; i < patients.size(); i++) {
            System.out.format(leftAlignFormat, patients.get(i).getSurname(), patients.get(i).getDiagnose());
            System.out.format("+-----------------+-------------------" +
                    "-------+%n");
        }
    }

    public void viewSearch(ArrayList<Patient> patients, String searchValue){
        String leftAlignFormat = "| %-4s | %-10s | %-15s | %-15s | %-29s | %-25s| %-14s | %-7d |%n";

        System.out.format("+------+------------+-----------------+-----------------+-------------------------------+-------------------" +
                "-------+----------------+---------+%n");
        System.out.format("|  Id  |    Name    |     Surname     |     Father      |             Address           |        Diagnose " +
                "         |  Phone number  | Id_Card |%n");
        System.out.format("+------+------------+-----------------+-----------------+-------------------------------+-------------------" +
                "-------+----------------+---------+%n");
        for (int i = 0; i < patients.size(); i++) {
            if(patients.get(i).toString().indexOf(searchValue) != -1){
                outputForTable(patients, leftAlignFormat, i);
            }

        }
    }

    private void outputForTable(ArrayList<Patient> patients, String leftAlignFormat, int i) {
        System.out.format(leftAlignFormat, patients.get(i).getId(), patients.get(i).getName(), patients.get(i).getSurname(), patients.get(i).getFather(),
                patients.get(i).getAddress(), patients.get(i).getDiagnose(), patients.get(i).getPhone(), patients.get(i).getId_card()
        );
        System.out.format("+------+------------+-----------------+-----------------+-------------------------------+-------------------" +
                "-------+----------------+---------+%n");
    }

    public void viewSearchCard(ArrayList<Patient> patients, int intFrom, int intTo) {

        String leftAlignFormat = "| %-4s | %-10s | %-15s | %-15s | %-29s | %-25s| %-14s | %-7d |%n";

        System.out.format("+------+------------+-----------------+-----------------+-------------------------------+-------------------" +
                "-------+----------------+---------+%n");
        System.out.format("|  Id  |    Name    |     Surname     |     Father      |             Address           |        Diagnose " +
                "         |  Phone number  | Id_Card |%n");
        System.out.format("+------+------------+-----------------+-----------------+-------------------------------+-------------------" +
                "-------+----------------+---------+%n");
        for (int i = 0; i < patients.size(); i++) {
            if((patients.get(i).getId_card() >= intFrom) && (patients.get(i).getId_card() <= intTo)){
                outputForTable(patients, leftAlignFormat, i);
            }

        }

    }
}
