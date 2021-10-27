package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Voucher 
{
	private int voucherID;
	private int discount;
	private String status;
	
	public Voucher()
	{
		
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
	
	public Voucher generateVoucher()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement preparedStatement = connect.getPrepareStatement("INSERT INTO VOUCHER(VOUCHER_STATUS, VOUCHER_DISC) VALUES(?, ?)");
		try {
			preparedStatement.setString(1, getStatus());
			preparedStatement.setInt(2, getDiscount());
			preparedStatement.executeQuery();
			return this;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
