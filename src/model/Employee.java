package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Employee 
{
	private int employeeID;
	private int positionID;
	private String name;
	private String status;
	private int salary;
	private String userName;
	private String password;
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) 
	{
		this.positionID = positionID;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public int getSalary() 
	{
		return salary;
	}

	public void setSalary(int salary) 
	{
		this.salary = salary;
	}

	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public Employee insertEmployee()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement statement = connect.getPrepareStatement("INSERT INTO EMP(EMP_NAME, EMP_STATUS, EMP_SAL, EMP_USERNAME, EMP_PASSWORD, EMP_POS_ID) VALUES(?, ?, ?, ?, ?, ?);");
		try 
		{
			statement.setString(1, getName());
			statement.setString(2,  getStatus());
			statement.setInt(3, getSalary());
			statement.setString(4, getUserName());
			statement.setString(5, getPassword());
			statement.setInt(6, getPositionID());
			statement.execute();
			return this;
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Employee> getAllEmployees()
	{
		Connect connect = Connect.getConnection();
		ResultSet rs = connect.executeQuery("EMP");
		List<Employee> allEmployees = new ArrayList<>();
		try {
			while(rs.next())
			{
				Employee e = new Employee();
				e.setEmployeeID(rs.getInt("EMP_ID"));
				e.setName(rs.getString("EMP_NAME"));
				e.setStatus(rs.getString("EMP_STATUS"));
				e.setSalary(rs.getInt("EMP_SAL"));
				e.setUserName(rs.getString("EMP_USERNAME"));
				e.setPassword(rs.getString("EMP_PASSWORD"));
				e.setPositionID(rs.getInt("EMP_POS_ID"));
				allEmployees.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return allEmployees;
	}
	
	public Employee getEmployee()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement statement = connect.getPrepareStatement("SELECT * FROM EMP WHERE EMP_ID=" + getEmployeeID());
		try {
			ResultSet rs = statement.executeQuery();
			rs.next();
			Employee e= new Employee();
			e.setEmployeeID(rs.getInt("EMP_ID"));
			e.setName(rs.getString("EMP_NAME"));
			e.setStatus(rs.getString("EMP_STATUS"));
			e.setSalary(rs.getInt("EMP_SAL"));
			e.setUserName(rs.getString("EMP_USERNAME"));
			e.setPassword(rs.getString("EMP_PASSWORD"));
			e.setPositionID(rs.getInt("EMP_POS_ID"));
			return e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Employee updateEmployee()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement statement = connect.getPrepareStatement("UPDATE EMP SET EMP_NAME=?, EMP_POS_ID=?, EMP_SAL=?, EMP_USERNAME=?, EMP_PASSWORD=? WHERE EMP_ID=" + getEmployeeID());
		try {
			statement.setString(1, getName());
			statement.setInt(2, getPositionID());
			statement.setInt(3, getSalary());
			statement.setString(4, getUserName());
			statement.setString(5, getPassword());
			statement.executeUpdate();
			return this;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public boolean fireEmployee()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement statement = connect.getPrepareStatement("UPDATE EMP SET EMP_STATUS='" + "fired'" + "WHERE EMP_ID=" + getEmployeeID());
		try {
			return !statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String getPosition()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement statement = connect.getPrepareStatement("SELECT POSITION_NAME FROM POSITION WHERE POSITION_ID=" + getPositionID());
		try {
			ResultSet rs = statement.executeQuery();
			rs.next();
			return rs.getString("POSITION_NAME");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
