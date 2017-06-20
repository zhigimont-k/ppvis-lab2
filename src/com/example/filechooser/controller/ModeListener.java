package com.example.filechooser.controller;

import com.example.filechooser.view.ChooseFilePanel;
import com.example.filechooser.view.ConsistDirectoryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ModeListener implements ActionListener {
    protected ConsistDirectoryPanel consistDirectoryPanel;
    protected JToolBar toolBar;
    protected ChooseFilePanel chooseFilePanel;

    protected ModeListener(ConsistDirectoryPanel consistDirectoryPanel, JToolBar changeConsist,ChooseFilePanel chooseFilePanel){
        this.toolBar = changeConsist;
        this.consistDirectoryPanel = consistDirectoryPanel;
        this.chooseFilePanel = chooseFilePanel;
    }

    protected void changeMode(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton currentButton;
        int count = toolBar.getComponentCount();
        for (int index=0; index<count; index++){
            if (toolBar.getComponentAtIndex(index) instanceof JToggleButton){
                currentButton = (JToggleButton) toolBar.getComponentAtIndex(index);
                if (e.getActionCommand().equals(currentButton.getActionCommand())){
                    currentButton.setSelected(true);
                } else{
                    currentButton.setSelected(false);
                }
            }
        }
        changeMode();
    }
}
