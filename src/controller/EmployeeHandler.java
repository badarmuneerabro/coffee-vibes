package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import model.Connect;
import model.Employee;

public class EmployeeHandler 
{
	private static EmployeeHandler employeeHandler;
	private EmployeeHandler()
	{
		
	}
	
	public static EmployeeHandler getInstance()
	{
		return (employeeHandler == null) ? employeeHandler = new EmployeeHandler() : employeeHandler;
	}

	public Employee insertEmployee(String name, String position, int salary, String userName, String password)
	{
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Name can not be empty.", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(position.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Position can not be empty.", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(salary<1)
		{
			JOptionPane.showMessageDialog(null, "Salary can not be less than 1", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(userName.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "username can not be empty.", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(password.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "password can not be empty.", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		
		Connect connect = Connect.getConnection();
		PreparedStatement statement = connect.getPrepareStatement("SELECT POSITION_ID FROM POSITION WHERE POSITION_NAME= \'" + position + "\'");
		int positionID = 0;
		try {
			ResultSet rs = statement.executeQuery();
			rs.next();
		    positionID = rs.getInt("POSITION_ID");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		Employee e = new Employee();
		e.setName(name);
		e.setPassword(password);
		e.setPositionID(positionID);
		e.setSalary(salary);
		e.setUserName(userName);
		e.setPassword(password);
		e.setStatus("EMPLOYED");
		
		return e.insertEmployee();
	}
	
	public List<Employee> getAllEmployees()
	{
		Employee e = new Employee();
		List<Employee> allEmployees = e.getAllEmployees();
		return allEmployees;
	}
	
	public Employee getEmployee(int empID)
	{
		Employee e = new Employee();
		e.setEmployeeID(empID);
		return e.getEmployee();
	}
	public boolean fireEmployee(int ID)
	{
		Employee e = new Employee();
		e.setEmployeeID(ID);
		return e.fireEmployee();
	}
	public Employee updateEmployee(int employeeID, String position, String name, int salary, String userName, String password)
	{
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Name can not be empty.", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(position.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Position can not be empty.", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(salary<1)
		{
			JOptionPane.showMessageDialog(null, "Salary can not be less than 1", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(userName.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "username can not be empty.", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(password.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "password can not be empty.", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		Connect connect = Connect.getConnection();
		PreparedStatement statement = connect.getPrepareStatement("SELECT POSITION_ID FROM POSITION WHERE POSITION_NAME= \'" + position + "\'");
		int positionID = 0;
		try {
			ResultSet rs = statement.executeQuery();
			rs.next();
		    positionID = rs.getInt("POSITION_ID");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		
		Employee e = new Employee();
		e.setEmployeeID(employeeID);
		e.setName(name);
		e.setUserName(userName);
		e.setPassword(password);
		e.setSalary(salary);
		e.setPositionID(positionID);
		return e.updateEmployee();
	}
	
	
	public boolean deleteEmployee(int ID)
	{
		Employee e = new Employee();
		e.setEmployeeID(ID);
		return e.deleteEmployee();
	}
}
