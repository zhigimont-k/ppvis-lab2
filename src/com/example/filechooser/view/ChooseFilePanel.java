package com.example.filechooser.view;

import com.example.filechooser.controller.CancelListener;
import com.example.filechooser.controller.ChooserConst;
import com.example.filechooser.controller.EnterListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseFilePanel extends JPanel{
    private JTextField enterFileName;
    private ConsistDirectoryPanel consistDirectoryPanel;
    private JComboBox<String> fileFilter;
    private FileChooser fileChooser;

    public ChooseFilePanel(FileChooser fileChooser){
        this.fileChooser = fileChooser;
        setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        JLabel fileName = new JLabel("Name:");
        enterFileName = new JTextField("",30);
        fileFilter = new JComboBox<String>(ChooserConst.FILTER);
        fileFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consistDirectoryPanel.changeConsist();
                enterFileName.setText("");
            }
        });
        JButton enterButton = new JButton("OK");
        enterButton.addActionListener(new EnterListener(fileChooser,this));
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelListener(fileChooser));
        add(fileName);
        add(enterFileName);
        add(fileFilter);
        add(enterButton);
        add(cancelButton);
    }

    public String getSelectedFile(){
        return enterFileName.getText();
    }
    public void changeSelectedFile(String name){
        enterFileName.setText(name);
    }

    public ConsistDirectoryPanel getConsistDirectoryPanel() {
        return consistDirectoryPanel;
    }

    public void setConsistDirectoryPanel(ConsistDirectoryPanel consistDirectoryPanel) {
        this.consistDirectoryPanel = consistDirectoryPanel;
    }

    public boolean checkFile(String name){
        int count = ChooserConst.FILTER.length;
        String selected = (String) fileFilter.getSelectedItem();
        if (selected.equals("ALL")){
            return true;
        }
        for (int i = 0; i < count; i++) {
            if (selected.equals(ChooserConst.FILTER[i])){
                if (name.contains(ChooserConst.EXTENSION[i])){
                    return true;
                }
            }
        }

        return false;
    }

    public String getFormat(){
        int count = ChooserConst.FILTER.length;
        String selected = (String) fileFilter.getSelectedItem();
        if (selected.equals("ALL")){
            return "";
        }
        for (int index = 0; index < count; index++) {
            if (selected.equals(ChooserConst.FILTER[index])){
                return ChooserConst.EXTENSION[index];
            }
        }

        return "";
    }
}
