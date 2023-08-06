package org.example;

import java.util.ArrayList;

public interface BusinessLogic {
    ArrayList<Vehicle> bringAllVehicles();

    ArrayList<Vehicle> searchVehicles(String model, String category);

    Vehicle searchVehicles(long id);

    void saveVehicle(Vehicle car);

    void updateVehicle(long id, Vehicle car);
}
