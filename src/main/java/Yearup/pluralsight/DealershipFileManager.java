package Yearup.pluralsight;

import java.io.*;

public class DealershipFileManager
{
    public Dealership getDealership(String fileName)
    {
        Dealership dealership = null;
        try
        {
            File file = new File(fileName);
            if (!file.exists())
            {
                System.out.println("The file doesn't exist. Creating new file: " + fileName);
                file.createNewFile();
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                String[] dealershipInfo = line.split("\\|");
                if(dealershipInfo.length == 3)
                {
                    String name = dealershipInfo[0];
                    String address = dealershipInfo[1];
                    String phone = dealershipInfo[2];

                    dealership = new Dealership(name,address,phone);
                }

                String[] vehicleInfo = line.split("\\|");
                if(vehicleInfo.length == 8)
                {
                    int vin = Integer.parseInt(vehicleInfo[0]);
                    int year = Integer.parseInt(vehicleInfo[1]);
                    String make = vehicleInfo[2];
                    String model = vehicleInfo[3];
                    String vehicleType = vehicleInfo[4];
                    String color = vehicleInfo[5];
                    int odometer = Integer.parseInt(vehicleInfo[6]);
                    double price = Double.parseDouble(vehicleInfo[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }
            bufferedReader.close();
        } catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership, String fileName)
    {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName)))
        {
            bufferedWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bufferedWriter.newLine();

            for(Vehicle vehicle : dealership.getAllVehicles())
            {
                bufferedWriter.write(vehicle.getVin() + "|" + vehicle.getYear() + "|"
                + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
                bufferedWriter.newLine();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error could not save: " + e.getMessage());
            e.printStackTrace();
        }
    }
}