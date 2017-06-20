package com.example.filechooser.view;

import com.example.filechooser.controller.ListSelectedListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DirectoryDisplayPanel extends DisplayPanel{
    DefaultListModel listModel;
    public DirectoryDisplayPanel(ConsistDirectoryPanel consistDirectoryPanel, String directoryName,ChooseFilePanel chooseFilePanel) {
        super(consistDirectoryPanel,directoryName,chooseFilePanel);
    }

    public void changedConsist(){
        listModel.clear();
        int count = listOfFiles.length;
        for (int index = 0; index < count; index++) {
            String name;
            if (listOfFiles[index].isDirectory()){
                if ("".equals(listOfFiles[index].getName())){
                    name = listOfFiles[index].getAbsolutePath();
                } else{
                    name = listOfFiles[index].getName();
                }
                listModel.addElement(name);
            }
        }
    }

    public void setProperty(){
        listModel = new DefaultListModel();
        JList list = new JList(listModel);
        list.setVisibleRowCount(11);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setCellRenderer(new MyCellRenderer());
        list.addMouseListener(new ListSelectedListener(list,consistDirectoryPanel));
        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(getWidth(),getHeight()));
        add(scroll, BorderLayout.CENTER);
    }

    private static class MyCellRenderer extends JLabel implements ListCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof String) {
                String name = (String) value;
                File file = new File(name);
                if (file.getName().equals("")){
                    name = file.getAbsolutePath();
                }else{
                    name = file.getName();
                }
                /*if (file.isDirectory()){
                    setIcon(new ImageIcon("image/folder.png"));
                }else{
                    setIcon(new ImageIcon("image/file.png"));
                }*/
                setText(name);
                //setVerticalTextPosition(JLabel.BOTTOM);
                //setHorizontalTextPosition(JLabel.CENTER);

                if (isSelected) {
                    setBackground(Color.lightGray);
                } else {
                    setBackground(list.getBackground());
                    setForeground(list.getForeground());
                }
                setFont(list.getFont());
                setOpaque(true);
            }
            return this;
        }
    }
}
