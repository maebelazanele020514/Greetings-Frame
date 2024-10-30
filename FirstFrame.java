/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
/**
 *
 * @author hifi
 */
public class FirstFrame extends JFrame{
//create panels
    private JPanel headingPanel;
    private JPanel nameAndSurnamePanel;
    private JPanel namePanel;
    private JPanel surnamePanel;
    private JPanel greetingsPanel;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    
//create TextFields
    private JTextField nameTextFld;
    private JTextField surnameTextFld;
    
// create Labels
    private JLabel headingLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    
//create TextArea
    private JTextArea greetingTxtArea;
    
//create Buttons
    private JButton greetButton;
    private JButton clearButton;
    private JButton exitButton;
    
    public FirstFrame() {
        //Initialise your frame
        setTitle("First Frame");
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setForeground(Color.PINK);
        
        //create panels
        
        namePanel=new JPanel(new FlowLayout());
        surnamePanel=new JPanel(new FlowLayout());
        
        nameAndSurnamePanel=new JPanel(new GridLayout(2,1));
        greetingsPanel=new JPanel(new BorderLayout());
        
        buttonPanel=new JPanel(new FlowLayout());
        mainPanel=new JPanel(new BorderLayout());
        
        headingPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        headingPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        
        //create TextFields
        nameTextFld=new JTextField(10);
        surnameTextFld=new JTextField(10);
        
        //create Labels
        headingLabel=new JLabel("Greetings App");
        
        nameLabel=new JLabel("Name: ");
        surnameLabel=new JLabel("Surname: ");
        
        //create TextArea
        greetingTxtArea=new JTextArea(20,40);
        greetingTxtArea.setEditable(false);
        greetingTxtArea.setText("Hello [Name] [Surname]");
        greetingTxtArea.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1), "Greetings Text"));
        
        //create buttons
        greetButton=new JButton ("Greet");
        greetButton.addActionListener(new GreetButtonListener());
        
        clearButton=new JButton ("Clear");
        clearButton.addActionListener(new ClearButtonListener());
        
        exitButton=new JButton ("Exit");
        exitButton.addActionListener(new ExitButtonListener());
        
        //add components to panels
        
        namePanel.add(nameLabel);
        namePanel.add(nameTextFld);
       
        surnamePanel.add(surnameLabel);
        surnamePanel.add(surnameTextFld);
        
        nameAndSurnamePanel.add(namePanel);
        nameAndSurnamePanel.add(surnamePanel);
        
        greetingsPanel.add(greetingTxtArea);
        
        
        buttonPanel.add(greetButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
        
        headingPanel.add(headingLabel);
        
        mainPanel.add(nameAndSurnamePanel, BorderLayout.NORTH);
        mainPanel.add(greetingTxtArea, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(headingPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        
         
        setVisible(true);
        
       
    }
    private class GreetButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           greetingTxtArea.setText("Hello"+" "+nameTextFld.getText()+" "+ surnameTextFld.getText());
        }
        
    }
    
    private class ClearButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           greetingTxtArea.setText("");
        }
        
    }
    
    private class ExitButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           System.exit(0);
        }
        
    }
}
