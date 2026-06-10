package MODEL;
public class Patient extends Person {
    private int patientId;
    private int age;
    private String gender;
    private String disease;
    public Patient() {
        super("", "");
    }
    public Patient(String name,
                   int age,
                   String gender,
                   String phone,
                   String disease) {

        super(name, phone);

        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public void displayInfo() {

        System.out.println("Patient Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Disease: " + disease);
    }
}