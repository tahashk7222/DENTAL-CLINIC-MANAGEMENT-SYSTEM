package FILES;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileHandler {

    public static void savePatient(String data) {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter("patients.txt", true)
                    );

            bw.write(data);
            bw.newLine();

            bw.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public static void saveAppointment(String data) {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter("appointments.txt", true)
                    );

            bw.write(data);
            bw.newLine();

            bw.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public static void saveBill(String data) {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter("bills.txt", true)
                    );

            bw.write(data);
            bw.newLine();

            bw.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}