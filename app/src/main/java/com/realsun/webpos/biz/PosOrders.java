package com.realsun.webpos.biz;

import java.util.List;

import org.litepal.crud.DataSupport;

import com.realsun.webpos.model.PosOrder;

public class PosOrders {
	public static boolean SaveOrder(PosOrder order,String errmsg){
		try
		{
		  order.save();
		   return  true;
		}
		catch (Exception e)
		{
			return false;
		}
		
		 
	}
 
	public static PosOrder QueryOrderByOrderNo(String no){
		try
		{
		   List<PosOrder> orders=DataSupport.where("orderno = ?",no).find(PosOrder.class);
		   return  orders.get(0);
		}
		catch (Exception e)
		{
			return null;
		}
		
	}
	public static PosOrder QueryOrderByCardno(String dates,String cardno,String dishtypeno){
		try
		{
			List<PosOrder> orders=DataSupport.where("dates = '?' and cardno='?' and dishtypeno=?",dates,cardno,dishtypeno).find(PosOrder.class);
			return   orders.get(0);
		}
		catch (Exception e)
		{
			return null;
		}
		
	}
}
