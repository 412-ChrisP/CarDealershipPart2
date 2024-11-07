package Yearup.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractFileManager
{
    private static final String CONTRACT_FILE_PATH = "contracts.cvs";

    public void saveContract(Contract contract)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACT_FILE_PATH, true)))
        {
            writer.write(formatContract(contract));
            writer.newLine();
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String formatContract(Contract contract)
    {
        String formattedContract = "";

        if (contract instanceof SalesContract salesContract)
        {
            formattedContract = String.format(
                    "SALE|%s|%s|%s|%d|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                    salesContract.getDate(),
                    salesContract.getCustomerName(),
                    salesContract.getCustomerEmail(),
                    salesContract.getVehicleSold().getVin(),
                    salesContract.getVehicleSold().getYear(),
                    salesContract.getVehicleSold().getMake(),
                    salesContract.getVehicleSold().getModel(),
                    salesContract.getVehicle().getVehicleType(),
                    salesContract.getVehicle().getColor(),
                    salesContract.getVehicle().getOdometer(),
                    salesContract.getVehicle().getPrice(),
                    salesContract.getSalesTax(),
                    salesContract.getRecordingFee(),
                    salesContract.getProcessingFee(),
                    salesContract.getTotalPrice(),
                    salesContract.isFinanceOption() ? "YES" : "NO",
                    salesContract.getMonthlyPayment()
            );
        } else if (contract instanceof LeaseContract leaseContract)
        {
            formattedContract = String.format(
                    "LEASE|%s|%s|%s|%d|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f|%.2f",
                    leaseContract.getDate(),
                    leaseContract.getCustomerName(),
                    leaseContract.getCustomerEmail(),
                    leaseContract.getVehicle().getVin(),
                    leaseContract.getVehicle().getYear(),
                    leaseContract.getVehicle().getMake(),
                    leaseContract.getVehicle().getModel(),
                    leaseContract.getVehicle().getVehicleType(),
                    leaseContract.getVehicle().getColor(),
                    leaseContract.getVehicle().getOdometer(),
                    leaseContract.getVehicle().getPrice(),
                    leaseContract.getExpectedEndingValue(),
                    leaseContract.getLeaseFee(),
                    leaseContract.getTotalPrice(),
                    leaseContract.getMonthlyPayment()
            );
        }
        return formattedContract;
    }
}
