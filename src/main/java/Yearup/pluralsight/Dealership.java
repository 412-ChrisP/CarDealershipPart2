package Yearup.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership
{
    private String name;
    private String address;
    private String phone;
    private static ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehicleByVin(int vin)
    {
        List<Vehicle> vehiclesByVinResult = new ArrayList<>();
        for (Vehicle vehicle : inventory)
        {
            if (vehicle.getVin() == vin)
            {
                vehiclesByVinResult.add(vehicle);
            }
        }
        return vehiclesByVinResult;
    }

    public List<Vehicle> getVehiclesByPrice(double min,double  max)
    {
        List<Vehicle> vehiclesByPriceResult = new ArrayList<>();
        for(Vehicle vehicle : inventory)
        {
            if(vehicle.getPrice() >= min && vehicle.getPrice() <= max)
            {
                vehiclesByPriceResult.add(vehicle);
            }
        }
        return vehiclesByPriceResult;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model)
    {
        List<Vehicle> vehiclesByMakeModelResult = new ArrayList<>();
        for(Vehicle vehicle : inventory)
        {
            if(vehicle.getModel().equals(model) && vehicle.getMake().equals(make))
            {
                vehiclesByMakeModelResult.add(vehicle);
            }
        }
        return vehiclesByMakeModelResult;
    }

    public List<Vehicle> getVehicleByYear(int min, int max)
    {
        List<Vehicle> vehiclesByYearResult = new ArrayList<>();
        for(Vehicle vehicle : inventory)
        {
            if(vehicle.getYear() >= min && vehicle.getYear() <= max)
            {
                vehiclesByYearResult.add(vehicle);
            }
        }
        return vehiclesByYearResult;
    }

    public List<Vehicle> getVehicleByColor(String color)
    {
        List<Vehicle> vehicleByColorResult = new ArrayList<>();
        for(Vehicle vehicle : inventory)
        {
            if(vehicle.getColor().equals(color))
            {
                vehicleByColorResult.add(vehicle);
            }
        }
        return vehicleByColorResult;
    }

    public List<Vehicle> getVehicleByMileage(int min, int max)
    {
        List<Vehicle> vehicleByMileageResult = new ArrayList<>();
        for(Vehicle vehicle : inventory)
        {
            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max)
            {
                vehicleByMileageResult.add(vehicle);
            }
        }
        return vehicleByMileageResult;
    }

    public List<Vehicle> getVehicleByType(String vehicleType)
    {
        List<Vehicle> vehicleByTypeResult = new ArrayList<>();
        for(Vehicle vehicle : inventory)
        {
            if(vehicle.getVehicleType().equals(vehicleType))
            {
                vehicleByTypeResult.add(vehicle);
            }
        }
        return vehicleByTypeResult;
    }

    public List<Vehicle> getAllVehicles()
    {
        return new ArrayList<>(inventory);
    }

    public void addVehicle(Vehicle vehicle)
    {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle)
    {
        inventory.remove(vehicle);
    }
}