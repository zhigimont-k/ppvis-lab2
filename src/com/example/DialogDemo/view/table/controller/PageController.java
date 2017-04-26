package com.example.DialogDemo.view.table.controller;

import com.example.DialogDemo.model.Database;
import com.example.DialogDemo.model.StudentRecord;
import com.example.DialogDemo.view.MainWindow;
import com.example.DialogDemo.view.table.model.TableRecord;
import com.example.DialogDemo.view.table.view.Page;

import javax.swing.*;

/**
 * Created by Karina on 10.04.2017.
 */
public class PageController {
    JTable table;
    public Boolean tableCreated;

    public PageController(Page tableView){
        tableCreated = false;
        table = tableView.table;
    }

    public JTable makeEmptyTable(){
        for (int rowIndex = 0; rowIndex < 10; rowIndex++){
            for (int columnIndex = 0; columnIndex < 8; columnIndex++){
                table.getModel().setValueAt("", rowIndex, columnIndex);
            }
        }
        tableCreated = true;
        return table;
    }

    public void removeRecordFromTable(){

    }

    public TableRecord recordToTableRecord(StudentRecord studentRecord){
        return new TableRecord(studentRecord.getFirstName(), studentRecord.getLastName(),
                studentRecord.address.getCity(), studentRecord.address.getStreet(),
                Integer.toString(studentRecord.address.getHouse()), Integer.toString(studentRecord.address.getFlat()),
                studentRecord.getMobilePhoneNumber(), studentRecord.getPhoneNumber());
    }

    public void viewPage(int page, Page view, Database model){
        //JTable tablePage = new JTable();
        int rowIndex = 0;
        //int rowIndex = Database.recordList.size() - 1;
        for (int recordIndex = (page-1)*10; recordIndex < page*10; recordIndex++){
            if (recordIndex < model.recordList.size()){
                StudentRecord record = model.recordList.get(recordIndex);
                view.table.getModel().setValueAt(record.getFirstName(), rowIndex, 0);
                view.table.getModel().setValueAt(record.getLastName(), rowIndex, 1);
                view.table.getModel().setValueAt(record.address.getCity(), rowIndex, 2);
                view.table.getModel().setValueAt(record.address.getStreet(), rowIndex, 3);
                view.table.getModel().setValueAt(record.address.getHouse(), rowIndex, 4);
                view.table.getModel().setValueAt(record.address.getFlat(), rowIndex, 5);
                view.table.getModel().setValueAt(record.getMobilePhoneNumber(), rowIndex, 6);
                view.table.getModel().setValueAt(record.getPhoneNumber(), rowIndex, 7);
                rowIndex++;
            } else
            {
                view.table.getModel().setValueAt("", rowIndex, 0);
                view.table.getModel().setValueAt("", rowIndex, 1);
                view.table.getModel().setValueAt("", rowIndex, 2);
                view.table.getModel().setValueAt("", rowIndex, 3);
                view.table.getModel().setValueAt("", rowIndex, 4);
                view.table.getModel().setValueAt("", rowIndex, 5);
                view.table.getModel().setValueAt("", rowIndex, 6);
                view.table.getModel().setValueAt("", rowIndex, 7);
                rowIndex++;
            }
        }



    }
    public void nextPage(MainWindow view, Page tableView, Database model){
        viewPage(tableView.currentPage+1, tableView, model);
        view.previousPage.setEnabled(true);
        view.firstPage.setEnabled(true);
    }

    public void previousPage(MainWindow view, Page tableView, Database model){
        viewPage(tableView.currentPage-1, tableView, model);
        view.nextPage.setEnabled(true);
        view.lastPage.setEnabled(true);
    }

    public void firstPage(MainWindow view, Page tableView, Database model){
        viewPage(1, tableView, model);
        view.nextPage.setEnabled(true);
        view.lastPage.setEnabled(true);
        view.previousPage.setEnabled(false);
    }

    public void lastPage(MainWindow view, Page tableView, Database model){
        viewPage(tableView.lastPage, tableView, model);
        view.nextPage.setEnabled(false);
        view.lastPage.setEnabled(false);
        view.previousPage.setEnabled(true);
        view.firstPage.setEnabled(true);
    }

}
