package Yearup.pluralsight;

public class Main
{
    public static void main(String[] args)
    {
        UserInterface userInterface = new UserInterface();
        userInterface.display();

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(userInterface.getDealership(), "dealership.csv");
    }
}