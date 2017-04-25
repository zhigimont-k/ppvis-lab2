//package com.example.DialogDemo;
package com.example.DialogDemo.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.DialogDemo.view.table.view.Page;


/**
 * Created by student on 31.03.2017.
 */
public class AddRecordDialog {
    public JDialog dialog;
    public JTable table;
    DefaultTableModel tableModel;
    public JButton btnAdd;
    public JButton btnCancel;

    public AddRecordDialog(MainWindow mainWindow, Page tableView){
        dialog = new JDialog(mainWindow.mainFrame, "Add a record", false);

        dialog.setLayout(new FlowLayout());
        dialog.setSize(800, 100);
        dialog.setResizable(false);

        tableModel = new DefaultTableModel(1, tableView.tableHeading.length);
        tableModel.setColumnIdentifiers(tableView.tableHeading);
        table = new JTable(tableModel);
        JScrollPane scrollPanel = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(600, 16));
        table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

        btnAdd = new JButton("Add");
        btnCancel = new JButton("Cancel");


        dialog.add(scrollPanel);
        dialog.add(btnAdd);
        dialog.add(btnCancel);
        //dialog.add(panelAll);

        dialog.setVisible(true);
    }


}
