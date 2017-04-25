package com.example.DialogDemo.view.table.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 14.04.2017.
 */
public class TableModel {
    public List<TableRecord> recordList;

   public TableModel(){
        recordList = new ArrayList<>();
    }

    public void addTableRecord(TableRecord record){
        recordList.add(record);
    }
    public void deleteTableRecord(){}
}
