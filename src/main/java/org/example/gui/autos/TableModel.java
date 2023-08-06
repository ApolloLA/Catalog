package org.example.gui.autos;

import org.example.Vehicle;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.lang.constant.Constable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TableModel extends AbstractTableModel {

    int columnCount = 8;
    private final List<Vehicle> cars;
    private final Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    public TableModel(List<Vehicle> cars){
        this.cars = cars;
    }


    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }
    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> Long.class;
            case 1, 2, 3, 4, 6 -> String.class;
            case 5 -> Integer.class;
            case 7 -> Boolean.class;
            default -> Object.class;
        };
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex){
        return switch (columnIndex) {
            case 0 -> "ID";
            case 1 -> "Бренд";
            case 2 -> "Модель";
            case 3 -> "Категория";
            case 4 -> "Регистрационный номер";
            case 5 -> "Год изготовления";
            case 6 -> "Тип";
            case 7 -> "Наличие прицепа";
            default -> "";
        };
//        return null;
    }

    @Override
    public int getRowCount() {
        return cars.size();
    }



    @Override
    public Constable getValueAt(int rowIndex, int columnIndex) {
        Vehicle auto = cars.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> auto.getId();
            case 1 -> auto.getMake();
            case 2 -> auto.getModel();
            case 3 -> auto.getCategory();
            case 4 -> auto.getStateNumber();
            case 5 -> auto.getYearOfManufacture();
            case 6 -> auto.getVehicleType();
            case 7 -> auto.isTrailerAvailability();
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }

}
