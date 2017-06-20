package com.example.filechooser.controller;

import com.example.filechooser.view.ChooseFilePanel;
import com.example.filechooser.view.ConsistDirectoryPanel;
import com.example.filechooser.view.ListViewPanel;

import javax.swing.*;

public class ListViewListener extends ModeListener {
    public ListViewListener(ConsistDirectoryPanel consistDirectoryPanel, JToolBar changeConsist, ChooseFilePanel chooseFilePanel) {
        super(consistDirectoryPanel, changeConsist, chooseFilePanel);
    }

    protected void changeMode(){
        consistDirectoryPanel.setDisplayPanel(new ListViewPanel(consistDirectoryPanel,
                consistDirectoryPanel.getCurrentDirectory(),chooseFilePanel));
    }
}
