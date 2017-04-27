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

    public JButton btnNextPage;
    public JButton btnPreviousPage;
    public JButton btnFirstPage;
    public JButton btnLastPage;
    public JLabel numberOfRecordsLabel;
    public JLabel currentPageLabel;
    public JPanel pagingBtnPanel;
    public JPanel pagingPanel;
    public DefaultTableModel tableModel;

    public Page(){
        tableModel = new DefaultTableModel(10, tableHeading.length);
        tableModel.setColumnIdentifiers(tableHeading);
        table = new JTable(tableModel);
        scrollPanel = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(700, 400));
        table.setEnabled(false);


        currentPage = 1;
        lastPage = 1;
        pagingPanel = new JPanel();
        pagingPanel.setLayout(new BoxLayout(pagingPanel, BoxLayout.Y_AXIS));
        pagingPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        pagingPanel.setAlignmentX(Component.BOTTOM_ALIGNMENT);
        //pagingPanel.setLocation(0, 200);

        pagingBtnPanel = new JPanel();
        pagingBtnPanel.setLayout(new BoxLayout(pagingBtnPanel, BoxLayout.X_AXIS));
        pagingBtnPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        pagingBtnPanel.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        numberOfRecordsLabel = new JLabel("Records in database: ");
        currentPageLabel = new JLabel("Page: ");

        btnNextPage = new JButton("Next >");
        btnNextPage.setEnabled(false);

        btnPreviousPage = new JButton ("< Prev");
        btnPreviousPage.setEnabled(false);

        btnFirstPage = new JButton("<< First");
        btnFirstPage.setEnabled(false);

        btnLastPage = new JButton(">> Last");
        btnLastPage.setEnabled(false);

        pagingBtnPanel.add(btnFirstPage);
        pagingBtnPanel.add(btnPreviousPage);
        pagingBtnPanel.add(currentPageLabel);
        pagingBtnPanel.add(btnNextPage);
        pagingBtnPanel.add(btnLastPage);

        pagingPanel.add(numberOfRecordsLabel);
        pagingPanel.add(pagingBtnPanel);
    }
}
