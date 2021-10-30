package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Voucher 
{
	private int voucherID;
	private int discount;
	private String status;
	
	public Voucher()
	{
		status = "UNUSED";
	}
	
	public int getVoucherID() 
	{
		return voucherID;
	}
	public void setVoucherID(int voucherID) 
	{
		this.voucherID = voucherID;
	}
	public int getDiscount() 
	{
		return discount;
	}
	public void setDiscount(int discount) 
	{
		this.discount = discount;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}
	
	public Voucher insertVoucher()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement preparedStatement = connect.getPrepareStatement("INSERT INTO VOUCHER(VOUCHER_STATUS, VOUCHER_DISC) VALUES(?, ?)");
		try {
			preparedStatement.setString(1, getStatus());
			preparedStatement.setInt(2, getDiscount());
			preparedStatement.execute();
			return this;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Voucher> getAllVouchers()
	{
		List<Voucher> allVouchers = new ArrayList<>();
		
		Connect connect = Connect.getConnection();
		ResultSet rs = connect.executeQuery("voucher");
		
		try {
			while(rs.next())
			{
				Voucher v = new Voucher();
				v.setStatus(rs.getString("VOUCHER_STATUS"));
				v.setVoucherID(rs.getInt("VOUCHER_ID"));
				v.setDiscount(rs.getInt("VOUCHER_DISC"));
				allVouchers.add(v);
			}
			
			return allVouchers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Voucher getVoucher()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement statement = connect.getPrepareStatement("SELECT * FROM VOUCHER WHERE VOUCHER_ID=?");
		try {
			statement.setInt(1, getVoucherID());
			ResultSet rs = statement.executeQuery();
			if(rs.next())
			{
				Voucher v = new Voucher();
				v.setStatus(rs.getString("VOUCHER_STATUS"));
				v.setDiscount(rs.getInt("VOUCHER_DISC"));
				v.setVoucherID(rs.getInt("VOUCHER_ID"));
				
				return v;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteVoucher()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement statement = connect.getPrepareStatement("DELETE FROM VOUCHER WHERE VOUCHER_ID=" + getVoucherID());
		try {
			return !statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
