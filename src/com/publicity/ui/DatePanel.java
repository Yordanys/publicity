package com.publicity.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Yordanys Pupo Diéguez
 * @version 1.0
 * Esta clase sirve para crear el calendario que se usara en las fechas.
 * de la implementación. 
 * Fecha de creación: 10/04/2013
 */
public final class DatePanel extends JPanel{
   
    private String[] weekDays;
    
    private Map<String, Integer> monthMap = new LinkedHashMap<String, Integer>(12);
    private Calendar toDayCalendar = new GregorianCalendar();
    private Calendar calendar;
    
    private JPanel datePanel  = new JPanel();
    private JPanel daysPanel = new JPanel(new GridLayout(7, 7));          
    private JButton daysButton[][];        
    
    private JSpinner monthSpinner = new JSpinner();    
    private JSpinner yearSpinner = new JSpinner();
        		
    public DatePanel(){
        loadInfo();             
        calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        createCalendar();
        setSize(210, 210);
    }
	
    private void loadInfo() { 
        String [] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        for (int i = 0; i < months.length ; i++) 
            monthMap.put(months[i], i);
        weekDays = new String[]{"Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"};        
    }
    				
    private void createCalendar(){
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new BorderLayout());
        
        addDatePanel();        
        add(BorderLayout.NORTH, datePanel); 
        
        addWeekDay();                
        addDayMonth();
        add(BorderLayout.CENTER, daysPanel);
                
        generateButton();
    }
		
    private void generateButton() {        
        int monthDay = calendar.get(Calendar.MONTH);
        Calendar temp = new GregorianCalendar(calendar.get(Calendar.YEAR), monthDay, calendar.get(calendar.DAY_OF_MONTH));        
        int firstDay = new GregorianCalendar(calendar.get(Calendar.YEAR) , monthDay, 1).get(Calendar.DAY_OF_WEEK) - 1;	
                
        for (int i = 0; i < firstDay; i++) {
             daysButton[0][i].setText("");             
             daysButton[0][i].setVisible(false);
        }
        
        int toDay = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        if (dateFormat.format(temp.getTime()).equals(dateFormat.format(toDayCalendar.getTime()))) {
            toDay = toDayCalendar.get(Calendar.DAY_OF_MONTH);
        }
              
        int row = 0;
        int column = 0;
        JButton day = null;       
        int numbersDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + 1; 
        for (int i = 1; i < numbersDay; i++) {
            row = ((firstDay + i - 1) / 7);
            column = ((firstDay + i - 1) % 7) ;
            day = daysButton[row][column];
            day.setText(Integer.toString(i));            
            day.setVisible(true);
            if (toDay != 0 && i == toDay) 
                day.setBackground(new Color(120, 200, 250));	                            
            else 
                day.setBackground(new Color(200, 230, 250));
            if (column == 0)
                day.setForeground(Color.red);
        }
	
        for (int i = row; i < 6; i++) {
            if (i == row) {
                for (int j = column + 1; j < 7; j++){
                    daysButton[i][j].setText("");                            
                    daysButton[i][j].setVisible(false);
                }
            } else {
                for(int j = 0; j < 7; j++){                            
                    daysButton[i][j].setText(""); 
                    daysButton[i][j].setVisible(false);
                }
            }       
        }
        repaint();
    }
                
    private void addDatePanel() {          
        monthSpinner.setPreferredSize(new Dimension(110, 20));
        String [] months = monthMap.keySet().toArray(new String[0]);
        monthSpinner.setModel(new SpinnerListModel(months));
        monthSpinner.setValue(months[toDayCalendar.get(Calendar.MONTH)]);
        ((JSpinner.DefaultEditor) monthSpinner.getEditor()).getTextField().setEditable(false);
        monthSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {    
                calendar.set(calendar.get(Calendar.YEAR),  monthMap.get((String)monthSpinner.getValue()), calendar.get(Calendar.DAY_OF_MONTH));
                generateButton();
            }
        });
        datePanel.add(monthSpinner);

        yearSpinner.setPreferredSize(new Dimension(65, 20));        
        yearSpinner.setModel(new SpinnerNumberModel((int)toDayCalendar.get(Calendar.YEAR), (int)2000, toDayCalendar.get(Calendar.YEAR), (int)1));
        yearSpinner.setEditor(new JSpinner.NumberEditor(yearSpinner, "#"));
        ((JSpinner.DefaultEditor) yearSpinner.getEditor()).getTextField().setEditable(false);
        yearSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                calendar.set((Integer)yearSpinner.getValue(), monthMap.get((String)monthSpinner.getValue()), calendar.get(Calendar.DAY_OF_MONTH));                
                generateButton();                            
            }
        });
        datePanel.add(yearSpinner);           
    }
    
    private void addWeekDay() {                               
        for (int i = 0, n = weekDays.length; i < n; i++) {            
            JButton dayButton = new JButton(weekDays[i]);
            dayButton.setBorderPainted(false);
            dayButton.setBorder(BorderFactory.createCompoundBorder());            
            dayButton.setBackground(new Color(200, 200, 200));
            if (i == 0)
                dayButton.setForeground(Color.RED);
            else 
                dayButton.setForeground(Color.BLUE);
            daysPanel.add(dayButton);              
        }       
    }
    
    private void addDayMonth() {
        daysButton = new JButton[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) { 
                daysPanel.add(daysButton[i][j] = new JButton(""));
                daysButton[i][j].addActionListener(dateSetter);                
                daysButton[i][j].setBorder(BorderFactory.createCompoundBorder());
            }	
        }
    }
            
    private ActionListener dateSetter = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JButton day = (JButton)e.getSource();
            if (day.isVisible()) {               
                Calendar temp = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), Integer.parseInt(day.getText()));
                getParent().firePropertyChange("date", 0, temp.getTimeInMillis());
            }
        }
    };
    
    public String getDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
    }
    
}
