package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Position 
{
	private int positionID;
	private String name;
	
	public Position()
	{
		
	}
	public Position(int positionID, String name)
	{
		this.positionID = positionID;
		this.name = name;
	}
	
	public void setPositionID(int positionID)
	{
		this.positionID = positionID;
	}
	public void setPositionName(String name)
	{
		this.name = name;
	}
	public int getPositionID()
	{
		return positionID;
	}
	public String getPositionName()
	{
		return name;
	}
	public List<Position> getAllPositions()
	{
		List<Position> allPositions = new ArrayList<>();
		ResultSet rs = Connect.getConnection().executeQuery("POSITION");
		try {
			while(rs.next())
			{
				Position p = new Position(rs.getInt("POSITION_ID"), rs.getString("POSITION_NAME"));
				allPositions.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return allPositions;
	}
	
	public Position getPosition()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement statement = connect.getPrepareStatement("SELECT * FROM POSITION WHERE POSITION_ID=" + getPositionID());
		
		try {
			ResultSet rs = statement.executeQuery();
			rs.next();
			Position p = new Position(rs.getInt("POSITION_ID"), rs.getString("POSITION_NAME"));
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
