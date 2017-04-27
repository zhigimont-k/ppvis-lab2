package com.example.DialogDemo.controller;

import com.example.DialogDemo.model.Database;
import com.example.DialogDemo.view.AddRecordDialog;
import com.example.DialogDemo.view.DeleteRecordDialog;
import com.example.DialogDemo.view.FindRecordDialog;
import com.example.DialogDemo.view.MainWindow;
import com.example.DialogDemo.view.table.model.TableModel;
import com.example.DialogDemo.view.table.view.Page;
import com.example.DialogDemo.view.table.controller.PageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Karina on 13.04.2017.
 */
public class MainController {
    Database model;
    MainWindow view;
    Page tableView;
    PageController tableController;
    TableModel tableModel;

    public MainController(Database model, MainWindow view, Page tableView,
                          PageController tableController, TableModel tableModel){
        this.model = model;
        this.view = view;
        this.tableView = tableView;
        this.tableController = tableController;
        this.tableModel = tableModel;


        view.newFile.addActionListener(newFileActionListener);
        view.newFileBtn.addActionListener(newFileActionListener);
        view.exit.addActionListener(exitActionListener);
        view.exitBtn.addActionListener(exitActionListener);
        view.addRecord.addActionListener(addRecordActionListener);
        view.addRecordBtn.addActionListener(addRecordActionListener);
        view.findRecord.addActionListener(findRecordActionListener);
        view.findRecordBtn.addActionListener(findRecordActionListener);
        view.deleteRecords.addActionListener(deleteRecordActionListener);
        view.deleteRecordsBtn.addActionListener(deleteRecordActionListener);
        view.saveFile.addActionListener(saveFileActionListener);
        view.saveFileBtn.addActionListener(saveFileActionListener);
        view.openFile.addActionListener(openFileActionListener);
        view.openFileBtn.addActionListener(openFileActionListener);
        /*view.btnNextPage.addActionListener(tableController.nextPageActionListener);
        view.btnPreviousPage.addActionListener(tableController.previousPageActionListener);
        view.btnFirstPage.addActionListener(tableController.firstPageActionListener);
        view.btnLastPage.addActionListener(tableController.lastPageActionListener);*/


        //addRecordController = new AddRecordController(view, model, addRecordDialog, tableView, tableModel, tableController);
    }

    ActionListener newFileActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){for (int rowIndex = 0; rowIndex < 10; rowIndex++){
            for (int columnIndex = 0; columnIndex < 8; columnIndex++){
                tableView.table.getModel().setValueAt("", rowIndex, columnIndex);
            }
        }
            for (int index = model.recordList.size() - 1; index >=0; index--){
                model.recordList.remove(index);
            }
            view.mainFrame.add(tableView.pagingPanel);
            tableView.pagingPanel.add(tableView.scrollPanel);
            tableController.tableCreated = true;
            System.out.println("Empty table created!");
            //tableView.currentPage = 0;
            tableController.viewPage(1, tableView, model);

            if (model.recordList.size() > 10) {
                tableView.btnNextPage.setEnabled(true);
                tableView.btnLastPage.setEnabled(true);
            }
            tableView.pagingPanel.repaint();
            tableView.numberOfRecordsLabel.setText("Records in database: "+model.recordList.size());
            tableView.currentPageLabel.setText("Page: " + tableView.currentPage);
            view.mainFrame.setTitle(view.title + " - New file");
            //view.pagingPanel.repaint();

            view.mainFrame.validate();
        }
    };

    ActionListener exitActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int exitResponse = JOptionPane.showConfirmDialog(
                    view.mainFrame, "Exit without saving changes?"
            );
            switch (exitResponse){
                case JOptionPane.YES_OPTION:
                    System.exit(0);
                    break;
                case JOptionPane.NO_OPTION:
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
                case JOptionPane.CLOSED_OPTION:
                    break;
            }

        }
    };
    ActionListener addRecordActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if (!tableController.tableCreated){
                JOptionPane.showMessageDialog(new JFrame(), "Create a new table or open an existing one.");
            } else {
                AddRecordDialog addRecordDialog = new AddRecordDialog(view, tableView);
                System.out.println("AddRecordDialog created!");
                AddRecordController addRecordController = new AddRecordController(view, model, addRecordDialog,
                        tableView, tableModel, tableController);
                tableController.lastPage(tableView, model);
                tableView.numberOfRecordsLabel.setText("Records in database: "+model.recordList.size());
                tableView.pagingPanel.repaint();

                view.mainFrame.validate();
                System.out.println("AddRecordController created!");

            }
        }
    };

    ActionListener findRecordActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if (!tableController.tableCreated){
                JOptionPane.showMessageDialog(new JFrame(), "Create a new table or open an existing one.");
            } else {
                FindRecordDialog findRecordDialog = new FindRecordDialog(view);;
                System.out.println("FindRecordDialog created!");
                FindRecordController findRecordController = new FindRecordController(view, model, findRecordDialog,
                        tableView, tableController);
                System.out.println("FindRecordController created!");
            }
        }
    };

    ActionListener deleteRecordActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if (!tableController.tableCreated){
                JOptionPane.showMessageDialog(new JFrame(), "Create a new table or open an existing one.");
            } else {
                DeleteRecordDialog deleteRecordDialog = new DeleteRecordDialog(view);
                System.out.println("FindRecordDialog created!");
                DeleteRecordController deleteRecordController = new DeleteRecordController(view, model, deleteRecordDialog,
                        tableView, tableModel, tableController);
                System.out.println("FindRecordController created!");
                view.mainFrame.validate();
            }
        }
    };

    ActionListener saveFileActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if (!tableController.tableCreated){
                JOptionPane.showMessageDialog(new JFrame(), "Create a new table or open an existing one.");
            } else {
                FileSave file = new FileSave(view, model.recordList);
            }
        }
    };

    ActionListener openFileActionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            view.mainFrame.add(tableView.pagingPanel);
            tableView.pagingPanel.add(tableView.scrollPanel);
            for (int rowIndex = 0; rowIndex < 10; rowIndex++){
                for (int columnIndex = 0; columnIndex < 8; columnIndex++){
                    tableView.table.getModel().setValueAt("", rowIndex, columnIndex);
                }
            }
            for (int index = model.recordList.size() - 1; index >=0; index--){
                model.recordList.remove(index);
            }
            //view.pagingPanel.add(tableView.scrollPanel);
            tableController.tableCreated = true;
            System.out.println("Empty table created!");
            FileOpen file = new FileOpen(view, tableView, model);
            //tableView.currentPage = 0;
            tableController.viewPage(1, tableView, model);

            if (model.recordList.size() > 10) {
                tableView.btnNextPage.setEnabled(true);
                tableView.btnLastPage.setEnabled(true);
            }
            tableView.pagingPanel.repaint();
            tableView.numberOfRecordsLabel.setText("Records in database: "+model.recordList.size());
            tableView.currentPageLabel.setText("Page: "+tableView.currentPage);
            tableView.pagingPanel.repaint();

            view.mainFrame.validate();
        }
    };



}
