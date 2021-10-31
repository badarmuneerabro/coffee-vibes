package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.Employee;

public class EmployeeHandler 
{

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
		
		Employee e = new Employee();
		e.setName(name);
		e.setPassword(password);
		//e.setPositionID(positionID);
		e.setSalary(salary);
		e.setUserName(userName);
		e.setPassword(password);
		
		return e.insertEmployee();
	}
	
	public List<Employee> getAllEmployees()
	{
		Employee e = new Employee();
		List<Employee> allEmployees = e.getAllEmployees();
		return allEmployees;
	}
	
	public Employee getEmployee(String userName)
	{
		Employee e = new Employee();
		return e.getEmployee(userName);
	}
	public boolean fireEmployee(int ID)
	{
		Employee e = new Employee();
		e.setEmployeeID(ID);
		return e.fireEmployee();
	}
	public Employee updateEmployee(int employeeID, String position, String name, int salary, String userName, String password)
	{
		Employee e = new Employee();
		e.setEmployeeID(employeeID);
		e.setName(name);
		e.setUserName(userName);
		e.setPassword(password);
		e.setSalary(salary);
		//e.setPositionID(position);
		return e.updateEmployee();
	}
}
