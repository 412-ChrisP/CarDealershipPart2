package Yearup.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest
{
    private Vehicle vehicle;

    @Test
    public void getVin_shouldReturnVehicleVin()
    {
        vehicle = new Vehicle(65000657, 2006, "Lexus", "is250", "Sedan", "Red", 145000, 8000.00);

        // Arrange
        int expectedVin = 65000657;

        // Act
        int actualVin = vehicle.getVin();

        // Assert
        assertEquals(expectedVin, actualVin);
    }

    @Test
    public void getPrice_shouldReturnVehiclePrice()
    {
        vehicle = new Vehicle(101, 2006, "Lexus", "is250", "Sedan", "Red", 145000, 8000.00);

        // Arrange
        double expectedPrice = 8000.00;

        // Act
        double actualPrice = vehicle.getPrice();

        // Assert
        assertEquals(expectedPrice, actualPrice);
    }
}