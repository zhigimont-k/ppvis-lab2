package com.example.DialogDemo.view.table.controller;

import com.example.DialogDemo.model.Database;
import com.example.DialogDemo.model.StudentRecord;
import com.example.DialogDemo.view.MainWindow;
import com.example.DialogDemo.view.table.model.TableRecord;
import com.example.DialogDemo.view.table.view.Page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Karina on 10.04.2017.
 */
public class PageController {
    //JTable table;
    public Boolean tableCreated;
    public Database model;
    public Page tableView;

    public PageController(Page tableView, Database model){
        tableCreated = false;
        this.tableView = tableView;
        //table = tableView.table;
        this.model = model;

        tableView.btnNextPage.addActionListener(nextPageActionListener);
        tableView.btnPreviousPage.addActionListener(previousPageActionListener);
        tableView.btnFirstPage.addActionListener(firstPageActionListener);
        tableView.btnLastPage.addActionListener(lastPageActionListener);
    }

    public JTable makeEmptyTable(){
        for (int rowIndex = 0; rowIndex < 10; rowIndex++){
            for (int columnIndex = 0; columnIndex < 8; columnIndex++){
                tableView.table.getModel().setValueAt("", rowIndex, columnIndex);
            }
        }
        tableCreated = true;
        return tableView.table;
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

        if (model.recordList.size() % 10 == 0 && model.recordList.size() != 0){
            view.lastPage = model.recordList.size() / 10;
        } else {
            view.lastPage = model.recordList.size() / 10 + 1;
        }

        if (model.recordList.size() > 10) {
            view.btnNextPage.setEnabled(true);
            view.btnLastPage.setEnabled(true);
        } else {
            view.btnFirstPage.setEnabled(false);
            view.btnPreviousPage.setEnabled(false);
            view.btnNextPage.setEnabled(false);
            view.btnLastPage.setEnabled(false);
        }

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
            }
            rowIndex++;
        }




    }
    public void nextPage(Page tableView, Database model){
        viewPage(tableView.currentPage+1, tableView, model);
        ++tableView.currentPage;
        tableView.btnPreviousPage.setEnabled(true);
        tableView.btnFirstPage.setEnabled(true);

        if (tableView.currentPage == tableView.lastPage){
            tableView.btnNextPage.setEnabled(false);
            tableView.btnLastPage.setEnabled(false);
        }
        tableView.currentPageLabel.setText("Page: "+tableView.currentPage);
    }

    public void previousPage(Page tableView, Database model){
        viewPage(tableView.currentPage-1, tableView, model);
        --tableView.currentPage;
        tableView.btnNextPage.setEnabled(true);
        tableView.btnLastPage.setEnabled(true);

        if (tableView.currentPage == 1){
            tableView.btnPreviousPage.setEnabled(false);
            tableView.btnFirstPage.setEnabled(false);
        }

        tableView.currentPageLabel.setText("Page: "+tableView.currentPage);
    }

    public void firstPage(Page tableView, Database model){
        viewPage(1, tableView, model);
        tableView.currentPage = 1;
        tableView.btnNextPage.setEnabled(true);
        tableView.btnLastPage.setEnabled(true);
        tableView.btnPreviousPage.setEnabled(false);
        tableView.btnFirstPage.setEnabled(false);


        tableView.currentPageLabel.setText("Page: "+tableView.currentPage);
    }

    public void lastPage(Page tableView, Database model){
        viewPage(tableView.lastPage, tableView, model);

        tableView.currentPage = tableView.lastPage;
        tableView.btnNextPage.setEnabled(false);
        tableView.btnLastPage.setEnabled(false);
        tableView.btnPreviousPage.setEnabled(true);
        tableView.btnFirstPage.setEnabled(true);
        tableView.currentPageLabel.setText("Page: "+tableView.currentPage);
    }

    public ActionListener nextPageActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            nextPage(tableView, model);
            tableView.pagingPanel.repaint();
        }
    };

    public ActionListener previousPageActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            previousPage(tableView, model);
            tableView.pagingPanel.repaint();
        }
    };

    public ActionListener firstPageActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            firstPage(tableView, model);
            tableView.pagingPanel.repaint();
        }
    };

    public ActionListener lastPageActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            lastPage(tableView, model);
            tableView.pagingPanel.repaint();
        }
    };

}
