package com.capricorn.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.capricorn.RequestController.Exit;
import com.capricorn.entity.Game;
import com.capricorn.model.Model;

public class GuestGame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	Model model;
	private  HashMap sortByComparator(HashMap unsortMap) { 
        List list = new LinkedList(unsortMap.entrySet()); 
        // sort list based on comparator
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                                       .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        // put sorted list into map again
                //LinkedHashMap make sure order in which keys were inserted
        HashMap sortedMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    
	private Object[][] convertListToHashMap(HashMap<String, Long> pi){
		Object[][] objAy = new Object[pi.size()][3] ;
		int i =0;
		int j =0;
		int k=0;
		for (String key : pi.keySet()) { 
			
		
			objAy[i][0]= key;
  
		    i+=1;
		}  		  		 		  
		for (Long value : pi.values()) {  
			objAy[j][1]= value;
		    j+=1;  
		  
		}
		while(k<pi.size()){
			objAy[k][2]=pi.size()-k;
			k = k+1;
		}
		
			return objAy;
		}
		
	public void refresh(){
//		Game game = model.getGame();
		HashMap<String, Long> pi = this.sortByComparator(model.getGame().getPlayerInformation());
//		this.sortByComparator(pi);

//		int count = pi.size();
		JTable jt = new JTable();
		Object[][] objHM = convertListToHashMap(pi) ;
		jt.setModel(new DefaultTableModel(objHM,new String[] {
				"Name", "Score", "Rank" 
				
		
			}));
		
	
		
	}
	//

	public GuestGame(Model model) {
		this.model=model;
		setTitle("Your Game");
		getContentPane().setLayout(null);
		

		textField = new JTextField();
		textField.setBounds(132, 21, 192, 22);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Your Word :");
		lblNewLabel.setBounds(35, 22, 85, 20);
		getContentPane().add(lblNewLabel);

		JButton btnK = new JButton("k");
		btnK.setBounds(136, 89, 89, 23);
		getContentPane().add(btnK);

		JButton btnO = new JButton("o");
		btnO.setBounds(235, 89, 89, 23);
		getContentPane().add(btnO);

		JButton btnL_2 = new JButton("l");
		btnL_2.setBounds(37, 123, 89, 23);
		getContentPane().add(btnL_2);

		JButton btnO_3 = new JButton("o");
		btnO_3.setBounds(136, 123, 89, 23);
		getContentPane().add(btnO_3);

		JButton btnW = new JButton("w");
		btnW.setBounds(235, 123, 89, 23);
		getContentPane().add(btnW);

		JButton btnO_2 = new JButton("o");
		btnO_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnO_2.setBounds(37, 157, 89, 23);
		getContentPane().add(btnO_2);

		JButton btnA = new JButton("a");
		btnA.setBounds(136, 157, 89, 23);
		getContentPane().add(btnA);

		JButton btnN = new JButton("n");
		btnN.setBounds(235, 157, 89, 23);
		getContentPane().add(btnN);

		JButton btnE = new JButton("e");
		btnE.setBounds(37, 191, 89, 23);
		getContentPane().add(btnE);

		JButton btnS_1 = new JButton("s");
		btnS_1.setBounds(136, 191, 89, 23);
		getContentPane().add(btnS_1);

		JButton btnO_1 = new JButton("o");
		btnO_1.setBounds(235, 191, 89, 23);
		getContentPane().add(btnO_1);

		JButton btnA_2 = new JButton("a");
		btnA_2.setBounds(334, 157, 89, 23);
		getContentPane().add(btnA_2);

		JButton btnD = new JButton("d");
		btnD.setBounds(334, 191, 89, 23);
		getContentPane().add(btnD);

		JButton btnS_2 = new JButton("s");
		btnS_2.setBounds(334, 123, 89, 23);
		getContentPane().add(btnS_2);

		JButton btnA_1 = new JButton("a");
		btnA_1.setBounds(334, 89, 89, 23);
		getContentPane().add(btnA_1);

		JLabel label = new JLabel("Score :");
		label.setBounds(66, 54, 61, 16);
		getContentPane().add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 48, 134, 28);
		getContentPane().add(textField_1);

		JButton button = new JButton("UP");
		button.setToolTipText("");
		button.setBounds(496, 142, 53, 38);
		getContentPane().add(button);

		JButton button_1 = new JButton("LEFT");
		button_1.setBounds(444, 157, 53, 38);
		getContentPane().add(button_1);

		JButton button_2 = new JButton("RIGHT");
		button_2.setBounds(548, 157, 53, 38);
		getContentPane().add(button_2);

		JButton button_3 = new JButton("DOWN");
		button_3.setBounds(496, 176, 53, 38);
		getContentPane().add(button_3);

		JButton button_4 = new JButton("Submit");
		button_4.setBounds(336, 13, 147, 40);
		getContentPane().add(button_4);

		JButton btnExit = new JButton("Exit");
		Exit exitControl = new Exit(this);
		btnExit.addActionListener(exitControl);
		btnExit.setBounds(511, 14, 69, 38);
		getContentPane().add(btnExit);
//refresh function here
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(211, 237, 390, 199);
		getContentPane().add(textPane);

		JLabel lblScoreRanking = new JLabel("Score Ranking :");
		lblScoreRanking.setBounds(98, 237, 101, 16);
		getContentPane().add(lblScoreRanking);

		JButton button_6 = new JButton("k");
		button_6.setBounds(37, 89, 89, 23);
		getContentPane().add(button_6);
	}
}
