package com.example.DialogDemo.view;

import com.example.DialogDemo.view.table.view.Page;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by student on 13.04.2017.
 */
public class FindRecordDialog {

    public JDialog dialog;
    public JTable table;
    public Page tableView;
    public DefaultTableModel tableModel;
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
    public JLabel resultLabel;
    public JPanel panelResult;
    public JScrollPane scrollPanel;
    String[] tableHeading = {"First name",
            "Last name", "City", "Street", "House", "Flat", "Mobile phone number", "Phone number"};


    public FindRecordDialog(MainWindow mainWindow){
        dialog = new JDialog(mainWindow.mainFrame, "Find records", false);

        dialog.setLayout(new FlowLayout());
        dialog.setSize(1200, 600);
        dialog.setResizable(false);


        panelAll = new JPanel();
        panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.X_AXIS));
        panelAll.setAlignmentX(Component.LEFT_ALIGNMENT);

        tableView = new Page();
        tableView.pagingPanel.add(tableView.scrollPanel);

        panelSearch = new JPanel();
        panelSearch.setLayout(new BoxLayout(panelSearch, BoxLayout.Y_AXIS));
        panelSearch.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelResult = new JPanel();
        panelResult.setLayout(new BoxLayout(panelResult, BoxLayout.Y_AXIS));
        panelResult.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelInput = new JPanel();
        panelInput.setLayout(new BoxLayout(panelInput, BoxLayout.Y_AXIS));
        panelInput.setAlignmentX(Component.CENTER_ALIGNMENT);

        radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelButton = new JPanel();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.X_AXIS));
        radioPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

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

        resultLabel = new JLabel("Search result:\n");
        panelResult.add(resultLabel);

        //tableModel = new DefaultTableModel(0, tableHeading.length);
        //tableModel.setColumnIdentifiers(tableHeading);
        //table = new JTable(tableModel);


        //scrollPanel = new JScrollPane(table);
        //table.setPreferredScrollableViewportSize(new Dimension(500, 400));
        //table.setEnabled(false);

        panelResult.add(tableView.pagingPanel);
        //panelResult.add(scrollPanel);

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
        panelAll.add(new JSeparator());
        panelAll.add(panelResult);
        dialog.add(panelAll);

        dialog.setVisible(true);
        System.out.println("FindRecordDialog created!");

    }
}
