package com.example.DialogDemo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Karina on 09.04.2017.
 */
public class Database{

    public List<StudentRecord> recordList = new ArrayList<>();

    public Database(){
        recordList = new ArrayList<>();
    }

    public void addRecordToDatabase(StudentRecord record, List<StudentRecord> recordList){
        recordList.add(record);
    }
}
