package base;

public class Patient {
        //Ідентифікаційний номер, Прізвище, Ім’я, По батькові, Адреса, Телефон, Номер медичної картки, Діагноз.
        //Конструктор, Методи доступу, Метод toString()
    private String name, surname, father, address, diagnose, phone;
    private int id, id_card;


    public void setAddress(String address) {
        this.address = address;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public int getId_card() {
        return id_card;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public String getFather() {
        return father;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Patient{ \n" +
                " id=" + id +
                ",\n name='" + name + '\'' +
                ",\n surname='" + surname + '\'' +
                ",\n father='" + father + '\'' +
                ",\n address='" + address + '\'' +
                ",\n diagnose='" + diagnose + '\'' +
                ",\n phone=" + phone +
                ",\n id_card=" + id_card +
                '}';
    }
}
