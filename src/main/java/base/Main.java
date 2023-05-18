package base;
import jdk.nashorn.internal.runtime.Debug;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.FileAppender;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);
    // inithialization Log4j Logger
    public static void main(String[] args) throws IOException {

        SimpleLayout layout = new SimpleLayout();
        FileAppender appender = new FileAppender(layout,"your filename",false);
        logger.addAppender(appender);
        logger.setLevel(Level.DEBUG);

        RandomComplete randomComplete = new RandomComplete();


        //Пацієнт:
        //Ідентифікаційний номер, Прізвище, Ім’я, По батькові, Адреса, Телефон, Номер медичної картки, Діагноз.
        //Конструктор, Методи доступу, Метод toString()
/*
        Patient[] patients = new Patient[15];
        for(int i =0; i<15; i++){
            patients[i] = new Patient();
            randomComplete.randomPatients(patients[i]);
        }*/

        //ArrayList<Patient> list=new ArrayList<Patient>();//Creating arraylist
        //Patient[] patients = new Patient[15];
        ArrayList<Patient> list= new ArrayList<>();//Creating arraylist
        for(int i =0; i<15; i++){
            list.add(new Patient());
         //   randomComplete.randomPatients(patients[i]);
        }
        logger.info("Creating an empty ArrayList <Patient>");

        /*Patient patient_2 = new Patient(
                11,
                "Sanya",
                "Poltava",
                "vanyachevski",
                "Autostation",
                22911,
                190,
                "Lug Cancer");
        Patient patient_3 = new Patient(
                7,
                "Viktor",
                "Poltava",
                "olegovich",
                " school",
                11911,
                117,
                "Lug Cancer");
        Patient patient_4 = new Patient(
                29,
                "Petro",
                "Poroshenko",
                "Aligatorovich",
                "school",
                85911,
                129,
                "Lug Cancer");*/


        ViewConsole viewConsole = new ViewConsole();
        viewConsole.responseStart();
        Scanner scanner = new Scanner(System.in);
        for(int response = scanner.nextInt(); response != 0;) {
            switch (response) {
                case 1:
                    logger.info(" 1 was sent at console");
                    if(list.get(0)==null){
                        System.out.println("Массив пустий");
                        logger.debug("The ArrayList <Patient> is empty");
                    }else {
                        viewConsole.view1(list);
                    }
                    viewConsole.responseStart();
                    response = scanner.nextInt();
                    viewConsole.responseClear();
                    break;

                case 2:
                    logger.info(" 2 was sent at console");
                    viewConsole.view2(list);
                    viewConsole.responseStart();
                    response = scanner.nextInt();
                    viewConsole.responseClear();
                    break;

                case 3:
                    logger.info(" 3 was sent at console");
                    System.out.println("Введіть слово для пошуку" +
                            "\n" +
                            "      або введіть");
                    viewConsole.responseStart();
                    Scanner scannerString = new Scanner(System.in);
                    String searchValue = scannerString.nextLine();
                    if(Objects.equals(searchValue, " ") || Objects.equals(searchValue, "")){
                        logger.debug("String was ' ' or '' seems empty");
                    }else{
                        logger.info(" the string with surname was sent at console");
                        viewConsole.viewSearch(list, searchValue);
                    }
                    viewConsole.responseStart();
                    response = scanner.nextInt();
                    break;

                case 4:
                    logger.info(" 4 was sent at console");
                    System.out.println("Введіть діапазон через Enter для пошуку" +
                            "\n" +
                            "   ");
                    Scanner scannerIntFrom = new Scanner(System.in);
                    System.out.println("Пошук від - ");
                    int intFrom = scannerIntFrom.nextInt();
                    if(intFrom <0){
                        System.out.println("Діапазон пошуку не може бути менше за 0");
                        logger.debug("The value of searching 'From' cant be < 0 "+intFrom );
                        System.out.println("Спробуйте знову");
                        response = 4;
                    }
                    Scanner scannerIntTo = new Scanner(System.in);
                    System.out.println("Пошук до - ");
                    int intTo = scannerIntTo.nextInt();
                    if(intTo < intFrom){
                        System.out.println("Пошук 'До' не може бути меншим за 'Від'  "+ intTo+"-Int to "+intFrom+"-Int From ");
                        logger.debug("The value of  'To' cant be < 'From' " );
                        System.out.println("Спробуйте знову");
                        response = 4;
                        break;
                    }
                    viewConsole.viewSearchCard(list, intFrom, intTo);

                    viewConsole.responseStart();
                    response = scanner.nextInt();
                    break;

                case 5:
                    logger.info(" 5 was sent at console");
                    String pathFile ="src/main/java/base/file2.txt";
                    logger.info(pathFile+"  was used as File to create a db");
                    if(!new File(pathFile).isFile()){
                        logger.error("The File is not exist or  wrong data");
                        System.out.println("Нажаль вказанний файл неіснує");
                    }
                    FileReader fileReader = new FileReader(pathFile);
                    Scanner fileScann = new Scanner(fileReader);
                    logger.info("Scanner was connected to "+pathFile);
                    StringBuilder value = new StringBuilder();
                    while(fileScann.hasNextLine()){
                        value.append(fileScann.nextLine());
                    }
                    fileScann.close();
                    logger.info("Scanning file was done");
                    ParseFile parsing = new ParseFile();
                    //System.out.println(value.toString());
                    parsing.parseFile(value.toString(), list);
                    logger.info("using method ParseFile to create new db from File  "+pathFile);
                    //System.out.println(Arrays.toString(patients));
                    viewConsole.responseStart();
                    response = scanner.nextInt();
                    break;

                case 6:
                    logger.info(" 6 was sent at console");
                    String pathFileWrite ="src/main/java/base/file2.txt";
                    logger.info(pathFileWrite+"  was used as File to SAVE a db");
                    if(!new File(pathFileWrite).isFile()){
                        logger.error("The File is not exist or  wrong data   "+pathFileWrite);
                        System.out.println("Неможливо зберети базу у цей файл");
                    }
                    FileWriter fileWriter = new FileWriter(pathFileWrite);
                    fileWriter.write(list.toString());
                    fileWriter.close();
                    logger.info("End of writing a file "+ pathFileWrite);
                    viewConsole.responseStart();
                    response = scanner.nextInt();
                    break;

                case 7:
                    logger.info(" 7 was sent at console");

                    for (Patient patient : list) {
                        randomComplete.randomPatients(patient);
                    }
                    logger.info("The using db was filled with random data from RandomComplete");
                    viewConsole.responseStart();
                    response = scanner.nextInt();
                    break;

                default:
                    logger.error("Wrong insert number");
                    throw new IllegalStateException("Спробуйте знову: Введіть цифру із запропонованих");
            }
        }
        viewConsole.responseClear();
        logger.info(" Exit");
        System.out.println("Вихід");




	// write your code here
    }
}
