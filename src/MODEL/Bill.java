package MODEL;


public class Bill {

    private int billId;
    private int patientId;
    private String treatment;
    private double amount;

    public Bill() {
    }

    public Bill(int billId, int patientId, String treatment, double amount) {
        this.billId = billId;
        this.patientId = patientId;
        this.treatment = treatment;
        this.amount = amount;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}