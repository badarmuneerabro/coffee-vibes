package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.Connect;
import model.Voucher;

public class VoucherHandler 
{
	private static VoucherHandler handler;
	private VoucherHandler()
	{
		
	}
	
	public static VoucherHandler getInstance()
	{
		return (handler == null) ? handler = new VoucherHandler() : handler;
	}
	public List<Voucher> getAllVouchers()
	{
		Voucher v = new Voucher();
		List<Voucher> voucherList = v.getAllVouchers();
		return voucherList;
	}
	
	public Voucher insertVoucher(int discount)
	{
		if(discount<=1 || discount>=100)
		{
			JOptionPane.showMessageDialog(null, "discount must be between 1 and 100.", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		Voucher v = new Voucher();
		v.setDiscount(discount);
		
		return v.insertVoucher();
		
	}
	
	public boolean deleteVoucher(int voucherID)
	{
		Voucher v = new Voucher();
		v.setVoucherID(voucherID);
		return v.deleteVoucher();
	}
	public Voucher getVoucher(int voucherID)
	{
		Voucher v = new Voucher();
		v.setVoucherID(voucherID);
		return v.getVoucher();
	}
}
