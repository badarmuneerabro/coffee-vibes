package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Connect;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

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
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String userName =userNameTextField.getText();
				String password = new String(passwordTextField.getPassword());
				
				if(userName.trim().isEmpty() || password.trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Username or password can not be empty", "Login Failed", JOptionPane.ERROR_MESSAGE);
					return;
				}
					
				Connect db = Connect.getConnection();
				PreparedStatement pStatement = db.getPrepareStatement("SELECT * FROM EMP WHERE EMP_USERNAME=? AND EMP_PASSWORD=? AND EMP_STATUS=\'EMPLOYED\'");
				try
				{
					pStatement.setString(1, userNameTextField.getText());
					pStatement.setString(2, new String(passwordTextField.getPassword()));
					ResultSet rs = pStatement.executeQuery();
					
					
					if(rs.next())
					{
						LoginInternalFrame.this.dispose();
						openFrame(rs);
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect Username or password", "Login Faild", JOptionPane.ERROR_MESSAGE);
					
				}catch(SQLException ex)
				{
					System.out.println("ERROR " + ex);
				}
			}
		});
		loginButton.setBounds(105, 209, 106, 30);
		getContentPane().add(loginButton);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordTextField.setBounds(138, 146, 149, 24);
		getContentPane().add(passwordTextField);

	}
	
	public void openFrame(ResultSet rs)
	{
		int position = 0;
		try 
		{
			position = rs.getInt("EMP_POS_ID");
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Position: " + position);
		switch(position)
		{
		case 1:
			break;
		case 2:
			MainView.getInstance().openProductInternalVeiw();
			MainView.getInstance().setText("Product admin");
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}

}
