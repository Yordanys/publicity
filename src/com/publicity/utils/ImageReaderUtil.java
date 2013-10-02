/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicity.utils;

import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrador
 */
public class ImageReaderUtil {
    
    private static final String RESOURCES_PATH = "com/publicity/resources/";
    
    public static Icon loadImageIcon(String path) throws IOException { 
        return new ImageIcon(RESOURCES_PATH + path);
    }
    
}
