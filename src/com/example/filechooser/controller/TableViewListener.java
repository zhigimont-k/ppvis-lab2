package com.example.filechooser.controller;

import com.example.filechooser.view.ChooseFilePanel;
import com.example.filechooser.view.ConsistDirectoryPanel;
import com.example.filechooser.view.TableDisplayPanel;


import javax.swing.*;

public class TableViewListener extends ModeListener {
    public TableViewListener(ConsistDirectoryPanel consistDirectoryPanel, JToolBar changeConsist, ChooseFilePanel chooseFilePanel){
        super(consistDirectoryPanel,changeConsist,chooseFilePanel);
    }

    protected void changeMode(){
        TableDisplayPanel newTable = new TableDisplayPanel(consistDirectoryPanel,
                consistDirectoryPanel.getCurrentDirectory(),chooseFilePanel);
        consistDirectoryPanel.setDisplayPanel(newTable);
    }
}
