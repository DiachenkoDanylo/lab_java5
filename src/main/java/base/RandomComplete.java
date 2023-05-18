package base;
import java.lang.*;
import java.util.ArrayList;

public class RandomComplete {
    String[] diseases = {"ОРВІ" ,
            "Пневмонія" ,
            "Набряк" ,
            "Черепно-мозкова травма" ,
            "Серцева недостатність"};

    String[] names = {"Петро" ,
            "Василь" ,
            "Олег" ,
            "Дмитро" ,
            "Павло" ,
            "Гасан" ,
            "Микита" ,
            "Ігор"};

    String[] surnames = {"Подоляк" ,
            "Шматко" ,
            "Гришко" ,
            "Вольдемар" ,
            "Порошонявський" ,
            "Залізняк" ,
            "Жулик"};

    String[] fathers = {"Вікторович" ,
            "Олегович" ,
            "Ганьбович" ,
            "Дмитрович" ,
            "Васильович" ,
            "Микитович" ,
            "Іванович"};

    String[] adresses1 = {"б.Шевченка" ,
            "вул.Олени Пчілки" ,
            "провулок Сагайдачного" ,
            "проспект Перемоги" ,
            "вул.Небесної Сотні" ,
            "Майдан Незалежності"};

    String[] phoneNumbers = {"095","066","075","050","099","063","076"};

    public void randomPatients(Patient patient){
        patient.setId(((int) (Math.random()*100)));
        patient.setName(names[((int)(Math.random()*6))]);
        patient.setSurname(surnames[(int)(Math.random()*6)]);
        patient.setDiagnose(diseases[(int)(Math.random()*4)]);
        patient.setPhone((phoneNumbers[(int)(Math.random()*7)])+ (int) (Math.random() * 10000000));
        if((patient.getPhone()).length() == 9 ){
            patient.setPhone(patient.getPhone()+"1");
        }
        patient.setFather(fathers[(int)(Math.random()*6)]);
        patient.setAddress(adresses1[(int)(Math.random()*5)]+"  "+ (int) (Math.random() * 100));
        patient.setId_card((int)(Math.random()*100));
    }
}
