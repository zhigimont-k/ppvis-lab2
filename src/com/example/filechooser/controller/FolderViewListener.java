package com.example.filechooser.controller;

import com.example.filechooser.view.ChooseFilePanel;
import com.example.filechooser.view.ConsistDirectoryPanel;
import com.example.filechooser.view.DirectoryDisplayPanel;

import javax.swing.*;

public class FolderViewListener extends ModeListener{
    public FolderViewListener(ConsistDirectoryPanel consistDirectoryPanel, JToolBar changeConsist, ChooseFilePanel chooseFilePanel) {
        super(consistDirectoryPanel, changeConsist, chooseFilePanel);
    }

    protected void changeMode(){
        consistDirectoryPanel.setDisplayPanel(new DirectoryDisplayPanel(consistDirectoryPanel,
                consistDirectoryPanel.getCurrentDirectory(),chooseFilePanel));
    }
}
