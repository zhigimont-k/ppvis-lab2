package com.example.DialogDemo.controller;

import com.example.DialogDemo.model.Database;
import com.example.DialogDemo.view.AddRecordDialog;
import com.example.DialogDemo.view.MainWindow;
import com.example.DialogDemo.view.table.controller.PageController;
import com.example.DialogDemo.view.table.model.TableModel;
import com.example.DialogDemo.view.table.view.Page;
import com.example.DialogDemo.model.StudentRecord;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Karina on 13.04.2017.
 */
public class AddRecordController {
    Database model;
    MainWindow mainWindow;
    AddRecordDialog addRecordDialog;
    Page tableView;
    TableModel tableModel;
    PageController tableController;

    AddRecordController(MainWindow mainWindow, Database model, AddRecordDialog addRecordDialog,
                        Page tableView, TableModel tableModel, PageController tableController){
        this.mainWindow = mainWindow;
        this.model = model;
        this.addRecordDialog = addRecordDialog;
        this.tableView = tableView;
        this.tableModel = tableModel;
        this.tableController = tableController;

        addRecordDialog.btnAdd.addActionListener(addRecordActionListener);
        addRecordDialog.btnCancel.addActionListener(cancelDialogActionListener);
    }

    ActionListener cancelDialogActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            addRecordDialog.dialog.setVisible(false);
            System.out.println("fuck this shit");
        }
    };

    ActionListener addRecordActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = (String) addRecordDialog.table.getModel().getValueAt(0, 0);
            String lastName = (String) addRecordDialog.table.getModel().getValueAt(0, 1);
            String city = (String) addRecordDialog.table.getModel().getValueAt(0, 2);
            String street = (String) addRecordDialog.table.getModel().getValueAt(0, 3);
            int house = Integer.parseInt(addRecordDialog.table.getModel().getValueAt(0, 4).toString());
            int flat = Integer.parseInt(addRecordDialog.table.getModel().getValueAt(0, 5).toString());
            String mobilePhoneNumber =(String) addRecordDialog.table.getModel().getValueAt(0, 6);
            String phoneNumber =(String) addRecordDialog.table.getModel().getValueAt(0, 7);

            StudentRecord addedRecord = new StudentRecord(firstName, lastName, city, street, house, flat,
                    mobilePhoneNumber, phoneNumber);

            Database.addRecordToDatabase(addedRecord, model.recordList);
            //tableController.addRecordToTable(addedRecord, tableModel, tableView);

            if (model.recordList.size() % 10 == 1){
                tableView.lastPage++;
                mainWindow.nextPage.setEnabled(true);
                mainWindow.lastPage.setEnabled(true);
                mainWindow.mainFrame.validate();}

            tableController.viewPage(tableView.currentPage, tableView, model);

            mainWindow.numberOfRecordsLabel.setText("Records in database: "+model.recordList.size());
            mainWindow.mainFrame.validate();
            System.out.println("Added a record.");
            addRecordDialog.dialog.setVisible(false);
        }
    };


}
