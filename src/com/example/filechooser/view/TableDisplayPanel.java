package com.example.filechooser.view;

import com.example.filechooser.model.TableViewModel;
import com.example.filechooser.controller.TableSelectedListener;

import javax.swing.*;
import java.awt.*;

public class TableDisplayPanel extends DisplayPanel {
    private JTable tableFile;

    public TableDisplayPanel(ConsistDirectoryPanel consistDirectoryPanel, String directoryName,ChooseFilePanel chooseFilePanel) {
        super(consistDirectoryPanel ,directoryName, chooseFilePanel);
    }

    public void changedConsist(){
        tableFile.setModel(new TableViewModel(listOfFiles));
    }

    public void setProperty(){
        tableFile = new JTable();
        tableFile.addMouseListener(new TableSelectedListener(tableFile,consistDirectoryPanel));
        JScrollPane scroll = new JScrollPane(tableFile);
        scroll.setPreferredSize(new Dimension(getWidth(),getHeight()));
        add(scroll, BorderLayout.CENTER);
    }
}
