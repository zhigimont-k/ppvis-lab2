package com.example.DialogDemo;

import com.example.DialogDemo.controller.MainController;
import com.example.DialogDemo.model.Database;
import com.example.DialogDemo.view.MainWindow;
import com.example.DialogDemo.view.table.controller.PageController;
import com.example.DialogDemo.view.table.view.Page;

import javax.swing.*;

/**
 * Created by student on 14.04.2017.
 */
public class DialogDemo {
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                try {

                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                }
                catch (UnsupportedLookAndFeelException e) {}
                catch (ClassNotFoundException e) {}
                catch (InstantiationException e) {}
                catch (IllegalAccessException e) {}
                Database model = new Database();
                Page tableView = new Page();
                PageController tableController = new PageController(tableView, model);
                MainWindow view = new MainWindow(tableView, tableController);
                MainController mainController = new MainController(model, view, tableView, tableController);

            }
        });
    }
}
