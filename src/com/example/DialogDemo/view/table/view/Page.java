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
    public int recordsPerPage;
    public JButton btnNextPage;
    public JButton btnPreviousPage;
    public JButton btnFirstPage;
    public JButton btnLastPage;
    public JLabel numberOfRecordsLabel;
    public JLabel currentPageLabel;
    public JPanel pagingBtnPanel;
    public JPanel pagingPanel;
    public DefaultTableModel tableModel;
    public JLabel recordsPerPageLabel;
    public JTextField recordsPerPageInput;
    public JPanel recordsPerPagePanel;

    public Page(){
        recordsPerPage = 10;
        tableModel = new DefaultTableModel(recordsPerPage, tableHeading.length);
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
        pagingPanel.setAlignmentX(Component.TOP_ALIGNMENT);

        recordsPerPagePanel = new JPanel();
        recordsPerPagePanel.setLayout(new BoxLayout(recordsPerPagePanel, BoxLayout.X_AXIS));
        recordsPerPagePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        pagingBtnPanel = new JPanel();
        pagingBtnPanel.setLayout(new BoxLayout(pagingBtnPanel, BoxLayout.X_AXIS));
        pagingBtnPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        pagingBtnPanel.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        numberOfRecordsLabel = new JLabel("Records in database: ");
        currentPageLabel = new JLabel("Page: 1 of "+lastPage);
        recordsPerPageInput = new JTextField("10");
        recordsPerPageInput.setPreferredSize(new Dimension(24, 24));
        recordsPerPageInput.setMaximumSize(new Dimension(24, 24));
        recordsPerPageLabel = new JLabel(" records per page");
        recordsPerPagePanel.add(recordsPerPageInput);
        recordsPerPagePanel.add(recordsPerPageLabel);

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

        pagingPanel.add(recordsPerPagePanel);
        pagingPanel.add(numberOfRecordsLabel);
        pagingPanel.add(pagingBtnPanel);
    }
}
