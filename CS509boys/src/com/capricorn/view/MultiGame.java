package com.capricorn.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.capricorn.RequestController.ClickButton_multiGame;
import com.capricorn.RequestController.Exit;
import com.capricorn.RequestController.LockGameRequest;
import com.capricorn.RequestController.RepositionBoardRequest;
import com.capricorn.entity.Player;
import com.capricorn.model.Model;

public class MultiGame extends JFrame {
	public JTextField textField_word;
	public JTextField textField_escore;
	private Model model;
	private JTable table;
	private List<JButton> chosenbtns;
	private List<JButton> allCellsbtns;
	public int sum;
	private JPanel panel;
	private Application app;
	public JLabel message;
	private JTextField textField_name;
	private JTextField textField_gameId;
	private JTextField textField_manager;
	private JTextField textField_score;

	public MultiGame(Model m, Application app) {
		this.app = app;
		this.model = m;
		textField_name=app.getName_id_text();
		textField_gameId=app.getCreate_id_text();
		

		getContentPane().setLayout(null);
		chosenbtns = new ArrayList<JButton>();
		allCellsbtns = new ArrayList<JButton>();

		setSize(820, 700); // set ManagerGame size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		setTitle("Your Game");
		getContentPane().setLayout(null);

		textField_word = new JTextField();
		textField_word.setBounds(603, 65, 192, 22);
		getContentPane().add(textField_word);
		textField_word.setColumns(10);
		textField_word.setEditable(false);

		JLabel lblYourWord = new JLabel("Your Word :");
		lblYourWord.setBounds(516, 66, 85, 20);
		getContentPane().add(lblYourWord);

		JLabel lblYourScore = new JLabel("Expected Word Score :");
		lblYourScore.setBounds(444, 98, 147, 16);
		getContentPane().add(lblYourScore);

		textField_escore = new JTextField();
		textField_escore.setColumns(10);
		textField_escore.setBounds(603, 92, 192, 28);
		getContentPane().add(textField_escore);
		textField_escore.setText("0");
		textField_escore.setEditable(false);
		

		JButton button = new JButton("UP");
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		button.addActionListener(new ActionListener() {
			int previousRow;
			int newRow;

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] change={-1,0};
				clearAllChosen();
				previousRow = model.getBoard().getGlobalStartingRow();
				model.getBoard().setRequestColChange(1);
				new RepositionBoardRequest(model,MultiGame.this.app,change).process();
				refreshBoard();
				newRow = model.getBoard().getGlobalStartingRow();
				if (previousRow == newRow) {
					message.setText("No More Up!");
				}
			}

			
				
			
		});
		button.setToolTipText("");
		button.setBounds(641, 163, 69, 38);
		getContentPane().add(button);

		JButton button_1 = new JButton("LEFT");
		button_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		button_1.setBounds(555, 197, 75, 38);
		getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			int previousCol;
			int newCol;

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] change={0,-1};
				clearAllChosen();
				previousCol = model.getBoard().getGlobalStartingCol();
				model.getBoard().setRequestColChange(1);
				new RepositionBoardRequest(model,MultiGame.this.app,change).process();
				refreshBoard();
				newCol = model.getBoard().getGlobalStartingCol();
				if (previousCol == newCol) {
					message.setText("No More Left!");
				}
			}

			
				
			
		});

		JButton button_2 = new JButton("RIGHT");
		button_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		button_2.setBounds(716, 197, 75, 38);
		button_2.addActionListener(new ActionListener() {
			int previousCol;
			int newCol;

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] change={0,1};
				clearAllChosen();
				previousCol = model.getBoard().getGlobalStartingCol();
				model.getBoard().setRequestColChange(1);
				new RepositionBoardRequest(model,MultiGame.this.app,change).process();
				refreshBoard();
				newCol = model.getBoard().getGlobalStartingCol();
				if (previousCol == newCol) {
					message.setText("No More Right!");
				}
			}

			
				
			
		});
		getContentPane().add(button_2);

		JButton button_3 = new JButton("DOWN");
		button_3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		button_3.setBounds(641, 231, 69, 38);
		getContentPane().add(button_3);
		button_3.addActionListener(new ActionListener() {
			int previousRow;
			int newRow;

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] change={1,0};
				clearAllChosen();
				previousRow = model.getBoard().getGlobalStartingRow();
				model.getBoard().setRequestColChange(1);
				new RepositionBoardRequest(model,MultiGame.this.app,change).process();
				refreshBoard();
				newRow = model.getBoard().getGlobalStartingRow();
				if (previousRow == newRow) {
					message.setText("No More Down!");
				}
			}

			
				
			
		});

		JButton button_4 = new JButton("Submit");
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(472, 13, 147, 40);
		getContentPane().add(button_4);

		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		
		Exit exitControl = new Exit(this, model);
		btnExit.addActionListener(exitControl);
		btnExit.setBounds(625, 14, 69, 38);
		getContentPane().add(btnExit);

		JButton btnLock = new JButton("Lock");
		if (m.getGame().isLocked) {
			btnLock.setEnabled(false);
		} else {
			btnLock.setEnabled(true);
		}

		btnLock.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new LockGameRequest(model, MultiGame.this.app).process();
				JButton button = (JButton) e.getSource();
				button.setEnabled(false);

			}
		});
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
		scrollPane.setBounds(158, 239, 390, 197);
		getContentPane().add(scrollPane);
		table = new JTable();

		scrollPane.setViewportView(table);
		table.setBounds(200, 238, 402, 234);

		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(6, 45, 426, 179);
		getContentPane().add(panel);
		panel.setBorder(new CompoundBorder()); 

		 panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		 
		 JLabel lblNewLabel = new JLabel("      Your Game Board");
		 lblNewLabel.setBounds(114, 6, 285, 22);
		 panel.add(lblNewLabel);

		message = new JLabel("Message");
		message.setBounds(573, 281, 222, 195);
		getContentPane().add(message);
		message.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null)); 
		message.setBorder(BorderFactory.createLineBorder(Color.gray));
		message.setForeground(Color.red);
		

		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(Color.CYAN);
		btnClear.setBounds(706, 13, 89, 38);
		getContentPane().add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearAllChosen();
				
			}
		});

		JLabel lblYourName = new JLabel("Your Name:");
		lblYourName.setBounds(158, 509, 83, 23);
		getContentPane().add(lblYourName);

		JLabel lblGameId = new JLabel("Game ID:");
		lblGameId.setBounds(168, 454, 89, 27);
		getContentPane().add(lblGameId);

		textField_name = new JTextField();
		textField_name.setBounds(242, 503, 134, 35);
		getContentPane().add(textField_name);
		textField_name.setColumns(10);
		textField_name.setEditable(false);

		textField_gameId = new JTextField();
		textField_gameId.setBounds(242, 451, 141, 33);
		getContentPane().add(textField_gameId);
		textField_gameId.setColumns(10);
		textField_gameId.setEditable(false);
		
		textField_manager = new JTextField();
		textField_manager.setBounds(242, 562, 134, 38);
		getContentPane().add(textField_manager);
		textField_manager.setColumns(10);
		textField_manager.setEditable(false);
		JLabel lblManagerName = new JLabel("Manager Name:");
		lblManagerName.setBounds(127, 568, 103, 16);
		getContentPane().add(lblManagerName);
		
		textField_score = new JTextField();
		textField_score.setText("0");
		textField_score.setBounds(603, 120, 192, 28);
		getContentPane().add(textField_score);
		textField_score.setColumns(10);
		textField_score.setEditable(false);
		JLabel lblYourScore_1 = new JLabel("Your Score:");
		lblYourScore_1.setBounds(516, 126, 85, 16);
		getContentPane().add(lblYourScore_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(586, 273, 89, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setBounds(579, 286, 61, 16);
		getContentPane().add(lblMessage);
		
		
		setallCellsbtns();

		refreshBoard();
		resetInfo();

	}

	private void setLockEnable() {
		// TODO Auto-generated method stub

	}

	public void setScoreTable() {
		table.setModel(new DefaultTableModel(convertPlayersListToArray(),
				new String[] { "Player Name", "Player Score", "Position", "Rank" }));
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

	public Object[][] convertPlayersListToArray() {
		List playersList = model.getGame().getPlayersListByScore();
		Object[][] objAy = new Object[playersList.size()][4];
		for (int i = 0; i < objAy.length; i++) {

			Player p = (Player) playersList.get(i);
			objAy[i][0] = p.getName();
			objAy[i][1] = p.getScore();
			objAy[i][2] = p.getPosition();
			objAy[i][3] = "No." + (i + 1);

		}
		return objAy;
	}

	public List<JButton> getChosenbtns() {
		return this.chosenbtns;
	}

	public void setChosenbtns(JButton btn) {
		chosenbtns.add(btn);
	}

	public void setallCellsbtns() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x = 25 + j * 100;
				int y = 40 + i * 35;
				JButton btn = new JButton();
				btn.setBounds(x, y, 89, 23);
				btn.setToolTipText(model.board.cells[i][j].getPoints());
				allCellsbtns.add(btn);
				ClickButton_multiGame clickControl = new ClickButton_multiGame(this);
				btn.addActionListener(clickControl);
                btn.setBackground(Color.WHITE);
				panel.add(btn);

			}
		}
	}

	public void refreshBoard() {
		String letter = "ABCDEFGHIJKLMNOPRSTUVWXYZQ";
		String[] points = {"2","4","3","3","1","4","4","2","2","7","5","3","3","2","2","4","2","2","1","3","5","3","7","4","8","11"};
		char[] LettersToBeAdd = this.model.getBoard().getBoardInfo().toCharArray();
		System.out.println(this.model.getBoard().getBoardInfo());
		for (int i = 0; i < 16; i++) {
			String lettToBeAdd = String.valueOf(LettersToBeAdd[i]);
			
			this.allCellsbtns.get(i).setToolTipText(points[letter.indexOf(lettToBeAdd)]);
			if (lettToBeAdd.equals("Q")) {
				lettToBeAdd = "Qu";
			}
			this.allCellsbtns.get(i).setText(lettToBeAdd);
		}

		setScoreTable();
		clearAllChosen();
		panel.repaint();

	}

	private void removeCellBtnsColors() {
		for (int i = 0; i < 16; i++) {
			JButton btn = this.allCellsbtns.get(i);
			
			btn.setForeground(Color.BLACK);
			btn.setBackground(Color.WHITE);
		}
		panel.repaint();
	}

	private void clearAllChosen() {
		textField_word.setText("");
		textField_escore.setText("0");
		message.setText("");
		this.chosenbtns.removeAll(chosenbtns);
		model.getBoard().clearChosenCells();
		removeCellBtnsColors();
		for (JButton btn : allCellsbtns) {
			btn.setEnabled(true);
		}
	}
	private void resetInfo() {
		textField_name.setText(model.getPlayer().getName());
		textField_gameId.setText(model.getGame().getGameId());
		textField_score.setText(String.valueOf(model.getPlayer().getScore()));
		if(model.getGame().getManagingUser().equals(model.getPlayer().getName())){
			textField_manager.setText("Manager is You");
		}
		else{
		textField_manager.setText(model.getGame().getManagingUser());
		}
	}
}
