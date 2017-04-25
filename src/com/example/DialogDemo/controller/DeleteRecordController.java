package com.example.DialogDemo.controller;

/**
 * Created by Karina on 16.04.2017.
 */

import com.example.DialogDemo.model.Database;
import com.example.DialogDemo.view.DeleteRecordDialog;
import com.example.DialogDemo.view.MainWindow;
import com.example.DialogDemo.view.table.controller.PageController;
import com.example.DialogDemo.view.table.model.TableModel;
import com.example.DialogDemo.view.table.view.Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteRecordController extends FindRecordController{
    Database model;
    MainWindow mainWindow;
    DeleteRecordDialog deleteRecordDialog;
    Page tableView;
    TableModel tableModel;
    PageController tableController;

    public DeleteRecordController(MainWindow mainWindow, Database model, DeleteRecordDialog deleteRecordDialog,
                                  Page tableView, TableModel tableModel, PageController tableController){
        this.mainWindow = mainWindow;
        this.model = model;
        this.deleteRecordDialog = deleteRecordDialog;
        this.tableView = tableView;
        this.tableModel = tableModel;
        this.tableController = tableController;

        deleteRecordDialog.byAddressAndPhoneNumber.addActionListener(byAddressAndPhoneNumberActionListener);
        deleteRecordDialog.btnCancel.addActionListener(cancelDialogActionListener);
        deleteRecordDialog.byLastNameAndPhoneNumber.addActionListener(byLastNameAndPhoneNumberActionListener);
        deleteRecordDialog.byLastNameAndNumber.addActionListener(byLastNameAndNumberActionListener);

        deleteRecordDialog.btnFind.addActionListener(deleteRecordActionListener);
    }

    ActionListener cancelDialogActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteRecordController.this.deleteRecordDialog.dialog.setVisible(false);
        }
    };

    ActionListener byLastNameAndPhoneNumberActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Component cp : deleteRecordDialog.panelInput.getComponents() ){
                cp.setEnabled(false);
            }
            deleteRecordDialog.lastNameField.setEnabled(true);
            deleteRecordDialog.lastNameLabel.setEnabled(true);
            deleteRecordDialog.phoneNumberField.setEnabled(true);
            deleteRecordDialog.phoneNumberLabel.setEnabled(true);
        }
    };

    ActionListener byLastNameAndNumberActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Component cp : deleteRecordDialog.panelInput.getComponents() ){
                cp.setEnabled(false);
            }
            deleteRecordDialog.lastNameField.setEnabled(true);
            deleteRecordDialog.lastNameLabel.setEnabled(true);
            deleteRecordDialog.phoneNumberField.setEnabled(true);
            deleteRecordDialog.phoneNumberLabel.setEnabled(true);
        }
    };

    ActionListener byAddressAndPhoneNumberActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Component cp : deleteRecordDialog.panelInput.getComponents() ){
                cp.setEnabled(false);
            }

            deleteRecordDialog.cityField.setEnabled(true);
            deleteRecordDialog.cityLabel.setEnabled(true);
            deleteRecordDialog.houseField.setEnabled(true);
            deleteRecordDialog.houseLabel.setEnabled(true);
            deleteRecordDialog.streetField.setEnabled(true);
            deleteRecordDialog.streetLabel.setEnabled(true);
            deleteRecordDialog.flatField.setEnabled(true);
            deleteRecordDialog.flatLabel.setEnabled(true);
            deleteRecordDialog.phoneNumberField.setEnabled(true);
            deleteRecordDialog.phoneNumberLabel.setEnabled(true);

        }
    };

    ActionListener deleteRecordActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for( int index = deleteRecordDialog.tableModel.getRowCount() - 1; index >= 0; index-- )
            {
                deleteRecordDialog.tableModel.removeRow(index);
            }
            foundRecordsNumber = 0;
            if (deleteRecordDialog.byLastNameAndPhoneNumber.isSelected()){
                if (deleteRecordDialog.lastNameField.getText().equals("") && deleteRecordDialog.phoneNumberField.getText().equals("")){
                    JOptionPane.showMessageDialog(new JFrame(), "Please fill in all necessary fields.");
                    return;
                }
                for (int recordIndex = 0; recordIndex < model.recordList.size(); recordIndex++){
                    if (deleteRecordDialog.lastNameField.getText().equals
                            (model.recordList.get(recordIndex).getLastName()) ||
                            deleteRecordDialog.phoneNumberField.getText().equals
                                    (model.recordList.get(recordIndex).getPhoneNumber())){
                        deleteRecordDialog.tableModel.addRow(new Object[]
                                {"","","","","","","",""});
                        addRecordToTable(model.recordList.get(recordIndex),
                                deleteRecordDialog.table, foundRecordsNumber);
                        tableController.viewPage(1, tableView, model);
                        model.recordList.remove(recordIndex);
                        recordIndex--;
                        if (model.recordList.size() % 10 == 0){
                            tableView.lastPage--;
                        }
                        tableController.viewPage(1, tableView, model);
                        tableView.numberOfRecordsLabel.setText("Records in database: "+model.recordList.size());
                        tableView.numberOfRecordsLabel.repaint();
                        mainWindow.mainFrame.validate();
                        foundRecordsNumber++;
                    }
                }
            }

            if (deleteRecordDialog.byLastNameAndNumber.isSelected()){
                if (deleteRecordDialog.lastNameField.getText().equals("") || deleteRecordDialog.phoneNumberField.getText().equals("")){
                    JOptionPane.showMessageDialog(new JFrame(), "Please fill in fields.");
                    return;
                }
                for (int recordIndex = 0; recordIndex < model.recordList.size(); recordIndex++){
                    if (deleteRecordDialog.lastNameField.getText().equals
                            (model.recordList.get(recordIndex).getLastName()) ||
                            model.recordList.get(recordIndex).getPhoneNumber().contains(deleteRecordDialog.phoneNumberField.getText()) ||
                            model.recordList.get(recordIndex).getMobilePhoneNumber().contains(deleteRecordDialog.phoneNumberField.getText())){
                        deleteRecordDialog.tableModel.addRow(new Object[]
                                {"","","","","","","",""});
                        addRecordToTable(model.recordList.get(recordIndex),
                                deleteRecordDialog.table, foundRecordsNumber);

                        tableController.viewPage(1, tableView, model);
                        model.recordList.remove(recordIndex);
                        recordIndex--;
                        JOptionPane.showMessageDialog(new JFrame(), model.recordList.size());
                        if (model.recordList.size() % 10 == 0){
                            tableView.lastPage--;
                        }
                        tableController.viewPage(1, tableView, model);
                        tableView.numberOfRecordsLabel.setText("Records in database: "+model.recordList.size());
                        tableView.numberOfRecordsLabel.repaint();
                        mainWindow.mainFrame.validate();
                        foundRecordsNumber++;
                    }
                }
            }

            if (deleteRecordDialog.byAddressAndPhoneNumber.isSelected()){
                if (deleteRecordDialog.cityField.getText().equals("") &&
                        deleteRecordDialog.streetField.getText().equals("") &&
                        deleteRecordDialog.houseField.getText().equals("") &&
                        deleteRecordDialog.flatField.getText().equals("") &&
                        deleteRecordDialog.phoneNumberField.getText().equals("")){
                    JOptionPane.showMessageDialog(new JFrame(), "Please fill in all necessary fields.");
                    return;
                }
                for (int recordIndex = 0; recordIndex < model.recordList.size(); recordIndex++){
                    if (deleteRecordDialog.cityField.getText().equals(model.recordList.get(recordIndex).address.getCity()) ||
                            deleteRecordDialog.streetField.getText().equals(model.recordList.get(recordIndex).address.getStreet()) ||
                            deleteRecordDialog.houseField.getText().equals(model.recordList.get(recordIndex).address.getHouse()+"") ||
                            deleteRecordDialog.flatField.getText().equals(model.recordList.get(recordIndex).address.getFlat()+"") ||
                            deleteRecordDialog.phoneNumberField.getText().equals
                                    (model.recordList.get(recordIndex).getPhoneNumber())){
                        deleteRecordDialog.tableModel.addRow(new Object[]
                                {"","","","","","","",""});
                        addRecordToTable(model.recordList.get(recordIndex),
                                deleteRecordDialog.table, foundRecordsNumber);
                        tableController.viewPage(1, tableView, model);
                        model.recordList.remove(recordIndex);
                        recordIndex--;
                        if (model.recordList.size() % 10 == 0){
                            tableView.lastPage--;
                        }
                        //tableController.viewPage(1, tableView, model);
                        //tableView.numberOfRecordsLabel.setText("Records in database: "+model.recordList.size());
                        //tableView.numberOfRecordsLabel.repaint();
                        mainWindow.mainFrame.validate();
                        foundRecordsNumber++;
                    }
                }

            }
            if (foundRecordsNumber == 0){
                JOptionPane.showMessageDialog(new JFrame(), "No records found.");
                return;
            }
            JOptionPane.showMessageDialog(new JFrame(), "Deleted records from database: "+foundRecordsNumber);
        }
    };

}
