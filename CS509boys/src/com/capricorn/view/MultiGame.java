package com.capricorn.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.capricorn.RequestController.ClickButton_multiGame;
import com.capricorn.RequestController.Exit;
import com.capricorn.entity.Player;
import com.capricorn.model.Model;

public class MultiGame extends JFrame {
	public JTextField textField_word;
	public JTextField textField_score;
	private Model model;
	private JTable table;
	private List<JButton> chosenbtns;
	private List<JButton> allCellsbtns;
	public int sum;
	JPanel panel;
	
	
	public JLabel message;
	
	
	public MultiGame(Model m) {
		
		this.model=m;
		
		
		
		getContentPane().setLayout(null);
		chosenbtns=new ArrayList<JButton>();
		allCellsbtns=new ArrayList<JButton>(); 
		

		setSize(820, 700); // set ManagerGame size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setTitle("Your Game");
		getContentPane().setLayout(null);

		JButton btnNewButton_1 = new JButton("Unlock");
		btnNewButton_1.setBounds(35, 413, 89, 23);
		getContentPane().add(btnNewButton_1);

		textField_word = new JTextField();
		textField_word.setBounds(132, 21, 192, 22);
		getContentPane().add(textField_word);
		textField_word.setColumns(10);

		JLabel lblNewLabel = new JLabel("Your Word :");
		lblNewLabel.setBounds(35, 22, 85, 20);
		getContentPane().add(lblNewLabel);

		

		JLabel label = new JLabel("Score :");
		label.setBounds(66, 54, 61, 16);
		getContentPane().add(label);

		textField_score = new JTextField();
		textField_score.setColumns(10);
		textField_score.setBounds(130, 48, 134, 28);
		getContentPane().add(textField_score);
		textField_score.setText("0");

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
		button_4.setBackground(Color.WHITE);
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

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(158, 239, 428, 197);
		getContentPane().add(scrollPane);
		table = new JTable();
		
		
		scrollPane.setViewportView(table);
		table.setBounds(200, 238, 402, 234);
		
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		
		panel.setBounds(30, 74, 398, 161);
		getContentPane().add(panel);
		
		message = new JLabel("Message");
		message.setBounds(446, 54, 280, 76);
		getContentPane().add(message);
		
		
		
		refreshBoard();
		
		
	}
	
	public void setScoreTable(){
		table.setModel(new DefaultTableModel(
			convertPlayersListToArray(),
			new String[] {
				"Player Name", "Player Score", "Rank"
			}
			));
	}

	
		


		public Model getModel() {
		return model;
	}


	public void setModel(Model model) {
		this.model = model;
	}


		public List<JButton> getAllCellsbtns() {
		return allCellsbtns;
	}


	public void setAllCellsbtns(List<JButton> allCellsbtns) {
		this.allCellsbtns = allCellsbtns;
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
		public List<JButton> getChosenbtns(){
			return this.chosenbtns;
		}
		public void setChosenbtns(JButton btn){
			chosenbtns.add(btn);
		}
		public void setallCellsbtns(){
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					
					JButton btn = new JButton(model.getBoard().getCells()[i][j].getLetter());
					btn.setToolTipText(model.board.cells[i][j].getPoints());
					allCellsbtns.add(btn);
					ClickButton_multiGame clickControl =new ClickButton_multiGame(this);
					btn.addActionListener(clickControl);
					
					panel.add(btn);
					
				}
			}
		}
		public void refreshBoard(){
			setallCellsbtns();
			setScoreTable();
			
			
			
		}
}
		

	
		
		
		
	

