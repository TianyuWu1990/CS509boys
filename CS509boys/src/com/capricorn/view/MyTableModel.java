package com.capricorn.view;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
	MyTableModel(Object[][] data, String[] columnNames) {
	        super(data, columnNames);
	    }
 @Override
    public boolean isCellEditable(int row, int column){  
        return false;  
    }

	
}
