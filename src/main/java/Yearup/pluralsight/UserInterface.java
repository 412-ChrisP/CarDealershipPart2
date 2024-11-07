package Yearup.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface
{
    private Dealership dealership;
    private ContractFileManager contractFileManager;

    private void processBySellLeaseVehicleRequest()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());
        Vehicle vehicle = (Vehicle) dealership.getVehicleByVin(vin);

        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        System.out.println("Sale or Lease? (Enter 's' or 'l'): ");
        String contractType = scanner.nextLine().toLowerCase();

        Contract contract;

        if (contractType.equals("s"))
        {
            contract = SalesContract.createSalesContract(vehicle, customerName, customerEmail);
        }
        else if (contractType.equals("l"))
        {
            if (vehicle.getYear() < 2021)
            {
                System.out.println("Vehicle life > 3 years. Choose different vehicle!");
                return;
            }
            contract = LeaseContract.createLeaseContract(vehicle, customerName, customerEmail);
        }
        else
        {
            System.out.println("Please enter 's' or 'lease'.");
            return;
        }

        contractFileManager.saveContract(contract);
        System.out.println("saved!");
    }

    public UserInterface()
    {
        display();
    }

    void display()
    {
        init();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running)
        {
            System.out.println("---------- Dealership Menu ---------");
            System.out.println("1.) List all vehicles ");
            System.out.println("2.) Add vehicle ");
            System.out.println("3.) Remove vehicle ");
            System.out.println("4.) Search by year range");
            System.out.println("5.) Search by make and model ");
            System.out.println("6.) Search by vehicle type ");
            System.out.println("7.) Search by color ");
            System.out.println("8.) Search by mileage range ");
            System.out.println("9.) Search by price range ");
            System.out.println("0.) Sell/Lease vehicle ");
            System.out.println("X.) Exit ");

            System.out.println("Please enter a selection: ");
            int userChoice = Integer.parseInt(scanner.nextLine());

            switch(userChoice)
            {
                case 1:
                    processGetAllVehiclesRequest();
                    break;
                case 2:
                    processAddVehicleRequest();
                    break;
                case 3:
                    processRemoveVehicleRequest();
                    break;
                case 4:
                    processGetByYearRequest();
                    break;
                case 5:
                    processGetByMakeModelRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetByColorRequest();
                    break;
                case 8:
                    processGetByMileageRequest();
                    break;
                case 9:
                    processGetByPriceRequest();
                    break;
                case 0:
                    processBySellLeaseVehicleRequest();
                    break;
                case 'X':
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }
        scanner.close();
    }

    private void processGetByPriceRequest()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the minimum price: ");
        double minimumPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter the Maximum price: ");
        double maximumPrice = Double.parseDouble(scanner.nextLine());

        List<Vehicle> vehiclePrice = dealership.getVehiclesByPrice(minimumPrice,maximumPrice);
        displayVehicles(vehiclePrice);
    }

    private void processGetByMakeModelRequest()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Make: ");
        String make = scanner.nextLine();
        System.out.println("Please enter the Model: ");
        String model = scanner.nextLine();

        List<Vehicle> vehicleMakeModel = dealership.getVehicleByMakeModel(make,model);
        displayVehicles(vehicleMakeModel);
    }

    private void processGetByYearRequest()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the minimum year: ");
        int minimumYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the maximum year: ");
        int maximumYear = Integer.parseInt(scanner.nextLine());

        List<Vehicle> vehicleYear = dealership.getVehicleByYear(minimumYear,maximumYear);
        displayVehicles(vehicleYear);
    }

    private void processGetByColorRequest()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the color: ");
        String color = scanner.nextLine();

        List<Vehicle> vehicleColor = dealership.getVehicleByColor(color);
        displayVehicles(vehicleColor);
    }

    private void processGetByMileageRequest()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the minimum miles: ");
        int minimumMiles = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the maximum years: ");
        int maximumMiles = Integer.parseInt(scanner.nextLine());

        List<Vehicle> vehicleMiles = dealership.getVehicleByMileage(minimumMiles, maximumMiles);
        displayVehicles(vehicleMiles);
    }

    private void processGetByVehicleTypeRequest()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the vehicle type: ");
        String type = scanner.nextLine();

        List<Vehicle> vehicleType = dealership.getVehicleByType(type);
        displayVehicles(vehicleType);
    }

    private void processGetAllVehiclesRequest()
    {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    private void processAddVehicleRequest()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the make: ");
        String make = scanner.nextLine();
        System.out.println("Please enter the model: ");
        String model = scanner.nextLine();
        System.out.println("Please enter the vehicle type: ");
        String vehicleType = scanner.nextLine();
        System.out.println("Please enter the color: ");
        String color = scanner.nextLine();
        System.out.println("Please enter the mileage: ");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle newVehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
        dealership.addVehicle(newVehicle);
        System.out.println("Vehicle has been added!");
    }

    private void processRemoveVehicleRequest()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the VIN of the vehicle to remove: ");
        int vin = Integer.parseInt(scanner.nextLine());

        Vehicle vehicleRemove = new Vehicle(vin, 0, "","","","",0,0);
        dealership.removeVehicle(vehicleRemove);
    }

    private void init()
    {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership("dealership.csv");
        contractFileManager = new ContractFileManager();
    }

    private void displayVehicles(List<Vehicle> vehicles)
    {
        for(Vehicle vehicle : vehicles)
        {
            System.out.println(vehicle);
        }
    }

    public Dealership getDealership()
    {
        return dealership;
    }
}