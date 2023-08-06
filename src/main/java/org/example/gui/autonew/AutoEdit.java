package org.example.gui.autonew;

import org.example.BusinessLogicImpl;
import org.example.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Objects;

public class AutoEdit extends JFrame {

    BusinessLogicImpl service = new BusinessLogicImpl();

    private JTextField textFieldBrand;
    private JTextField textFieldModel;
    private JTextField textFieldCategory;
    private JTextField textFieldRegistrationNumber;
    private JTextField textFieldManufacturingYear;
    private JButton buttonSave;
    private JButton buttonClose;
    private JCheckBox checkBoxCarTrailer;
    private JComboBox<String> comboBoxType;
    private JPanel EditPanel;

    private Vehicle auto;

    public AutoEdit() {

        setContentPane(EditPanel);
        setTitle("New Auto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 200, 400, 270);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setVisible(true);

        comboBoxType.addItem("Легковая");
        comboBoxType.addItem("Грузовая");
        comboBoxType.addItem("Фура");

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auto.setMake(textFieldBrand.getText());
                auto.setModel(textFieldModel.getText());
                auto.setCategory(textFieldCategory.getText());
                auto.setStateNumber(textFieldRegistrationNumber.getText());
                auto.setYearOfManufacture(Integer.parseInt(textFieldManufacturingYear.getText()));
                auto.setVehicleType(Objects.requireNonNull(comboBoxType.getSelectedItem()).toString());
                auto.setTrailerAvailability(checkBoxCarTrailer.isSelected());
                if (auto.getId() == 0) {
                    service.saveVehicle(auto);
                } else {
                    service.updateVehicle(auto.getId(), auto);
                }
                setVisible(false);
            }
        });

        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
//                AutoNew.super.dispose();
            }
        });

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
//                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
//                System.out.println("windowClosing");
            }

            @Override
            public void windowClosed(WindowEvent e) {
//                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
//                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
//                System.out.println("windowDeiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                if (auto.getId() != 0) {
                    textFieldBrand.setText(auto.getMake());
                    textFieldBrand.setVisible(true);
                    textFieldModel.setText(auto.getModel());
                    textFieldCategory.setText(auto.getCategory());
                    textFieldRegistrationNumber.setText(auto.getStateNumber());
                    textFieldManufacturingYear.setText(String.valueOf(auto.getYearOfManufacture()));
                    comboBoxType.setSelectedItem(auto.getVehicleType());
                    checkBoxCarTrailer.setSelected(auto.isTrailerAvailability());
                }
//                System.out.println("windowActivated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
//                System.out.println("windowDeactivated");
            }
        });
    }

    public void setAuto(Vehicle auto) {
        this.auto = auto;
    }
}
