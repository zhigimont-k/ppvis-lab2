package com.example.filechooser.model;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.text.SimpleDateFormat;

public class TableViewModel extends AbstractTableModel {
    private File[] listFile;

    public TableViewModel(File[] newFile){
        listFile = newFile;
    }
    @Override
    public int getRowCount() {
        return listFile.length;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            if ("".equals(listFile[rowIndex].getName())) {
                return listFile[rowIndex].getAbsolutePath();
            } else {
                if(listFile[rowIndex].isDirectory()){
                    return listFile[rowIndex].getName();
                } else{
                    String name = listFile[rowIndex].getName();
                    int left = -1, count = name.length();
                    for (int index = 0; index < count; index++) {
                        if (name.charAt(index) == '.') {
                            left = index;
                            break;
                        }
                    }
                    if (left == -1) {
                        return name;
                    }

                    String newName = new String();
                    for (int index = 0; index < left; index++) {
                        newName = newName + name.charAt(index);
                    }
                    return newName;
                }

            }
        } else if (columnIndex == 1) {
            if (listFile[rowIndex].isDirectory()) {
                return "<folder>";
            } else {
                String name = listFile[rowIndex].getName();
                int left = -1, count = name.length();
                for (int index = 0; index < count; index++) {
                    if (name.charAt(index) == '.') {
                        left = index;
                        break;
                    }
                }
                if (left == -1) {
                    return "unknown file";
                }

                String newName = new String();
                for (int index = left + 1; index < count; index++) {
                    newName = newName + name.charAt(index);
                }
                newName += "-file";
                return newName;
            }
        } else if (columnIndex == 2) {
            if (listFile[rowIndex].isDirectory()){
                return "";
            } else {
                String name = Integer.toString((int) listFile[rowIndex].length());
                return name + " B";
            }
        } else {
            long time = listFile[rowIndex].lastModified();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            return format.format(time);
        }
    }
    @Override
    public String getColumnName(int column) {
        String columnName[] ={
                "Name:",
                "Type:",
                "Size:",
                "Last modified:",
        };
        return columnName[column];
    }

    public File getFileAt(int x){
        return listFile[x];
    }
}
