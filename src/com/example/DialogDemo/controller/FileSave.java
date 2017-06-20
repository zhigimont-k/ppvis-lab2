package com.example.DialogDemo.controller;


import java.io.File;
import java.util.List;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.swing.JFileChooser;

import com.example.DialogDemo.model.StudentRecord;
import com.example.DialogDemo.view.MainWindow;
import com.example.filechooser.view.FileChooser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;

public class FileSave {
    File fileToSave;
    FileChooser fileChooser;
    public FileSave(MainWindow mainWindow, List<StudentRecord> recordList) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.showSaveDialog(null);
        if (fileChooser.isSelectedFlag()) {
            fileToSave = fileChooser.getSelectedFile();
            String fileName = fileToSave.getName();
            if (fileName.length() < 4 || !(fileName.substring(fileName.length() - 4).equals(".xml"))){
                fileToSave = new File(fileChooser.getSelectedFile()+".xml");
            } else {
                fileToSave = fileChooser.getSelectedFile();
            }
        } else
            return;

        try {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("Records");
        doc.appendChild(rootElement);


        for (int index = 0; index < recordList.size(); index++){
            Element student = doc.createElement("Student");
            rootElement.appendChild(student);

            Element firstName = doc.createElement("FirstName");
            firstName.appendChild(doc.createTextNode(String.valueOf(recordList.get(index).getFirstName())));
            student.appendChild(firstName);

            Element lastName = doc.createElement("LastName");
            lastName.appendChild(doc.createTextNode(String.valueOf(recordList.get(index).getLastName())));
            student.appendChild(lastName);

            Element address = doc.createElement("Address");
            student.appendChild(address);

            Element city = doc.createElement("City");
            city.appendChild(doc.createTextNode(String.valueOf(recordList.get(index).address.getCity())));
            address.appendChild(city);

            Element street = doc.createElement("Street");
            street.appendChild(doc.createTextNode(String.valueOf(recordList.get(index).address.getStreet())));
            address.appendChild(street);

            Element house = doc.createElement("House");
            house.appendChild(doc.createTextNode(Integer.valueOf(recordList.get(index).address.getHouse()).toString()));
            address.appendChild(house);

            Element flat = doc.createElement("Flat");
            flat.appendChild(doc.createTextNode(Integer.valueOf(recordList.get(index).address.getFlat()).toString()));
            address.appendChild(flat);

            Element mobilePhoneNumber = doc.createElement("MobilePhone");
            mobilePhoneNumber.appendChild(doc.createTextNode(String.valueOf(recordList.get(index).getMobilePhoneNumber())));
            student.appendChild(mobilePhoneNumber);

            Element phoneNumber = doc.createElement("Phone");
            phoneNumber.appendChild(doc.createTextNode(String.valueOf(recordList.get(index).getPhoneNumber())));
            student.appendChild(phoneNumber);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(fileToSave);

        transformer.transform(source, result);
        mainWindow.mainFrame.setTitle(mainWindow.title + " - \"" + fileToSave.getPath() + "\"");


        System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
