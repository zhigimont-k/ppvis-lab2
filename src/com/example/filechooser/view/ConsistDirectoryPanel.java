package com.example.filechooser.view;

import com.example.filechooser.controller.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;

public class ConsistDirectoryPanel extends JPanel {
    private String homeDirectory;
    private String currentDirectory;
    private DisplayPanel displayPanel = null;
    private ChooseFilePanel chooseFilePanel;

    public ConsistDirectoryPanel(String homeDirectory,ChooseFilePanel chooseFilePanel){
        setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        setLayout(new BorderLayout());
        JToolBar toolBar = new JToolBar("", JToolBar.HORIZONTAL);
        toolBar.setFloatable(false);

        java.net.URL folderViewIconURL = getClass().getResource("images/folderViewIcon.png");
        java.net.URL goBackIconURL = getClass().getResource("images/goBackIcon.png");
        java.net.URL homeIconURL = getClass().getResource("images/homeIcon.png");
        java.net.URL listViewIconURL = getClass().getResource("images/listViewIcon.png");
        java.net.URL tableViewIconURL = getClass().getResource("images/tableViewIcon.png");

        ImageIcon folderViewIcon = new ImageIcon(folderViewIconURL);
        ImageIcon goBackIcon = new ImageIcon(goBackIconURL);
        ImageIcon homeIcon = new ImageIcon(homeIconURL);
        ImageIcon listViewIcon = new ImageIcon(listViewIconURL);
        ImageIcon tableViewIcon = new ImageIcon(tableViewIconURL);

        JButton goHome = new JButton(homeIcon);
        goHome.addActionListener(new GoHomeListener(this,homeDirectory));
        JButton goBack = new JButton(goBackIcon);
        goBack.addActionListener(new GoBackListener(this));
        JToggleButton toTableView = new JToggleButton(tableViewIcon,true);
        toTableView.addActionListener(new TableViewListener(this, toolBar,chooseFilePanel));
        JToggleButton toListView = new JToggleButton(listViewIcon,false);
        toListView.addActionListener(new ListViewListener(this, toolBar,chooseFilePanel));
        JToggleButton toFolderView = new JToggleButton(folderViewIcon,false);
        toFolderView.addActionListener(new FolderViewListener(this, toolBar,chooseFilePanel));

        toolBar.add(goHome);
        toolBar.add(goBack);
        toolBar.add(toTableView);
        toolBar.add(toListView);
        toolBar.add(toFolderView);
        add(toolBar,BorderLayout.NORTH);

        this.homeDirectory = homeDirectory;
        currentDirectory = homeDirectory;
        this.chooseFilePanel = chooseFilePanel;
        displayPanel = new TableDisplayPanel(this,currentDirectory,chooseFilePanel);
        add(displayPanel, BorderLayout.CENTER);
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(String currentDirectory) {
        this.currentDirectory = currentDirectory;
        changeConsist();
    }

    public void changeConsist(){
        displayPanel.setConsist(currentDirectory);
    }

    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }

    public void setDisplayPanel(DisplayPanel displayPanel1) {
        remove(displayPanel);
        this.displayPanel = displayPanel1;
        add(this.displayPanel,BorderLayout.CENTER);
        this.displayPanel.updateUI();
    }

    public ChooseFilePanel getChooseFilePanel() {
        return chooseFilePanel;
    }
}
