package com.example.filechooser.controller;

import com.example.filechooser.view.ConsistDirectoryPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoBackListener implements ActionListener{
    private ConsistDirectoryPanel consistDirectoryPanel;

    public GoBackListener(ConsistDirectoryPanel consistDirectoryPanel){
        this.consistDirectoryPanel = consistDirectoryPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = consistDirectoryPanel.getCurrentDirectory();
        if (!ChooserConst.NAME_TREE_ROOT.equals(name)){
            String newName = new String();
            int count = name.length();
            int stop = -1;
            for (int index = count-1; index >= 0; index--) {
                if (name.charAt(index) == '\\'){
                    stop = index;
                    break;
                }
            }
            for (int index = 0; index < stop; index++){
                newName = newName + name.charAt(index);
            }
            if (!newName.contains("\\") && name.charAt(name.length()-1)=='\\'){
                newName = ChooserConst.NAME_TREE_ROOT;
            } else if (!newName.contains("\\")){
                newName+='\\';
            }
            consistDirectoryPanel.setCurrentDirectory(newName);
        }
    }
}
