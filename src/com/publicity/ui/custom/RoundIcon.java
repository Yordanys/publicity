package com.publicity.ui.custom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.DebugGraphics;
import javax.swing.Icon;

/**
 *
 * @author Yordanys
 */
public class RoundIcon implements Icon {

    private static final int NORMAL = 0;
    private static final int PRESSED = 1;
    private static final int ROLLOVER = 2;
    private int state;	
    
    public enum STYLE {RED, GREEN};
    private Color borderColor;
    private Color backgroundColor;
    private Color rollOverColor = new Color(40, 120, 180);
    private Color centerColor;
    
    public RoundIcon() {
    }

    public RoundIcon(int state, STYLE style) {
        this.state = state;
        changeStyle(style);
    }
    
    public void changeStyle(STYLE style) {
        switch (style) {
            case GREEN: 
                borderColor = new Color(40, 230, 80);
                backgroundColor = new Color(210, 250, 210);
                centerColor = new Color(0, 100, 0);               
                break;
            case RED: 
                borderColor = new Color(230, 40, 80);
                backgroundColor = new Color(250, 210, 210);
                centerColor = new Color(100, 0, 0);                
                break;
        }
    }
         
    @Override
    public int getIconHeight() {			
        return 20;
    }

    @Override
    public int getIconWidth() {
        return 20;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {        
        g.setColor(borderColor);     
        g.fillOval(0, 0, 20, 20);         
        g.setColor(backgroundColor);     
        g.fillOval(2, 2, 16, 16);          
        if (state == NORMAL) {
            g.setColor(borderColor);  
            g.fillOval(6, 6, 8, 8);
        } else if (state == PRESSED) {
            g.setColor(rollOverColor);  
            g.fillOval(6, 6, 8, 8);
        } else {
            g.setColor(rollOverColor);  
            g.fillOval(6, 6, 8, 8);
        }
        g.setColor(centerColor);        
        g.drawOval(6, 6, 8, 8);
    }		
	    
}
