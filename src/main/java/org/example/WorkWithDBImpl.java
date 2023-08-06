/* Класс работы с БД */
package org.example;

import java.sql.*;
import java.util.ArrayList;


public class WorkWithDBImpl implements WorkWithDB{
    private final String DB_DRIVER_CLASS="org.postgresql.Driver";
    private final String DB_URL="jdbc:postgresql://localhost:5432/catalog-db";
    private final String DB_USERNAME = "test";
    private final String DB_PASSWORD = "test";
    @Override
    public ArrayList<Vehicle> bringAllVehicles() {
        String SQL_QUERY = "SELECT * FROM Vehicle";
        ArrayList<Vehicle> autoList = new ArrayList<>();

        try {
            Class.forName(DB_DRIVER_CLASS);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SQL_QUERY);
                while (resultSet.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setId(resultSet.getLong("id"));
                    vehicle.setMake(resultSet.getString("make"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setCategory(resultSet.getString("category"));
                    vehicle.setVehicleType(resultSet.getString("vehicleType"));
                    vehicle.setStateNumber(resultSet.getString("stateNumber"));
                    vehicle.setYearOfManufacture(resultSet.getInt("yearOfManufacture"));
                    vehicle.setTrailerAvailability(resultSet.getBoolean("trailerAvailability"));
                    autoList.add(vehicle);
                }
                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return autoList;
    }

    @Override
    public ArrayList<Vehicle> searchVehicles(String model, String category) {
        String SQL_QUERY = "SELECT * FROM Vehicle WHERE model = " +model+" and category = " + category+";";
        ArrayList<Vehicle> autoList = new ArrayList<>();

        try {
            Class.forName(DB_DRIVER_CLASS);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SQL_QUERY);
                while (resultSet.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setId(resultSet.getLong("id"));
                    vehicle.setMake(resultSet.getString("make"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setCategory(resultSet.getString("category"));
                    vehicle.setVehicleType(resultSet.getString("vehicleType"));
                    vehicle.setStateNumber(resultSet.getString("stateNumber"));
                    vehicle.setYearOfManufacture(resultSet.getInt("yearOfManufacture"));
                    vehicle.setTrailerAvailability(resultSet.getBoolean("trailerAvailability"));
                    autoList.add(vehicle);
                }
                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return autoList;
    }

    @Override
    public Vehicle searchVehicles(long id) {
        String SQL_QUERY = "SELECT * FROM Vehicle WHERE id = " + id;
        Vehicle vehicle = new Vehicle();

        try {
            Class.forName(DB_DRIVER_CLASS);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SQL_QUERY);
                while (resultSet.next()) {
                    vehicle.setId(resultSet.getLong("id"));
                    vehicle.setMake(resultSet.getString("make"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setCategory(resultSet.getString("category"));
                    vehicle.setVehicleType(resultSet.getString("vehicleType"));
                    vehicle.setStateNumber(resultSet.getString("stateNumber"));
                    vehicle.setYearOfManufacture(resultSet.getInt("yearOfManufacture"));
                    vehicle.setTrailerAvailability(resultSet.getBoolean("trailerAvailability"));
                }
                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public void saveVehicle(Vehicle car) {
        String SQL_QUERY = "INSERT INTO Vehicle (make, model, category, vehicleType, stateNumber, yearOfManufacture, trailerAvailability) " +
                "VALUES ('" + car.getMake() +"', '" + car.getModel() +"', '" + car.getCategory() +"', '" + car.getVehicleType() +"', '" + car.getStateNumber() +"', '" + car.getYearOfManufacture() +"','" + car.isTrailerAvailability() +"')";
        System.out.println(SQL_QUERY);
        try {
            Class.forName(DB_DRIVER_CLASS);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

                Statement statement = connection.createStatement();
                statement.executeUpdate(SQL_QUERY);

                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateVehicle(long id, Vehicle car) {
        String SQL_QUERY = "UPDATE Vehicle SET make = '" + car.getMake() + "', model = '" + car.getModel() + "', category = '" + car.getCategory() + "', vehicleType = '" + car.getVehicleType() + "', stateNumber = '" + car.getStateNumber() + "', yearOfManufacture = '" + car.getYearOfManufacture() + "', trailerAvailability = '" + car.isTrailerAvailability() + "' WHERE id = '" + id + "';";

        try {
            Class.forName(DB_DRIVER_CLASS);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

                Statement statement = connection.createStatement();
                statement.executeUpdate(SQL_QUERY);

                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vehicle searchVehicles(String stateNumber) {
        String SQL_QUERY = "SELECT * FROM Vehicle WHERE stateNumber = '" + stateNumber + "'";
        Vehicle vehicle = new Vehicle();

        try {
            Class.forName(DB_DRIVER_CLASS);
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SQL_QUERY);
                while (resultSet.next()) {
                    vehicle.setId(resultSet.getLong("id"));
                    vehicle.setMake(resultSet.getString("make"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setCategory(resultSet.getString("category"));
                    vehicle.setVehicleType(resultSet.getString("vehicleType"));
                    vehicle.setStateNumber(resultSet.getString("stateNumber"));
                    vehicle.setYearOfManufacture(resultSet.getInt("yearOfManufacture"));
                    vehicle.setTrailerAvailability(resultSet.getBoolean("trailerAvailability"));
                }
                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }
}
