/* Интерфейс описывающий методы для работы с БД*/
package org.example;

import java.util.ArrayList;

public interface WorkWithDB {
    ArrayList<Vehicle> bringAllVehicles();

    ArrayList<Vehicle> searchVehicles(String model, String category);

    Vehicle searchVehicles(long id);

    void saveVehicle(Vehicle car);

    void updateVehicle(long id, Vehicle car);

    Vehicle searchVehicles(String stateNumber);
}
