package controller;

import java.util.List;

import model.Position;

public class PositionHandler 
{
	private static PositionHandler handler;
	
	public static PositionHandler getInstance()
	{
		return ((handler == null) ? handler = new PositionHandler() : handler);
	}
	private PositionHandler()
	{
		
	}
	public List<Position> getAllPositions()
	{
		Position p = new Position();
		List<Position> allPositions = p.getAllPositions();
		return allPositions;
	}
	
	public Position getPosition(int positionID)
	{
		Position p = new Position();
		p.setPositionID(positionID);
		return p.getPosition();
	}
}
