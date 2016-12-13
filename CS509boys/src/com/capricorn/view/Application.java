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
// TODO: Auto-generated Javadoc
/**Application is the entrance to the game, containing practice game and multiple game.
 * This is designed by JFrame with text filed and button.
 * @author Chen Li, Yu Li
 */
public class Application extends JFrame {
	
	/** The create id text. */
	public JTextField create_id_text;
	
	/** The name id text. */
	public JTextField name_id_text;
	
	/** The create pass text. */
	private JTextField create_pass_text;
	
	/** The model. */
	public Model model;
	
	/** The player name. */
	public String playerName;
	
	/** The game number. */
	public String gameNumber;
	
	/** The pass word. */
	public String passWord;
	
	/** The btn start. */
	public JButton btnStart;
	
	/** The btn join. */
	public JButton btnJoin;
	
	/** The btn exit. */
	public JButton btnExit;
	
	/** The btn practice. */
	public JButton btnPractice;
	
	/** The mg. MultiGame*/
	private MultiGame mg;
	
	/** The Application. */
	static Application app;
	
	/** The lbl game id. */
	private JLabel lbl_GameId;
	
	/** The lbl player. */
	private JLabel lbl_Player;
	
	/** The xmlb. */
	private XmlInfoBoard xmlb;
	
	/** The start game. */
	private boolean startGame;	
	


/**
 * set the game .
 *
 * @param startGame the new start game
 * @return void
 */
	public void setStartGame(boolean startGame) {
		this.startGame = startGame;
	}
	
	/** The server access. */
	ServerAccess serverAccess ;
	
	/**
	 * Gets the single instance of Application.
	 *
	 * @param model the model
	 * @return single instance of Application
	 */
	public static Application getInstance(Model model) {
		if (app == null) {
			app = new Application(model);
		}
		
		return app;
	}
	
	/**
	 * Gets the pass word.
	 *
	 * @return the pass word
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * Sets the pass word.
	 *
	 * @param passWord the new pass word
	 */
	public void setPassWord(String passWord) {
		this.create_pass_text.setText(passWord); 
	}
	

	/**
	 * Gets the server access.
	 *
	 * @return the server access
	 */
	public ServerAccess getServerAccess() {
		return serverAccess;
	}

	/**
	 * Sets the server access.
	 *
	 * @param serverAccess the new server access
	 */
	public void setServerAccess(ServerAccess serverAccess) {
		this.serverAccess = serverAccess;
	}
	
	/**
	 * Gets the mg.
	 *
	 * @return the mg
	 */
	public MultiGame getMg() {
		return mg;
	}

	/**
	 * Sets the mg.
	 *
	 * @param mg the new MultiGame
	 */
	public void setMg(MultiGame mg) {
		this.mg = mg;
	}

	
	/**
	 * Identify the existence of the  game name.
	 *
	 * @return true, if successful
	 */
	public boolean notHasPlayerName(){
		playerName = name_id_text.getText();
		if(playerName.length() == 0){
			JOptionPane.showMessageDialog(Application.this, "playerName can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
			name_id_text.requestFocus();
			return true;
		}
		return false;
	
	}
	
	/**
	 * Identify the existence of the game name and game ID.
	 *
	 * @return true, if successful
	 */
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
		
	/**
	 * Gets the player name.
	 *
	 * @return the player name
	 */
	public String getPlayerName() {
		return playerName;
	}



	/**
	 * Sets the player name.
	 *
	 * @param playerName the new player name
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}



	/**
	 * Sets the game number.
	 *
	 * @param gameNumber the new game number
	 */
	public void setGameNumber(String gameNumber) {
		this.gameNumber = gameNumber;
	}



	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return create_pass_text.getText();
	}
	
    
	
	/**
	 * Gets the game number.
	 *
	 * @return the game number
	 */
	public String getGameNumber() {
		return gameNumber;
	}
	

	/**
	 * Gets the managerg.
	 *
	 * @return the managerg
	 */
	public MultiGame getManagerg() {
		return mg;
	}


	/**
	 * Instantiates a new application.
	 *
	 * @param m the m
	 */
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



	/**
	 * Gets the XmlInfoBoard.
	 *
	 * @return the XmlInfoBoard
	 */
	public XmlInfoBoard getXmlb() {
		return xmlb;
	}





}
