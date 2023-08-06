package org.example;

public class Vehicle {
    private long id;
    private String make;
    private String model;
    private String category;
    private String stateNumber;
    private String vehicleType;
    private int yearOfManufacture;
    private boolean trailerAvailability;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public boolean isTrailerAvailability() {
        return trailerAvailability;
    }

    public void setTrailerAvailability(boolean trailerAvailability) {
        this.trailerAvailability = trailerAvailability;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", category='" + category + '\'' +
                ", stateNumber='" + stateNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", trailerAvailability=" + trailerAvailability +
                '}';
    }
}
