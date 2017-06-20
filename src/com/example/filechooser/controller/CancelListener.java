package com.example.filechooser.controller;

import com.example.filechooser.view.FileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelListener implements ActionListener {
    private FileChooser fileChooser;
    public CancelListener(FileChooser fileChooser){
        this.fileChooser = fileChooser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fileChooser.setSelectedFile(null);
        fileChooser.setSelectedFlag(false);
        fileChooser.closeDialog();
    }
}
