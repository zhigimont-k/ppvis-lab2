package com.example.DialogDemo.view;

import com.example.DialogDemo.view.table.view.Page;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Karina on 11.04.2017.
 */
public class DeleteRecordDialog {

    public JDialog dialog;
    public JButton btnFind;
    public JButton btnCancel;
    public ButtonGroup radioGroup;
    public JRadioButton byLastNameAndPhoneNumber;
    public JRadioButton byAddressAndPhoneNumber;
    public JRadioButton byLastNameAndNumber;
    public JTextField lastNameField;
    public JTextField phoneNumberField;
    public JTextField cityField;
    public JTextField streetField;
    public JTextField houseField;
    public JTextField flatField;
    public JPanel panelInput;
    public JPanel radioPanel;
    public JPanel panelAll;
    public JPanel panelSearch;
    public JPanel panelButton;
    public JLabel lastNameLabel;
    public JLabel cityLabel;
    public JLabel streetLabel;
    public JLabel houseLabel;
    public JLabel flatLabel;
    public JLabel phoneNumberLabel;

    public DeleteRecordDialog(MainWindow mainWindow){
        dialog = new JDialog(mainWindow.mainFrame, "Find and delete records", false);

        dialog.setLayout(new FlowLayout());
        dialog.setSize(300, 400);
        dialog.setResizable(false);


        panelAll = new JPanel();
        panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.X_AXIS));
        panelAll.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelSearch = new JPanel();
        panelSearch.setLayout(new BoxLayout(panelSearch, BoxLayout.Y_AXIS));
        panelSearch.setAlignmentX(Component.LEFT_ALIGNMENT);


        panelInput = new JPanel();
        panelInput.setLayout(new BoxLayout(panelInput, BoxLayout.Y_AXIS));
        panelInput.setAlignmentX(Component.CENTER_ALIGNMENT);

        radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelButton = new JPanel();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.X_AXIS));

        btnFind = new JButton("Find");
        btnCancel = new JButton("Cancel");
        byLastNameAndNumber = new JRadioButton("By last name and number");
        byAddressAndPhoneNumber = new JRadioButton("By address and phone number");
        byLastNameAndPhoneNumber = new JRadioButton("By last name and phone number");
        lastNameField = new JTextField(15);
        phoneNumberField = new JTextField(15);
        cityField = new JTextField(15);
        streetField = new JTextField(15);
        houseField = new JTextField(15);
        flatField = new JTextField(15);
        lastNameLabel = new JLabel("Last name: ");
        cityLabel = new JLabel("City: ");
        streetLabel = new JLabel("Street: ");
        houseLabel = new JLabel("House: ");
        flatLabel = new JLabel("Flat: ");
        phoneNumberLabel = new JLabel("Phone number: ");



        radioGroup = new ButtonGroup();
        radioGroup.add(byAddressAndPhoneNumber);
        radioGroup.add(byLastNameAndNumber);
        radioGroup.add(byLastNameAndPhoneNumber);


        panelInput.add(lastNameLabel);
        panelInput.add(lastNameField);
        panelInput.add(cityLabel);
        panelInput.add(cityField);
        panelInput.add(streetLabel);
        panelInput.add(streetField);
        panelInput.add(houseLabel);
        panelInput.add(houseField);
        panelInput.add(flatLabel);
        panelInput.add(flatField);
        panelInput.add(phoneNumberLabel);
        panelInput.add(phoneNumberField);

        radioPanel.add(byLastNameAndPhoneNumber);
        radioPanel.add(byLastNameAndNumber);
        radioPanel.add(byAddressAndPhoneNumber);


        panelButton.add(btnFind);
        panelButton.add(btnCancel);

        for (Component cp : panelInput.getComponents() ){
            cp.setEnabled(false);
        }

        panelSearch.add(radioPanel);
        panelSearch.add(panelInput);
        panelSearch.add(panelButton);
        panelAll.add(panelSearch);
        dialog.add(panelAll);

        dialog.setVisible(true);
        System.out.println("DeleteRecordDialog created!");
    }

}
