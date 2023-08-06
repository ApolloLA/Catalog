package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class BusinessLogicImpl extends AbstractBusinessLogic{
    @Override
    public ArrayList<Vehicle> bringAllVehicles() {
        return super.getWorkWithDBImpl().bringAllVehicles();
    }

    @Override
    public ArrayList<Vehicle> searchVehicles(String model, String category) {
        return super.getWorkWithDBImpl().searchVehicles(model, category);
    }

    @Override
    public Vehicle searchVehicles(long id) {
        return super.getWorkWithDBImpl().searchVehicles(id);
    }

    @Override
    public void saveVehicle(Vehicle car) {
        Vehicle vehicle = super.getWorkWithDBImpl().searchVehicles(car.getStateNumber());
        if (vehicle.getId()==0)
            super.getWorkWithDBImpl().saveVehicle(car);
        else
            System.out.println("Такой номер уже присутствует " + car.getStateNumber());
    }

    @Override
    public void updateVehicle(long id, Vehicle car) {

        Vehicle vehicle = super.getWorkWithDBImpl().searchVehicles(car.getStateNumber());
        if (Objects.equals(car.getStateNumber(), vehicle.getStateNumber()))
            super.getWorkWithDBImpl().updateVehicle(id, car);
        else
            System.out.println("Такой номер уже присутствует " + car.getStateNumber());
    }
}
