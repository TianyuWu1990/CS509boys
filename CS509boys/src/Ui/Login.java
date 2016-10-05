package Ui;
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
public class Login extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	public Login() {
		setTitle("Login");
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(134, 31, 132, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(40, 21, 84, 36);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(40, 72, 84, 36);
		getContentPane().add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 82, 132, 20);
		getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(119, 119, 113, 39);
		getContentPane().add(btnNewButton);
	}

}
