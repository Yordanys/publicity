/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicity.ui.custom;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Yordanys
 */
public class NewClass {
    
     public static void main(String[] args) {  
            // Create a button with the label "Jackpot".  
            ActivePanel panel = new ActivePanel();  
            
            // Create a frame in which to show the button.  
            JFrame frame = new JFrame();  
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.getContentPane().setBackground(Color.black);  
            frame.getContentPane().add(panel);  
            //frame.getContentPane().setLayout(new FlowLayout());  
            frame.setSize(150, 50);  
            frame.setVisible(true);  
        }  
    
}
