package com.example.filechooser.controller;

import com.example.filechooser.view.ConsistDirectoryPanel;
import com.example.filechooser.model.DirectoryTreeNode;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class DirectorySelectedListener implements TreeSelectionListener{
    private ConsistDirectoryPanel consistDirectoryPanel;

    public DirectorySelectedListener(ConsistDirectoryPanel consistDirectoryPanel){
        this.consistDirectoryPanel = consistDirectoryPanel;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DirectoryTreeNode node = (DirectoryTreeNode)e.getPath().getLastPathComponent();
        consistDirectoryPanel.setCurrentDirectory(node.getFullPath());
    }
}
