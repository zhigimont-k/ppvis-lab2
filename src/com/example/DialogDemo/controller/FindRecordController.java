package com.example.DialogDemo.controller;

import com.example.DialogDemo.model.Database;
import com.example.DialogDemo.view.FindRecordDialog;
import com.example.DialogDemo.view.MainWindow;
import com.example.DialogDemo.view.table.controller.PageController;
import com.example.DialogDemo.view.table.view.Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Karina on 16.04.2017.
 */
public class FindRecordController {
    Database model;
    Database searchModel;
    MainWindow mainWindow;
    FindRecordDialog findRecordDialog;
    Page tableView;
    PageController tableController;
    int foundRecordsNumber;

    FindRecordController(){}

    FindRecordController(MainWindow mainWindow, Database model, FindRecordDialog findRecordDialog){
        this.mainWindow = mainWindow;
        this.model = model;
        this.findRecordDialog = findRecordDialog;
        this.tableView = findRecordDialog.tableView;
        searchModel = new Database();
        this.tableController = new PageController(tableView, searchModel);
        foundRecordsNumber = 0;

        findRecordDialog.byAddressAndPhoneNumber.addActionListener(byAddressAndPhoneNumberActionListener);
        findRecordDialog.btnCancel.addActionListener(cancelDialogActionListener);
        findRecordDialog.byLastNameAndPhoneNumber.addActionListener(byFirstNameAndPhoneNumberActionListener);
        findRecordDialog.byLastNameAndNumber.addActionListener(byFirstNameAndNumberActionListener);

        findRecordDialog.btnFind.addActionListener(findRecordActionListener);
    }

    ActionListener cancelDialogActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            findRecordDialog.dialog.setVisible(false);
        }
    };

    ActionListener byFirstNameAndPhoneNumberActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Component cp : findRecordDialog.panelInput.getComponents() ){
                cp.setEnabled(false);
            }
            findRecordDialog.lastNameField.setEnabled(true);
            findRecordDialog.lastNameLabel.setEnabled(true);
            findRecordDialog.phoneNumberField.setEnabled(true);
            findRecordDialog.phoneNumberLabel.setEnabled(true);
        }
    };

    ActionListener byFirstNameAndNumberActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Component cp : findRecordDialog.panelInput.getComponents() ){
                cp.setEnabled(false);
            }
            findRecordDialog.lastNameField.setEnabled(true);
            findRecordDialog.lastNameLabel.setEnabled(true);
            findRecordDialog.phoneNumberField.setEnabled(true);
            findRecordDialog.phoneNumberLabel.setEnabled(true);
        }
    };

    ActionListener byAddressAndPhoneNumberActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Component cp : findRecordDialog.panelInput.getComponents() ){
                cp.setEnabled(false);
            }

            findRecordDialog.cityField.setEnabled(true);
            findRecordDialog.cityLabel.setEnabled(true);
            findRecordDialog.houseField.setEnabled(true);
            findRecordDialog.houseLabel.setEnabled(true);
            findRecordDialog.streetField.setEnabled(true);
            findRecordDialog.streetLabel.setEnabled(true);
            findRecordDialog.flatField.setEnabled(true);
            findRecordDialog.flatLabel.setEnabled(true);
            findRecordDialog.phoneNumberField.setEnabled(true);
            findRecordDialog.phoneNumberLabel.setEnabled(true);

        }
    };

    ActionListener findRecordActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int rowIndex = 0; rowIndex < tableView.recordsPerPage; rowIndex++){
                for (int columnIndex = 0; columnIndex < 8; columnIndex++){
                    tableView.table.getModel().setValueAt("", rowIndex, columnIndex);
                }
            }
            for (int index = searchModel.recordList.size() - 1; index >=0; index--){
                searchModel.recordList.remove(index);
            }
            foundRecordsNumber = 0;
            if (findRecordDialog.byLastNameAndPhoneNumber.isSelected()){
                if (findRecordDialog.lastNameField.getText().equals("") &&
                        findRecordDialog.phoneNumberField.getText().equals("")){
                    JOptionPane.showMessageDialog(new JFrame(), "Please fill in fields.");
                    return;
                }
                for (int recordIndex = 0; recordIndex < model.recordList.size(); recordIndex++){
                    if (findRecordDialog.lastNameField.getText().equals
                            (model.recordList.get(recordIndex).getLastName()) ||
                            findRecordDialog.phoneNumberField.getText().equals
                                    (model.recordList.get(recordIndex).getPhoneNumber())){
                            searchModel.addRecordToDatabase(model.recordList.get(recordIndex),
                                    searchModel.recordList);
                                foundRecordsNumber++;
                    }
                }
            }

            if (findRecordDialog.byLastNameAndNumber.isSelected()){
                if (findRecordDialog.lastNameField.getText().equals("") &&
                        findRecordDialog.phoneNumberField.getText().equals("")){
                    JOptionPane.showMessageDialog(new JFrame(), "Please fill in fields.");
                    return;
                }
                for (int recordIndex = 0; recordIndex < model.recordList.size(); recordIndex++){
                    if (findRecordDialog.lastNameField.getText().equals
                            (model.recordList.get(recordIndex).getLastName()) ||
                            (!findRecordDialog.phoneNumberField.getText().equals("") &&
                                    (model.recordList.get(recordIndex).getPhoneNumber().contains
                                            (findRecordDialog.phoneNumberField.getText()) ||
                                            model.recordList.get(recordIndex).getMobilePhoneNumber().contains
                                                    (findRecordDialog.phoneNumberField.getText())))){

                        searchModel.addRecordToDatabase(model.recordList.get(recordIndex),
                                searchModel.recordList);
                        foundRecordsNumber++;
                    }
                }
            }

            if (findRecordDialog.byAddressAndPhoneNumber.isSelected()){
                if (findRecordDialog.cityField.getText().equals("") &&
                        findRecordDialog.streetField.getText().equals("") &&
                        findRecordDialog.houseField.getText().equals("") &&
                        findRecordDialog.flatField.getText().equals("") &&
                        findRecordDialog.phoneNumberField.getText().equals("")){
                    JOptionPane.showMessageDialog(new JFrame(), "Please fill in fields.");
                    return;
                }
                for (int recordIndex = 0; recordIndex < model.recordList.size(); recordIndex++){
                    if (findRecordDialog.cityField.getText().equals
                            (model.recordList.get(recordIndex).address.getCity()) ||
                            findRecordDialog.streetField.getText().equals
                                    (model.recordList.get(recordIndex).address.getStreet()) ||
                            findRecordDialog.houseField.getText().equals
                                    (model.recordList.get(recordIndex).address.getHouse()+"") ||
                            findRecordDialog.flatField.getText().equals
                                    (model.recordList.get(recordIndex).address.getFlat()+"") ||
                            findRecordDialog.phoneNumberField.getText().equals
                                    (model.recordList.get(recordIndex).getPhoneNumber())){

                        searchModel.addRecordToDatabase(model.recordList.get(recordIndex),
                                searchModel.recordList);
                        foundRecordsNumber++;
                    }
                }

            }

                if (foundRecordsNumber == 0){
                JOptionPane.showMessageDialog(new JFrame(), "No records found.");
                return;
            }

            tableController.firstPage(tableView, searchModel);
            tableView.numberOfRecordsLabel.setText("Records in database: " + searchModel.recordList.size());
            tableView.currentPageLabel.setText("Page: "+tableView.currentPage+" of "+tableView.lastPage);
            tableView.pagingPanel.repaint();
            tableView.pagingPanel.validate();
        }
    };

}
