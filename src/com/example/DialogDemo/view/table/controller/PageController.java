package com.example.DialogDemo.view.table.controller;

import com.example.DialogDemo.model.Database;
import com.example.DialogDemo.model.StudentRecord;
import com.example.DialogDemo.view.table.view.Page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Karina on 10.04.2017.
 */
public class PageController {
    public Boolean tableCreated;
    public Database model;
    public Page tableView;

    public PageController(Page tableView, Database model){
        tableCreated = false;
        this.tableView = tableView;
        this.model = model;

        tableView.btnNextPage.addActionListener(nextPageActionListener);
        tableView.btnPreviousPage.addActionListener(previousPageActionListener);
        tableView.btnFirstPage.addActionListener(firstPageActionListener);
        tableView.btnLastPage.addActionListener(lastPageActionListener);
        tableView.recordsPerPageInput.addActionListener(setNumberOfRecordsOnPage);
    }

    public void viewPage(int page, Page view, Database model){
        int rowIndex = 0;

        if (model.recordList.size() % tableView.recordsPerPage == 0 && model.recordList.size() != 0){
            view.lastPage = model.recordList.size() / tableView.recordsPerPage;
        } else {
            view.lastPage = model.recordList.size() / tableView.recordsPerPage + 1;
        }

        if (model.recordList.size() > tableView.recordsPerPage) {
            view.btnNextPage.setEnabled(true);
            view.btnLastPage.setEnabled(true);
        } else {
            view.btnFirstPage.setEnabled(false);
            view.btnPreviousPage.setEnabled(false);
            view.btnNextPage.setEnabled(false);
            view.btnLastPage.setEnabled(false);
        }

        for (int recordIndex = (page-1)*tableView.recordsPerPage; recordIndex < page*tableView.recordsPerPage;
             recordIndex++){
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
        tableView.currentPageLabel.setText("Page: "+tableView.currentPage+" of "+tableView.lastPage);
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

        tableView.currentPageLabel.setText("Page: "+tableView.currentPage+" of "+tableView.lastPage);
    }

    public void firstPage(Page tableView, Database model){
        viewPage(1, tableView, model);
        tableView.currentPage = 1;
        if (tableView.lastPage > 1){
            tableView.btnNextPage.setEnabled(true);
            tableView.btnLastPage.setEnabled(true);
        }
        tableView.btnPreviousPage.setEnabled(false);
        tableView.btnFirstPage.setEnabled(false);

        tableView.currentPageLabel.setText("Page: "+tableView.currentPage+" of "+tableView.lastPage);
    }

    public void lastPage(Page tableView, Database model){
        viewPage(tableView.lastPage, tableView, model);

        tableView.currentPage = tableView.lastPage;
        tableView.btnNextPage.setEnabled(false);
        tableView.btnLastPage.setEnabled(false);
        tableView.btnPreviousPage.setEnabled(true);
        tableView.btnFirstPage.setEnabled(true);
        tableView.currentPageLabel.setText("Page: "+tableView.currentPage+" of "+tableView.lastPage);
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

    public ActionListener setNumberOfRecordsOnPage = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            for (int rowIndex = 0; rowIndex < tableView.recordsPerPage; rowIndex++){
                for (int columnIndex = 0; columnIndex < 8; columnIndex++){
                    tableView.table.getModel().setValueAt("", rowIndex, columnIndex);
                }
            }
            tableView.recordsPerPage = Integer.parseInt(tableView.recordsPerPageInput.getText());
            if (tableView.recordsPerPage <= 0){
                JOptionPane.showMessageDialog(new JFrame(), "Please input number more than 0.");
                tableView.recordsPerPage = 10;
                tableView.recordsPerPageInput.setText(tableView.recordsPerPage+"");
                return;
            }
            tableView.tableModel.setRowCount(tableView.recordsPerPage);
            firstPage(tableView, model);
            tableView.pagingPanel.repaint();
        }
    };

}
