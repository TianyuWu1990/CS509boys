package com.capricorn.view;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**build the new class extend DefaultTableModel*/
public class MyTableModel extends DefaultTableModel {
	/**override construct*/
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
