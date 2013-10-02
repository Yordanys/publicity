/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicity.utils;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrador
 */
public class ButtonIcon implements Icon {

    private ImageIcon imageIcon;
    
    public ButtonIcon(String fileName) {
        URL imgURL = getClass().getResource("/com/publicity/resources/images/"+ fileName);
        if (imgURL != null) {
            imageIcon = new ImageIcon(imgURL);
        }
    }
    
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.drawImage(imageIcon.getImage(), x, y, imageIcon.getImageObserver());
    }

    @Override
    public int getIconWidth() {
        return imageIcon.getIconHeight();
    }

    @Override
    public int getIconHeight() {
        return imageIcon.getIconWidth();
    }
    
}
