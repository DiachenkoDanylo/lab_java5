package base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.FileAppender;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    // Initialization of Log4j Logger
    public static void main(String[] args) throws IOException {

        SimpleLayout layout = new SimpleLayout();
        FileAppender appender = new FileAppender(layout, "src/main/resources/logs/main.log", false);
        logger.addAppender(appender);
        logger.setLevel(Level.DEBUG);

        RandomComplete randomComplete = new RandomComplete();

        ArrayList<Patient> list = new ArrayList<>(); // Creating arraylist
        for (int i = 0; i < 15; i++) {
            list.add(new Patient());
            // randomComplete.randomPatients(patients[i]);
        }
        logger.info("Creating an empty ArrayList <Patient>");

        ViewConsole viewConsole = new ViewConsole();
        viewConsole.responseStart();
        Scanner scanner = new Scanner(System.in);
        for (int response = Integer.parseInt(scanner.next()); response != -1; ) {
            try{
            switch (response) {
                case 1:
                    logger.info(" 1 was sent at console");
                    try {
                        if (list.get(0).getName() == null) {
                            System.out.println("Массив пустий");
                            logger.debug("The ArrayList <Patient> is empty");
                        } else {
                            viewConsole.view1(list);
                        }
                        viewConsole.responseStart();
                        response = scanner.nextInt();
                        viewConsole.responseClear();
                    } catch (IndexOutOfBoundsException e) {
                        logger.error("Index out of bounds: " + e.getMessage());
                        System.err.println("Index out of bounds exception: " + e.getMessage());
                        viewConsole.responseStart();
                        response = scanner.nextInt();
                        viewConsole.responseClear();
                    }
                    break;

                case 2:
                    logger.info(" 2 was sent at console");
                    try {
                        viewConsole.view2(list);
                        viewConsole.responseStart();
                        response = scanner.nextInt();
                        viewConsole.responseClear();
                    } catch (IndexOutOfBoundsException e) {
                        logger.error("Index out of bounds: " + e.getMessage());
                        System.err.println("Index out of bounds exception: " + e.getMessage());
                        viewConsole.responseStart();
                        response = scanner.nextInt();
                        viewConsole.responseClear();
                    }
                    break;

                case 3:
                    logger.info(" 3 was sent at console");
                    System.out.println("Введіть слово для пошуку" + "\n" + "      або введіть");
                    viewConsole.responseStart();
                    Scanner scannerString = new Scanner(System.in);
                    String searchValue = scannerString.nextLine();
                    if (Objects.equals(searchValue, " ") || Objects.equals(searchValue, "")) {
                        logger.debug("String was ' ' or '' seems empty");
                    } else {
                        try {
                            logger.info(" the string with surname was sent at console");
                            viewConsole.viewSearch(list, searchValue);
                        } catch (NullPointerException e) {
                            logger.error("NullPointerException: " + e.getMessage());
                            System.err.println("NullPointerException: " + e.getMessage());
                        }
                    }
                    viewConsole.responseStart();
                    response = scanner.nextInt();
                    break;

                case 4:
                    logger.info(" 4 was sent at console");
                    System.out.println("Введіть діапазон через Enter для пошуку" + "\n" + "   ");
                    Scanner scannerIntFrom = new Scanner(System.in);
                    System.out.println("Пошук від - ");
                    int intFrom = scannerIntFrom.nextInt();
                    if (intFrom < 0) {
                        System.out.println("Діапазон пошуку не може бути менше за 0");
                        logger.debug("The value of searching 'From' cant be < 0 " + intFrom);
                        System.out.println("Спробуйте знову");
                        response = 4;
                    }
                    Scanner scannerIntTo = new Scanner(System.in);
                    System.out.println("Пошук до - ");
                    int intTo = scannerIntTo.nextInt();
                    if (intTo < intFrom) {
                        System.out.println("Пошук 'До' не може бути меншим за 'Від'  " + intTo + "-Int to " + intFrom + "-Int From ");
                        logger.debug("The value of  'To' cant be < 'From' ");
                        System.out.println("Спробуйте знову");
                        response = 4;
                        break;
                    }
                    try {
                        viewConsole.viewSearchCard(list, intFrom, intTo);
                    } catch (IndexOutOfBoundsException e) {
                        logger.error("Index out of bounds: " + e.getMessage());
                        System.err.println("Index out of bounds exception: " + e.getMessage());
                    }

                    viewConsole.responseStart();
                    response = scanner.nextInt();
                    break;

                case 5:
                    logger.info(" 5 was sent at console");
                    String pathFile = "src/main/java/base/file2.txt";
                    logger.info(pathFile + "  was used as File to create a db");
                    if (!new File(pathFile).isFile()) {
                        logger.error("The File is not exist or  wrong data");
                        System.out.println("Нажаль вказанний файл неіснує");
                    }
                    FileReader fileReader = new FileReader(pathFile);
                    Scanner fileScann = new Scanner(fileReader);
                    logger.info("Scanner was connected to " + pathFile);
                    StringBuilder value = new StringBuilder();
                    while (fileScann.hasNextLine()) {
                        value.append(fileScann.nextLine());
                    }
                    fileScann.close();
                    logger.info("Scanning file was done");
                    ParseFile parsing = new ParseFile();

                    try {
                        parsing.parseFile(value.toString(), list);
                        logger.info("using method ParseFile to create new db from File  " + pathFile);
                    } catch (Exception e) {
                        logger.error("Exception: " + e.getMessage());
                        System.err.println("Exception: " + e.getMessage());
                    }

                    viewConsole.responseStart();
                    response = scanner.nextInt();
                    break;

                case 6:
                    logger.info(" 6 was sent at console");
                    String pathFileWrite = "src/main/java/base/file2.txt";
                    logger.info(pathFileWrite + "  was used as File to SAVE a db");
                    if (!new File(pathFileWrite).isFile()) {
                        logger.error("The File is not exist or  wrong data   " + pathFileWrite);
                        System.out.println("Неможливо зберети базу у цей файл");
                    }
                    FileWriter fileWriter = new FileWriter(pathFileWrite);
                    try {
                        fileWriter.write(list.toString());
                    } catch (IOException e) {
                        logger.error("IOException: " + e.getMessage());
                        System.err.println("IOException: " + e.getMessage());
                    }
                    fileWriter.close();
                    logger.info("End of writing a file " + pathFileWrite);
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

                case 0:
                    viewConsole.responseClear();
                    logger.info("Exit");
                    System.out.println("Вихід");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    logger.error("Wrong insert number");
                    throw new IllegalStateException("Спробуйте знову: Введіть цифру із запропонованих");
            }
            } catch (NumberFormatException e) {
                logger.error("Invalid input format: " + e.getMessage());
                System.err.println("Invalid input! Please enter a valid number.");
                viewConsole.responseStart();
                response = Integer.parseInt(scanner.next());
            } catch (InputMismatchException e) {
                logger.error("Input mismatch: " + e.getMessage());
                System.err.println("Invalid input! Please enter a valid number.");
                viewConsole.responseStart();
                response = Integer.parseInt(scanner.next()); // Clear the invalid input
            } catch (IndexOutOfBoundsException e) {
                logger.error("Index out of bounds: " + e.getMessage());
                System.err.println("Index out of bounds exception: " + e.getMessage());
                viewConsole.responseStart();
                response = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                logger.error("Exception: " + e.getMessage());
                System.err.println("Exception: " + e.getMessage());
                viewConsole.responseStart();
                response = Integer.parseInt(scanner.next());
            }

        }

    }
}
