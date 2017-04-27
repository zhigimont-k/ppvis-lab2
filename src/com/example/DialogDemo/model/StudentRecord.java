package com.example.DialogDemo.model;

/**
 * Created by Karina on 03.04.2017.
 */
public class StudentRecord {
    public String firstName;
    public String lastName;
    public Address address;
    public String mobilePhoneNumber;
    public String phoneNumber;

     public StudentRecord(String inputFirstName, String inputLastName,
                  String inputCity, String inputStreet, int inputHouse,
                  int inputFlat, String inputMobilePhoneNumber, String inputPhoneNumber){
        firstName = inputFirstName;
        lastName = inputLastName;
         address = new Address(inputCity, inputStreet, inputHouse, inputFlat);
        mobilePhoneNumber = inputMobilePhoneNumber;
        phoneNumber = inputPhoneNumber;
    }

    public StudentRecord(){
        firstName = "";
        lastName = "";
        address = new Address();
        mobilePhoneNumber = "";
        phoneNumber = "";
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getMobilePhoneNumber(){
        return mobilePhoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setFirstName(String newValue){
        firstName = newValue;
    }

    public void setLastName(String newValue){
        lastName = newValue;
    }

    public void setCity(String newValue){
        address.city = newValue;
    }

    public void setStreet(String newValue){
        address.street = newValue;
    }

    public void setHouse(int newValue){
        address.house = newValue;
    }

    public void setFlat(int newValue){
        address.flat = newValue;
    }

    public void setMobilePhoneNumber(String newValue){
        mobilePhoneNumber = newValue;
    }

    public void setPhoneNumber(String newValue){
        phoneNumber = newValue;
    }

}
