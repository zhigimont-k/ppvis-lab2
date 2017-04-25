package com.example.DialogDemo.view.table.model;

import com.example.DialogDemo.model.Address;

import java.util.Vector;

/**
 * Created by Karina on 10.04.2017.
 */
public class TableRecord {
    String firstName;
    String lastName;
    String city;
    String street;
    String house;
    String flat;
    String mobilePhoneNumber;
    String phoneNumber;

    public TableRecord(){
        firstName = "";
        lastName = "";
        city = "";
        street = "";
        house = "";
        flat = "";
        mobilePhoneNumber = "";
        phoneNumber = "";
    }

    public TableRecord(String inputFirstName, String inputLastName,
                       String inputCity, String inputStreet, String inputHouse,
                       String inputFlat, String inputMobilePhoneNumber, String inputPhoneNumber){
        firstName = inputFirstName;
        lastName = inputLastName;
        city = inputCity;
        street = inputStreet;
        house = inputHouse;
        flat = inputFlat;
        mobilePhoneNumber = inputMobilePhoneNumber;
        phoneNumber = inputPhoneNumber;
    }


}
