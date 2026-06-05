package MODEL;

public class Dentist extends Person {

    private String specialization;
    private int experience;

    public Dentist(String name,
                   String phone,
                   String specialization,
                   int experience) {

        super(name, phone);

        this.specialization = specialization;
        this.experience = experience;
    }


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public void displayInfo() {

        System.out.println("Dentist Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Specialization: " + specialization);
        System.out.println("Experience: " + experience + " years");
    }
}