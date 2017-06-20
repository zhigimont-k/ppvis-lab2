package com.example.filechooser.controller;

import com.example.filechooser.view.ConsistDirectoryPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoHomeListener implements ActionListener {
    private ConsistDirectoryPanel consistDirectoryPanel;
    private String homeDirectory;

    public GoHomeListener(ConsistDirectoryPanel consistDirectoryPanel, String homeDirectory){
        this.consistDirectoryPanel = consistDirectoryPanel;
        this.homeDirectory = homeDirectory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        consistDirectoryPanel.setCurrentDirectory(homeDirectory);
    }
}
