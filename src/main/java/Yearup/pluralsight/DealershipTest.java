package Yearup.pluralsight;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DealershipTest
{
    private Dealership dealership;

    @Test
    public void getVehiclesByPrice_shouldReturnVehiclesWithinRange() {

        // Arrange
        int minPrice = 6000;
        int maxPrice = 15000;

        // Act
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);

        // Assert
        assertEquals(2, vehicles.size());
    }

    @Test
    public void getAllVehicles_shouldReturnAllVehiclesInInventory() {

        // Act
        List<Vehicle> allVehicles = dealership.getAllVehicles();

        // Assert
        assertEquals(3, allVehicles.size());
    }
}