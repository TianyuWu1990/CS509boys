package Ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;

public class ClientJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEricsGame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtUserid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientJFrame frame = new ClientJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientJFrame() {
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStartNewGame = new JButton("Start new ");
		btnStartNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuestGameJFrame jf = new GuestGameJFrame() ;
				jf.setVisible(true);
			}
		});
		btnStartNewGame.setBounds(60, 375, 93, 23);
		contentPane.add(btnStartNewGame);
		
		JLabel lblGameid = new JLabel("gameID\uFF1A");
		lblGameid.setBounds(22, 53, 64, 35);
		contentPane.add(lblGameid);
		
		JLabel lblNumberofplayers = new JLabel("Players\uFF1A");
		lblNumberofplayers.setBounds(198, 53, 64, 35);
		contentPane.add(lblNumberofplayers);
		
		JLabel lblDate = new JLabel("date\uFF1A");
		lblDate.setBounds(380, 53, 64, 34);
		contentPane.add(lblDate);
		
		txtEricsGame = new JTextField();
		txtEricsGame.setText("Eric's Game");
		txtEricsGame.setBounds(71, 59, 117, 23);
		contentPane.add(txtEricsGame);
		txtEricsGame.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("4");
		textField_1.setColumns(10);
		textField_1.setBounds(253, 59, 117, 23);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("9/20/2016");
		textField_2.setColumns(10);
		textField_2.setBounds(417, 59, 117, 23);
		contentPane.add(textField_2);
		
		JButton btnPractiseModel = new JButton("Practice model");
		btnPractiseModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPractiseModel.setBounds(378, 375, 111, 23);
		contentPane.add(btnPractiseModel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(540, 375, 111, 23);
		contentPane.add(btnExit);
		
		JTextArea txtrGames = new JTextArea();
		txtrGames.setText("Holder:\t\tplayers:\t\tlock:\r\nEric\t\t3\t\t\tno\r\nPeter\t\t4\t\t\tyes\r\nLily\t\t2\t\t\tno\r\nSun\t\t2\t\t\tyes");
		txtrGames.setBounds(53, 99, 519, 241);
		contentPane.add(txtrGames);
		
		JButton btnNewButton = new JButton("Join");
		btnNewButton.setBounds(198, 375, 127, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcome.setBounds(22, 11, 64, 31);
		contentPane.add(lblWelcome);
		
		txtUserid = new JTextField();
		txtUserid.setText("Laren");
		txtUserid.setBounds(98, 18, 86, 20);
		contentPane.add(txtUserid);
		txtUserid.setColumns(10);
	}
}
