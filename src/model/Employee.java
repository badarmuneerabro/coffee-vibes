package model;

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
		return null;
	}
	
	public List<Employee> getAllEmployees()
	{
		return null;
	}
	
	public Employee getEmployee(String userName)
	{
		return null;
	}
	
	public Employee updateEmployee()
	{
		return null;
	}
	public boolean fireEmployee(int ID)
	{
		return false;
	}
}
