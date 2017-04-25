package com.example.DialogDemo.view;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.example.DialogDemo.view.table.controller.PageController;
import com.example.DialogDemo.view.table.view.Page;

/**
 * Created by Karina on 17.03.2017.
 */
public class MainWindow {
    public JFrame mainFrame;
    JToolBar toolBar;
    JMenuBar menuBar;
    JMenu menuFile;
    JMenu menuTable;
    public JButton newFileBtn;
    public JMenuItem newFile;
    public JButton openFileBtn;
    public JMenuItem openFile;
    public JButton saveFileBtn;
    public JMenuItem saveFile;
    public JButton addRecordBtn;
    public JMenuItem exit;
    public JButton deleteRecordsBtn;
    public JButton findRecordBtn;
    public JButton exitBtn;
    public JMenuItem addRecord;
    public JMenuItem findRecord;
    public JMenuItem deleteRecords;
    public String title = "PPvIS lab 2";
    public JButton nextPage;
    public JButton previousPage;
    public JButton firstPage;
    public JButton lastPage;
    public JLabel numberOfRecordsLabel;


    public MainWindow(Page tableView, PageController tableController){

        mainFrame = new JFrame();
        mainFrame.setTitle(title);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(800, 600);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);

        menuTable = new JMenu("Table");
        menuTable.setMnemonic(KeyEvent.VK_T);

        toolBar = new JToolBar("Tools", JToolBar.HORIZONTAL);

        numberOfRecordsLabel = new JLabel("Records in database: ");

        java.net.URL newFileIconURL = getClass().getResource("images/newIcon.png");
        java.net.URL openFileIconURL = getClass().getResource("images/openFileIcon.png");
        java.net.URL saveFileIconURL = getClass().getResource("images/saveFileIcon.png");
        java.net.URL addRecordIconURL = getClass().getResource("images/addRecordIcon.png");
        java.net.URL deleteRecordsIconURL = getClass().getResource("images/deleteRecordsIcon.png");
        java.net.URL searchRecordsIconURL = getClass().getResource("images/searchRecordsIcon.png");
        java.net.URL exitIconURL = getClass().getResource("images/exitIcon.png");

        ImageIcon newFileIcon = new ImageIcon(newFileIconURL);
        ImageIcon openFileIcon = new ImageIcon(openFileIconURL);
        ImageIcon saveFileIcon = new ImageIcon(saveFileIconURL);
        ImageIcon addRecordIcon = new ImageIcon(addRecordIconURL);
        ImageIcon deleteRecordsIcon = new ImageIcon(deleteRecordsIconURL);
        ImageIcon findRecordsIcon = new ImageIcon(searchRecordsIconURL);
        ImageIcon exitIcon = new ImageIcon(exitIconURL);

        newFileBtn = new JButton(newFileIcon);
        newFileBtn.setToolTipText("Create a new file");
        openFileBtn = new JButton(openFileIcon);
        openFileBtn.setToolTipText("Open file");
        saveFileBtn = new JButton(saveFileIcon);
        saveFileBtn.setToolTipText("Save file");
        addRecordBtn = new JButton(addRecordIcon);
        addRecordBtn.setToolTipText("Add a record");
        deleteRecordsBtn = new JButton(deleteRecordsIcon);
        deleteRecordsBtn.setToolTipText("Delete records");
        findRecordBtn = new JButton(findRecordsIcon);
        findRecordBtn.setToolTipText("Search records");
        exitBtn = new JButton(exitIcon);
        exitBtn.setToolTipText("Exit");


        nextPage = new JButton("Next >");
        nextPage.setEnabled(false);

        previousPage = new JButton ("< Prev");
        previousPage.setEnabled(false);

        firstPage = new JButton("<< First");
        firstPage.setEnabled(false);

        lastPage = new JButton(">> Last");
        lastPage.setEnabled(false);

        toolBar.add(newFileBtn);
        toolBar.add(openFileBtn);
        toolBar.add(saveFileBtn);
        toolBar.addSeparator();
        toolBar.add(addRecordBtn);
        toolBar.add(deleteRecordsBtn);
        toolBar.add(findRecordBtn);
        toolBar.addSeparator();
        toolBar.add(exitBtn);
        toolBar.addSeparator();
        toolBar.add(firstPage);
        toolBar.add(previousPage);
        toolBar.add(nextPage);
        toolBar.add(lastPage);

        newFile = new JMenuItem("New", KeyEvent.VK_N);
        newFile.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK
                )
        );

        openFile = new JMenuItem("Open...", KeyEvent.VK_O);
        openFile.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK
                )
        );
        saveFile = new JMenuItem("Save", KeyEvent.VK_S);
        saveFile.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK
                )
        );
        exit = new JMenuItem("Exit", KeyEvent.VK_E);
        exit.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK
                )
        );

        addRecord = new JMenuItem("Add record", KeyEvent.VK_R);
        addRecord.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK
                )
        );

        findRecord = new JMenuItem("Find records", KeyEvent.VK_F);
        findRecord.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK
                )
        );

        deleteRecords = new JMenuItem("Delete records");
        deleteRecords.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK
                )
        );

        menuFile.add(newFile);
        menuFile.add(openFile);
        menuFile.add(saveFile);
        menuFile.addSeparator();
        menuFile.add(exit);

        menuTable.add(addRecord);
        menuTable.add(findRecord);
        menuTable.add(deleteRecords);

        menuBar.add(menuFile);
        menuBar.add(menuTable);

        mainFrame.setJMenuBar(menuBar);
        mainFrame.add(toolBar, BorderLayout.NORTH);
        mainFrame.add(numberOfRecordsLabel);



        mainFrame.setVisible(true);

    }




}