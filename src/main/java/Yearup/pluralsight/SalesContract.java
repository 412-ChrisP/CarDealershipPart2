package Yearup.pluralsight;

import java.util.*;

public class SalesContract extends Contract
{
    private double salesTax = 0.05;
    private double recordingFee = 100;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold,Vehicle vehicle, boolean financeOption) {
        super(date, customerName, customerEmail, vehicleSold, vehicle);
        this.financeOption = financeOption;
    }

    public SalesContract(String customerName, String customerEmail, Vehicle vehicle, boolean financeOption) {
        super(customerName, customerEmail, vehicle);
        this.financeOption = financeOption;
    }
    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee= processingFee;
    }

    @Override
    public double getTotalPrice()
    {
        if (getVehicle().getPrice() >= 10000) {
            processingFee = 285;
        } else
        {
            processingFee = 495;
        }

        return getVehicleSold().getPrice() + salesTax + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment()
    {
        int numberOfPayments;
        double interestRate;
        if (financeOption) {
            if (getVehicle().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }

    public static SalesContract createSalesContract(Vehicle vehicle, String customerName, String customerEmail)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to finance? (yes/no): ");
        boolean financeOption = scanner.nextLine().equalsIgnoreCase("yes");

        return new SalesContract(customerName, customerEmail, vehicle, financeOption);
    }

}
