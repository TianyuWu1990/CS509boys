package com.capricorn.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import com.capricorn.RequestController.Lock;
import com.capricorn.RequestController.LockGameRequest;
import com.capricorn.entity.Game;
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
	Application app;
	public JLabel message;
	private JTextField textField_name;
	private JTextField textField_gameId;

	public MultiGame(Model m) {

		this.model = m;

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

		JLabel lblYourScore = new JLabel("Your Score :");
		lblYourScore.setBounds(516, 98, 75, 16);
		getContentPane().add(lblYourScore);

		textField_score = new JTextField();
		textField_score.setColumns(10);
		textField_score.setBounds(603, 92, 192, 28);
		getContentPane().add(textField_score);
		textField_score.setText("0");
		textField_score.setEditable(false);

		JButton button = new JButton("UP");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setToolTipText("");
		button.setBounds(516, 149, 75, 28);
		getContentPane().add(button);

		JButton button_1 = new JButton("LEFT");
		button_1.setBounds(444, 157, 75, 38);
		getContentPane().add(button_1);

		JButton button_2 = new JButton("RIGHT");
		button_2.setBounds(591, 157, 75, 38);
		getContentPane().add(button_2);

		JButton button_3 = new JButton("DOWN");
		button_3.setBounds(516, 178, 75, 28);
		getContentPane().add(button_3);

		JButton button_4 = new JButton("Submit");
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(472, 13, 147, 40);
		getContentPane().add(button_4);

		JButton btnExit = new JButton("Exit");
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
		Lock lockcontroller = new Lock(app, m);
		btnLock.addActionListener(lockcontroller);
		btnLock.setBounds(35, 378, 89, 23);
		getContentPane().add(btnLock);

		// JButton btnNewButton_1 = new JButton("Unlock");
		// if (m.getGame().isLocked) {
		// btnLock.setEnabled(true);
		// } else {
		// btnNewButton_1.setEnabled(false);
		// }
		// btnNewButton_1.setBounds(35, 413, 89, 23);
		// getContentPane().add(btnNewButton_1);

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
		panel.setBounds(0, 47, 432, 178);
		getContentPane().add(panel);

		message = new JLabel("Message");
		message.setBounds(573, 241, 222, 195);
		getContentPane().add(message);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(706, 13, 89, 35);
		getContentPane().add(btnClear);

		JLabel lblYourName = new JLabel("Your Name:");
		lblYourName.setBounds(19, 21, 83, 23);
		getContentPane().add(lblYourName);

		JLabel lblGameId = new JLabel("Game ID:");
		lblGameId.setBounds(245, 19, 89, 27);
		getContentPane().add(lblGameId);

		textField_name = new JTextField();
		textField_name.setBounds(99, 13, 134, 35);
		getContentPane().add(textField_name);
		textField_name.setColumns(10);
		textField_name.setEditable(false);

		textField_gameId = new JTextField();
		textField_gameId.setBounds(305, 13, 141, 33);
		getContentPane().add(textField_gameId);
		textField_gameId.setColumns(10);
		textField_gameId.setEditable(false);
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearAllChosen();
				for (JButton btn : allCellsbtns) {
					btn.setEnabled(true);
				}
			}
		});
		setallCellsbtns();

		refreshBoard();

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
				int x = 30 + i * 100;
				int y = 40 + j * 35;
				JButton btn = new JButton();
				btn.setBounds(x, y, 89, 23);
				btn.setToolTipText(model.board.cells[i][j].getPoints());
				allCellsbtns.add(btn);
				ClickButton_multiGame clickControl = new ClickButton_multiGame(this);
				btn.addActionListener(clickControl);

				panel.add(btn);

			}
		}
	}

	public void refreshBoard() {
		char[] LettersToBeAdd = this.model.getBoard().getBoardInfo().toCharArray();
		for (int i = 0; i < 16; i++) {
			String lettToBeAdd = String.valueOf(LettersToBeAdd[i]);
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
			Component c = this.panel.getComponent(i);
			c.setForeground(Color.BLACK);
		}
		panel.repaint();
	}

	private void clearAllChosen() {
		textField_word.setText("");
		textField_score.setText("0");
		message.setText("");
		this.chosenbtns.removeAll(chosenbtns);
		model.getBoard().clearChosenCells();
		removeCellBtnsColors();
	}
}
