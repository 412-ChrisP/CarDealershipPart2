package Yearup.pluralsight;

public class LeaseContract extends Contract
{
    private double endingValue;
    private double leaseFee;
    private double monthlyPayment;
    private double expectedEndingValue;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicleSold, vehicle);
    }

    public LeaseContract(String customerName, String customerEmail, Vehicle vehicle) {
        super(customerName, customerEmail, vehicle);
    }

    public static LeaseContract createLeaseContract(Vehicle vehicle, String customerName, String customerEmail) {
        return new LeaseContract(customerName, customerEmail, vehicle);
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public double getTotalPrice() {
        return (getVehicle().getPrice() - expectedEndingValue) + leaseFee;
    }

    @Override
    public double getMonthlyPayment()
    {
        int numberOfPayments = 36;
        double interestRate = 4.0 / 1200;
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }
}
