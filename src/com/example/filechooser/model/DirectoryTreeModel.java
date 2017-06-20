package com.example.filechooser.model;

import com.example.filechooser.controller.ChooserConst;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class DirectoryTreeModel implements TreeModel{
    private DirectoryTreeNode rootTree;

    public DirectoryTreeModel(){
        rootTree = new DirectoryTreeNode(ChooserConst.NAME_TREE_ROOT);
    }

    @Override
    public Object getRoot() {
        return rootTree;
    }

    @Override
    public Object getChild(Object parent, int index) {
        DirectoryTreeNode parentTrue = (DirectoryTreeNode)parent;
        return parentTrue.getChild(index);
    }

    @Override
    public int getChildCount(Object parent) {
        DirectoryTreeNode parentTrue = (DirectoryTreeNode)parent;
        return parentTrue.getChildCount();
    }

    @Override
    public boolean isLeaf(Object node) {
        DirectoryTreeNode parentTrue = (DirectoryTreeNode)node;
        return parentTrue.isLeaf();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        DirectoryTreeNode parentTrue = (DirectoryTreeNode)parent;
        return parentTrue.getIndexOfChild(child);
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {

    }
}
