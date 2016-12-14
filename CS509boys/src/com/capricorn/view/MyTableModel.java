package com.capricorn.view;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**Model the table and make cell in the table can not be editable*/
public class MyTableModel extends DefaultTableModel {
	MyTableModel(Object[][] data, String[] columnNames) {
	        super(data, columnNames);
	    }
	/**Override the method isCelleditable 
	 * And return false
	 */
 @Override
    public boolean isCellEditable(int row, int column){  
        return false;  
    }

	
}
