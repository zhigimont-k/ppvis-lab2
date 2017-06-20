package com.example.filechooser.controller;

import com.example.filechooser.model.TableViewModel;
import com.example.filechooser.view.ConsistDirectoryPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class TableSelectedListener implements MouseListener {
    private JTable tableFile;
    private ConsistDirectoryPanel consistDirectoryPanel;

    public TableSelectedListener(JTable tableFile,ConsistDirectoryPanel consistDirectoryPanel){
        this.tableFile = tableFile;
        this.consistDirectoryPanel = consistDirectoryPanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int indexRow = tableFile.getSelectedRow();
        if (indexRow != -1){
            TableViewModel tableModel = (TableViewModel)tableFile.getModel();
            File file = tableModel.getFileAt(indexRow);
            if (file.isDirectory() && e.getClickCount() == 2){
                consistDirectoryPanel.setCurrentDirectory(file.getAbsolutePath());
                consistDirectoryPanel.getChooseFilePanel().changeSelectedFile("");
            } else if (file.isFile()) {
                consistDirectoryPanel.getChooseFilePanel().changeSelectedFile(file.getName());
            } else{
                consistDirectoryPanel.getChooseFilePanel().changeSelectedFile("");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
