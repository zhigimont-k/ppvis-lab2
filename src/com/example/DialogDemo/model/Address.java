package com.example.DialogDemo.model;

/**
 * Created by student on 14.04.2017.
 */
public class Address {

    String city;
    String street;
    int house;
    int flat;

    public Address(){
        city = "";
        street = "";
        house = 0;
        flat = 0;
    }

    public Address(String inputCity, String inputStreet, int inputHouse, int inputFlat){
        city = inputCity;
        street = inputStreet;
        house = inputHouse;
        flat = inputFlat;
    }

    public String getCity(){
        return city;
    }

    public String getStreet(){
        return street;
    }

    public int getHouse(){
        return house;
    }

    public int getFlat(){
        return flat;
    }

    public void setCity(String newValue){
        city = newValue;
    }

    public void setStreet(String newValue){
        street = newValue;
    }

    public void setHouse(int newValue){
        house = newValue;
    }

    public void setFlat(int newValue){
        flat = newValue;
    }
}
