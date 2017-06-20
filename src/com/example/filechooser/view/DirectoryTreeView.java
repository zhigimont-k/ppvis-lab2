package com.example.filechooser.view;

import com.example.filechooser.model.DirectoryTreeModel;

import javax.swing.JTree;

public class DirectoryTreeView extends JTree {
    private DirectoryTreeModel directoryTreeModel;
    public DirectoryTreeView(DirectoryTreeModel directoryTreeModel){
        super(directoryTreeModel);
        this.directoryTreeModel = directoryTreeModel;
    }
}
