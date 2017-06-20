package com.example.filechooser.model;

import com.example.filechooser.controller.ChooserConst;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryTreeNode {
    private String fullPath;
    private List<DirectoryTreeNode> sonsList;
    private boolean sonsIsCreate;

    public DirectoryTreeNode(String fullPath){
        this.fullPath = fullPath;
    }

    public String getFullPath(){
        return fullPath;
    }

    public String toString(){
        String name = new String();

        int n = fullPath.length();
        for (int i = n-1; i >=0; i--) {
            if (fullPath.charAt(i) == '/' && i!=n-1){
                break;
            }
            name = fullPath.charAt(i) + name;
        }
        return name;
    }

    public Object getChild(int index) {
        if (!sonsIsCreate){
            createSonsList();
        }
        return sonsList.get(index);
    }

    public int getChildCount() {
        if (!sonsIsCreate){
            createSonsList();
        }
        return sonsList.size();
    }

    public boolean isLeaf(){
        File f = new File(fullPath);
        return f.isFile();
    }

    public int getIndexOfChild(Object node){
        if (!sonsIsCreate){
            createSonsList();
        }
        DirectoryTreeNode son = (DirectoryTreeNode)node;
        return sonsList.indexOf(son);
    }

    private void createSonsList(){
        sonsIsCreate = true;
        sonsList = new ArrayList<DirectoryTreeNode>();
        File[] listOfFiles;
        if (fullPath.equals(ChooserConst.NAME_TREE_ROOT)){
            listOfFiles = File.listRoots();
        } else{
            File folder = new File(fullPath);
            listOfFiles = folder.listFiles();
        }

        int n = listOfFiles.length;
        for (int i = 0; i < n; i++) {
            if (listOfFiles[i].isDirectory()){
                if (fullPath.equals(ChooserConst.NAME_TREE_ROOT)){
                    String name = new String();
                    String path = listOfFiles[i].getAbsolutePath();
                    int m = path.length();
                    for (int j=0; j<m-1; j++){
                        name = name + path.charAt(j);
                    }
                    sonsList.add(new DirectoryTreeNode("/" + name + "/"));
                }else {
                    sonsList.add(new DirectoryTreeNode(fullPath + "/" + listOfFiles[i].getName()));
                }
            }
        }
    }
}
