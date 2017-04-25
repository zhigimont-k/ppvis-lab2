package com.example.DialogDemo.view.table.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Karina on 10.04.2017.
 */
public class Page {
    public String[] tableHeading = {"First name",
            "Last name", "City", "Street", "House", "Flat", "Mobile phone number", "Phone number"};
    public JTable table;
    public JScrollPane scrollPanel;
    public int currentPage;
    public int lastPage;
    public JPanel panel;
    public JButton btnLastPage;
    public JLabel numberOfRecordsLabel;

    public Page(){
        DefaultTableModel tableModel = new DefaultTableModel(10, tableHeading.length);
        tableModel.setColumnIdentifiers(tableHeading);
        table = new JTable(tableModel);
        scrollPanel = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(700, 400));
        table.setEnabled(false);
        currentPage = 1;
        lastPage = 1;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
