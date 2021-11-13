package model;

import java.security.SecureRandom;
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
	private String code;
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
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getCode()
	{
		return code;
	}
	/*
	 * CHANGED THE INSERT METHOD TO INSERT CODE AS WELL.
	 */
	public Voucher insertVoucher()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement preparedStatement = connect.getPrepareStatement("INSERT INTO VOUCHER(VOUCHER_CODE,VOUCHER_STATUS, VOUCHER_DISC) VALUES(?, ?, ?)");
		try {
			generateCode();
			preparedStatement.setString(1, getCode());
			preparedStatement.setString(2, getStatus());
			preparedStatement.setInt(3, getDiscount());
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
				v.setCode(rs.getString("VOUCHER_CODE"));
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
				v.setCode(rs.getString("VOUCHER_CODE"));
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
	
	public boolean updateVoucher()
	{
		Connect connect = Connect.getConnection();
		PreparedStatement statement = connect.getPrepareStatement("UPDATE VOUCHER SET VOUCHER_STATUS='USED' WHERE VOUCHER_ID=" + getVoucherID());
		try {
			return !statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * THIS IS THE METHOD FOR GENERATING RANDOM CODE FOR A VOUCHER.
	 */
	
	public void generateCode()
	{
		SecureRandom random = new SecureRandom();
		String[] charPool = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R"
				, "S", "T", "U", "V", "W", "X", "Y", "Z"};
		
		int index1 = 1 + random.nextInt(26);
		int index2 = 1 + random.nextInt(26);
		
		int code = 1000 + random.nextInt(10000);
		
		String generatedCode = Integer.toString(code) + charPool[index1] + charPool[index2] + getDiscount();
		
		setCode(generatedCode);
	}
}
