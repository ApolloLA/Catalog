package org.example.gui.autos;

import org.example.BusinessLogicImpl;
import org.example.Vehicle;
import org.example.gui.autonew.AutoEdit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Autos extends JFrame {

    BusinessLogicImpl service = new BusinessLogicImpl();

    AutoEdit autoEdit = new AutoEdit();

    private JTable tableAutos;
    private JTextField textFieldBrand;
    private JTextField textFieldModel;
    private JTextField textFieldCategory;
    private JTextField textFieldRegistrationNumber;
    private JTextField textFieldManufacturingYear;
    private JComboBox<String> comboBoxType;
    private JButton buttonFind;
    private JButton buttonAdd;
    private JButton buttonEdit;
    private JButton buttonFilter;
    private JButton buttonClearFilter;
    private JPanel AutosPanel;
    private JPanel FilterPanel;
    private JPanel NavPanel;
    private JButton buttonUpdate;

    public Autos() {

        setContentPane(AutosPanel);
        setTitle("Auto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1400, 700);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setVisible(true);

        autoEdit.setVisible(false);

        comboBoxType.addItem("");
        comboBoxType.addItem("Легковая");
        comboBoxType.addItem("Грузовая");
        comboBoxType.addItem("Фура");

        TableModel tableModel = new TableModel(service.bringAllVehicles());
        tableAutos.setModel(tableModel);

        buttonFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autoEdit.setAuto(new Vehicle());
                autoEdit.setVisible(true);
            }
        });
        buttonEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableAutos.getSelectedRow();
                if (selectedRow < 1) return;
                long id = Long.parseLong(tableModel.getValueAt(selectedRow, 0).toString());
                if (id > 0) {
                    autoEdit.setAuto(service.searchVehicles(id));
                    autoEdit.setVisible(true);
                }
            }
        });

        buttonFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonClearFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {
                tableAutos.setModel(new TableModel(service.bringAllVehicles()));
                tableModel.fireTableDataChanged();
            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

}
