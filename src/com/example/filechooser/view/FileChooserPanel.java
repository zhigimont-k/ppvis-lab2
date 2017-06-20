package com.example.filechooser.view;

import javax.swing.*;
import java.awt.BorderLayout;

public class FileChooserPanel extends JPanel {
    private ChooseFilePanel chooseFilePanel;
    private DirectoryTreePanel treeDirectoryPanel;
    private ConsistDirectoryPanel consistDirectoryPanel;
    private String homeDirectory;

    public FileChooserPanel(String homeDirectory, FileChooser fileChooser){
        this.homeDirectory = homeDirectory;
        setLayout(null);
        chooseFilePanel = new ChooseFilePanel(fileChooser);
        consistDirectoryPanel = new ConsistDirectoryPanel(homeDirectory,chooseFilePanel);
        chooseFilePanel.setConsistDirectoryPanel(consistDirectoryPanel);
        treeDirectoryPanel = new DirectoryTreePanel(consistDirectoryPanel);
        treeDirectoryPanel.setBounds(0,0,200,400);
        consistDirectoryPanel.setBounds(200,0,600,400);
        chooseFilePanel.setBounds(0,400,700,100);
        add(chooseFilePanel,BorderLayout.SOUTH);
        add(treeDirectoryPanel,BorderLayout.WEST);
        add(consistDirectoryPanel,BorderLayout.CENTER);
    }

    public ChooseFilePanel getChooseFilePanel() {
        return chooseFilePanel;
    }

    public void setChooseFilePanel(ChooseFilePanel chooseFilePanel) {
        this.chooseFilePanel = chooseFilePanel;
    }

    public DirectoryTreePanel getTreeDirectoryPanel() {
        return treeDirectoryPanel;
    }

    public void setTreeDirectoryPanel(DirectoryTreePanel treeDirectoryPanel) {
        this.treeDirectoryPanel = treeDirectoryPanel;
    }

    public ConsistDirectoryPanel getConsistDirectoryPanel() {
        return consistDirectoryPanel;
    }

    public void setConsistDirectoryPanel(ConsistDirectoryPanel consistDirectoryPanel) {
        this.consistDirectoryPanel = consistDirectoryPanel;
    }
}
