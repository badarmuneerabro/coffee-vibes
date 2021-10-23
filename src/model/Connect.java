package model;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;

public class Connect 
{
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String URL = "jdbc:mysql://localhost:3308//coffeevibes";
	
	
	private Connection connection;
	private ResultSet resultSet;
	private Statement statement;
	
	private static Connect connect;
	private Connect()
	{
		try
		{
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Failed to connect to database", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	
	public synchronized Connect getConnection()
	{
		return (connect == null) ? new Connect() : connect;
	}
	
	public ResultSet executeQuery(String table)
	{
		try
		{
			resultSet = statement.executeQuery("SELECT * FROM " + table);
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Failed to execute SELECT query", "Query failed", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		return resultSet;
	}
	
	public void executeUpdate(String query)
	{
		try
		{
			statement.execute(query);
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Failed to execute UPDATE query", "Query failed", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public PreparedStatement getPrepareStatement(String query)
	{
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement = connection.prepareStatement(query);
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Failed to execute SELECT query", "Query failed", JOptionPane.ERROR_MESSAGE);
		}
		
		return preparedStatement; 
	}
}
