package com.capricorn.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.capricorn.RequestController.Exit;
import com.capricorn.entity.Player;
import com.capricorn.model.Model;

public class MultiGame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	Model model;
	private JTable table;

	public MultiGame(Model m) {
		this.model=m;
		
		setSize(620, 500); // set ManagerGame size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setTitle("Your Game");
		getContentPane().setLayout(null);

		JButton btnNewButton_1 = new JButton("Unlock");
		btnNewButton_1.setBounds(35, 413, 89, 23);
		getContentPane().add(btnNewButton_1);

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
		Exit exitControl = new Exit(this,model);
		btnExit.addActionListener(exitControl);
		btnExit.setBounds(511, 14, 69, 38);
		getContentPane().add(btnExit);

		JButton btnLock = new JButton("Lock");
		btnLock.setBounds(35, 378, 89, 23);
		getContentPane().add(btnLock);

		JButton button_5 = new JButton("Reset Board");
		button_5.setBounds(35, 343, 111, 23);
		getContentPane().add(button_5);

		JLabel lblScoreRanking = new JLabel("Score Ranking :");
		lblScoreRanking.setBounds(42, 240, 101, 16);
		getContentPane().add(lblScoreRanking);

		JLabel lblManagerPanel = new JLabel("Manager Control");
		lblManagerPanel.setBounds(42, 315, 126, 16);
		getContentPane().add(lblManagerPanel);

		JButton button_6 = new JButton("k");
		button_6.setBounds(37, 89, 89, 23);
		getContentPane().add(button_6);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(158, 239, 428, 197);
		getContentPane().add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(
				convertPlayersListToArray(),
				new String[] {
					"Player Name", "Player Score", "Rank"
				}
				));
		scrollPane.setViewportView(table);
		table.setBounds(200, 238, 402, 234);
	
		
	}

	
		public Object[][] convertPlayersListToArray(){
			List playersList=model.getGame().getPlayersListByScore();
			Object[][] objAy = new Object[playersList.size()][3] ;
			for (int i=0;i<objAy.length;i++){
				
			
				Player p = (Player)playersList.get(i);  
				objAy[i][0] = p.getName() ;
				objAy[i][1] = p.getScore();
				objAy[i][2] = "No."+(i+1);
				
			
			
		}
			return objAy; 
		}
		
		
		
		
	}

