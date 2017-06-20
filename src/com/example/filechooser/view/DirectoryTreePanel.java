package com.example.filechooser.view;

import com.example.filechooser.controller.DirectorySelectedListener;
import com.example.filechooser.model.DirectoryTreeModel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;

public class DirectoryTreePanel extends JPanel {
    private DirectoryTreeView directoryTreeView;

    public DirectoryTreePanel(ConsistDirectoryPanel consistDirectoryPanel){
        setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        setLayout(new BorderLayout());
        directoryTreeView = new DirectoryTreeView(new DirectoryTreeModel());
        directoryTreeView.addTreeSelectionListener(new DirectorySelectedListener(consistDirectoryPanel));
        add(new JScrollPane(directoryTreeView), BorderLayout.CENTER);
    }

    public DirectoryTreeView getDirectoryTreeView(){
        return directoryTreeView;
    }
}
