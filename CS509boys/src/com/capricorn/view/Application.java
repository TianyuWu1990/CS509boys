package com.capricorn.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.capricorn.RequestController.CreateGameRequest;
import com.capricorn.RequestController.JoinGameRequest;
import com.capricorn.client.ServerAccess;
import com.capricorn.entity.*;
import com.capricorn.listener.StartPractice;
/**Application is the entrance to the game, containing practice game and multiple game.
 * This is designed by JFrame with text filed and button.
 * @author Chen Li, Yu Li
 */
public class Application extends JFrame {
	public JTextField create_id_text;
	public JTextField name_id_text;
	private JTextField create_pass_text;
	public Model model;
	public String playerName;
	public String gameNumber;
	public String passWord;
	public JButton btnStart;
	public JButton btnJoin;
	public JButton btnExit;
	public JButton btnPractice;
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.create_pass_text.setText(passWord); 
	}
	private MultiGame mg;
	static Application app;
	private JLabel lbl_GameId;
	private JLabel lbl_Player;
	private XmlInfoBoard xmlb;
	private boolean startGame;	
	/**
	 * method if the game is start
	 * @return startGae
	 */
	public boolean isStartGame() {
		return startGame;
	}

/**
 * set the game 
 * @param startGame
 * @return void 
 */
	public void setStartGame(boolean startGame) {
		this.startGame = startGame;
	}
	ServerAccess serverAccess ;
	public static Application getInstance(Model model) {
		if (app == null) {
			app = new Application(model);
		}
		
		return app;
	}
	
	

	public ServerAccess getServerAccess() {
		return serverAccess;
	}

	public void setServerAccess(ServerAccess serverAccess) {
		this.serverAccess = serverAccess;
	}
	public MultiGame getMg() {
		return mg;
	}

	public void setMg(MultiGame mg) {
		this.mg = mg;
	}

	
	/**Identify the existence of the  game name.*/
	public boolean notHasPlayerName(){
		playerName = name_id_text.getText();
		if(playerName.length() == 0){
			JOptionPane.showMessageDialog(Application.this, "playerName can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
			name_id_text.requestFocus();
			return true;
		}
		return false;
	}
	/**Identify the existence of the game name and game ID. */
	public boolean notHasPlayerNameAndGameId(){			
		gameNumber = create_id_text.getText();
		playerName = name_id_text.getText();
		if(gameNumber.length() == 0){
			JOptionPane.showMessageDialog(Application.this, "gameID can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
			create_id_text.requestFocus();
			return true;
		}else if(playerName.length() == 0){
			JOptionPane.showMessageDialog(Application.this, "playerName can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
			name_id_text.requestFocus();
			return true;
		}
		return false;
	}			
		
	public String getPlayerName() {
		return playerName;
	}



	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}



	public void setGameNumber(String gameNumber) {
		this.gameNumber = gameNumber;
	}



	public String getPassword() {
		return create_pass_text.getText();
	}
	
    
	
	public String getGameNumber() {
		return gameNumber;
	}
	

	public MultiGame getManagerg() {
		return mg;
	}


	public Application(Model m) {
        this.model=m;
		setSize(600, 300);
		setTitle("WordSweeper");
		getContentPane().setLayout(null);
		xmlb=new XmlInfoBoard();
		xmlb.setVisible(true);

		btnStart = new JButton("Create a game");
		/** Realizing create a game button by applying Create game Request.*/
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!notHasPlayerName()){	
				new CreateGameRequest(Application.this, model).process();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mg = new MultiGame(model,app);
				mg.setSize(1200, 900); 
				mg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mg.setVisible(true);
				dispose();
				
			}
			}
		});
		btnStart.setBounds(305, 186, 149, 58);
		getContentPane().add(btnStart);

		btnJoin = new JButton("Join a game");
		/**Realizing join a game button.*/
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!notHasPlayerNameAndGameId()){
					new JoinGameRequest(model, Application.this).process();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
					if(!startGame){
						JOptionPane.showMessageDialog(Application.this, "This Game Has Been Locked or The Password Is Not Right or Your name has Been Used", "Warning", JOptionPane.WARNING_MESSAGE);
					}
					else{
					mg = new MultiGame(model,app);
					mg.setSize(1200, 900); 
					mg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					mg.setVisible(true);
					dispose();
					}
				
				}
			}
		});
		btnJoin.setBounds(157, 186, 149, 58);
		getContentPane().add(btnJoin);
		
		btnPractice = new JButton("Practice mode");

		StartPractice StartPracticeControl= new StartPractice(this,model);
		
		btnPractice.addActionListener(StartPracticeControl);
		btnPractice.setBounds(6, 186, 149, 58);
		getContentPane().add(btnPractice);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
		});
		btnExit.setBounds(460, 186, 134, 58);
		getContentPane().add(btnExit);

		create_id_text = new JTextField();
		create_id_text.setBounds(226, 33, 134, 28);
		getContentPane().add(create_id_text);
		create_id_text.setColumns(10);

		lbl_GameId = new JLabel("Game ID");
		lbl_GameId.setBounds(122, 39, 96, 16);
		getContentPane().add(lbl_GameId);

		name_id_text = new JTextField();
		name_id_text.setBounds(226, 96, 134, 28);
		getContentPane().add(name_id_text);
		name_id_text.setColumns(10);

		lbl_Player = new JLabel("Player Name");
		lbl_Player.setBounds(122, 102, 98, 16);
		getContentPane().add(lbl_Player);

		create_pass_text = new JTextField();
		create_pass_text.setBounds(226, 63, 134, 28);
		getContentPane().add(create_pass_text);
		create_pass_text.setColumns(10);

		JLabel lblPasswordOptional = new JLabel("Password ( Optional )");
		lblPasswordOptional.setBounds(81, 69, 137, 16);
		getContentPane().add(lblPasswordOptional);
	}



	public XmlInfoBoard getXmlb() {
		return xmlb;
	}



	
}
