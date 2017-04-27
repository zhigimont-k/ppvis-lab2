package com.example.DialogDemo.controller;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.example.DialogDemo.model.Address;
import com.example.DialogDemo.model.Database;
import com.example.DialogDemo.model.StudentRecord;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import javax.swing.JFileChooser;
import com.example.DialogDemo.view.MainWindow;
import com.example.DialogDemo.view.table.view.Page;


/**
 * Created by Karina on 09.04.2017.
 */
public class FileOpen {
    File fileToOpen;
    //StudentRecord addedRecord = new StudentRecord();
    StudentRecord addedRecord;
    String filename;
    Database model;

    public FileOpen(MainWindow mainWindow, Page tableView, Database model){

        this.model = model;
        JFileChooser fileChooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setCurrentDirectory(workingDirectory);
        fileChooser.setFileFilter(new FileNameExtensionFilter(".xml","xml"));
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileToOpen = fileChooser.getSelectedFile();
        } else
            return;
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean firstNameBoolean = false;
                boolean lastNameBoolean = false;
                boolean cityBoolean = false;
                boolean houseBoolean = false;
                boolean streetBoolean = false;
                boolean flatBoolean = false;
                boolean addressBoolean;
                boolean mobilePhoneNumberBoolean = false;
                boolean phoneNumberBoolean = false;


                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {

                    System.out.println("Start Element :" + qName);

                    if (qName.equalsIgnoreCase("FirstName")) {
                        firstNameBoolean = true;

                    }

                    if (qName.equalsIgnoreCase("LastName")) {
                        lastNameBoolean = true;
                    }

                    if (qName.equalsIgnoreCase("Address")) {
                        addressBoolean = true;
                    }

                    if (qName.equalsIgnoreCase("City")) {
                        cityBoolean = true;
                    }

                    if (qName.equalsIgnoreCase("Street")) {
                        streetBoolean = true;
                    }

                    if (qName.equalsIgnoreCase("House")) {
                        houseBoolean = true;
                    }

                    if (qName.equalsIgnoreCase("Flat")) {
                        flatBoolean = true;
                    }

                    if (qName.equalsIgnoreCase("MobilePhone")) {
                        mobilePhoneNumberBoolean = true;
                    }

                    if (qName.equalsIgnoreCase("Phone")) {
                        phoneNumberBoolean = true;
                    }


                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                    System.out.println("End Element :" + qName);

                }

                //

                public void characters(char ch[], int start, int length) throws SAXException {


                    String firstName;
                    String lastName;
                    Address address = new Address();
                    String mobilePhoneNumber;
                    String phoneNumber;


                    if (firstNameBoolean) {

                        addedRecord = new StudentRecord();
                        firstName = new String(ch, start, length);
                        addedRecord.setFirstName(firstName);
                        System.out.println("First Name : " + firstName);
                        firstNameBoolean = false;
                    }

                    if (lastNameBoolean) {
                        lastName = new String(ch, start, length);
                        addedRecord.setLastName(lastName);
                        System.out.println("Last Name : " + lastName);
                        lastNameBoolean = false;
                    }


                    if (addressBoolean) {
                        if (cityBoolean) {
                            address.setCity(new String(ch, start, length));
                            addedRecord.setCity(address.getCity());
                            System.out.println("City : " + address.getCity());
                            cityBoolean = false;
                        }

                        if (streetBoolean) {
                            address.setStreet(new String(ch, start, length));
                            addedRecord.setStreet(address.getStreet());
                            System.out.println("Street : " + address.getStreet());
                            streetBoolean = false;
                        }

                        if (houseBoolean) {
                            String houseString = new String(ch, start, length);
                            address.setHouse(Integer.parseInt(houseString));
                            addedRecord.setHouse(address.getHouse());
                            System.out.println("House : " + address.getHouse());
                            houseBoolean = false;
                        }

                        if (flatBoolean) {
                            String flatString = new String(ch, start, length);
                            address.setFlat(Integer.parseInt(flatString));
                            addedRecord.setFlat(address.getFlat());
                            System.out.println("Flat : " + address.getFlat());
                            flatBoolean = false;
                        }
                    }

                    if (mobilePhoneNumberBoolean) {
                        mobilePhoneNumber = new String(ch, start, length);
                        addedRecord.setMobilePhoneNumber(mobilePhoneNumber);
                        System.out.println("Mobile phone : " + mobilePhoneNumber);
                        mobilePhoneNumberBoolean = false;
                    }

                    if (phoneNumberBoolean) {
                        phoneNumber = new String(ch, start, length);
                        addedRecord.setPhoneNumber(phoneNumber);
                        System.out.println("Phone : " + phoneNumber);
                        phoneNumberBoolean = false;

                        model.addRecordToDatabase(addedRecord, model.recordList);


                        //int rowIndex = Database.recordList.size() - 1;

                        /*tableView.table.getModel().setValueAt(addedRecord.getFirstName(), rowIndex, 0);
                        tableView.table.getModel().setValueAt(addedRecord.getLastName(), rowIndex, 1);
                        tableView.table.getModel().setValueAt(addedRecord.address.getCity(), rowIndex, 2);
                        tableView.table.getModel().setValueAt(addedRecord.address.getStreet(), rowIndex, 3);
                        tableView.table.getModel().setValueAt(addedRecord.address.getHouse(), rowIndex, 4);
                        tableView.table.getModel().setValueAt(addedRecord.address.getFlat(), rowIndex, 5);
                        tableView.table.getModel().setValueAt(addedRecord.getMobilePhoneNumber(), rowIndex, 6);
                        tableView.table.getModel().setValueAt(addedRecord.getPhoneNumber(), rowIndex, 7);*/
                    }


                }

            };

            saxParser.parse(fileToOpen, handler);
            mainWindow.mainFrame.setTitle(mainWindow.title + " - \"" + fileToOpen.getPath() + "\"");


        } catch (Exception e) {
            e.printStackTrace();
        }
        //mainWindow.setTitle(fileToOpen);
    }

}
