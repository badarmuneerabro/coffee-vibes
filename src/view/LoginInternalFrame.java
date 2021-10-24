package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginInternalFrame extends JInternalFrame {
	
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInternalFrame frame = new LoginInternalFrame();
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
	public LoginInternalFrame() {
		setBounds(100, 100, 448, 299);
		getContentPane().setLayout(null);
		
		JLabel headingLabel = new JLabel("Coffee Vibes");
		headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		headingLabel.setBounds(157, 11, 106, 33);
		getContentPane().add(headingLabel);
		
		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userNameLabel.setBounds(36, 85, 92, 24);
		getContentPane().add(userNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userNameTextField.setBounds(138, 85, 149, 24);
		getContentPane().add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordLabel.setBounds(36, 146, 85, 24);
		getContentPane().add(passwordLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(105, 209, 106, 30);
		getContentPane().add(loginButton);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordTextField.setBounds(138, 146, 149, 24);
		getContentPane().add(passwordTextField);

	}

}
