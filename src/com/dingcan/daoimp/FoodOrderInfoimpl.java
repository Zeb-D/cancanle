package com.dingcan.daoimp;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dingcan.dao.FoodOrderInfoDAO;
import com.dingcan.domain.FoodOrderInfo;
import com.dingcan.domain.Seller;
import com.dingcan.utils.DBOperator;
import com.dingcan.utils.PageBean;


public class FoodOrderInfoimpl implements FoodOrderInfoDAO {
	
	//确认所有未完成订单
	@Override
	public List<FoodOrderInfo> confirmOrder() {
		// TODO Auto-generated method stub
		DBOperator db = new DBOperator();
		String sql = "select * from T_FOODORDERINFO where T_STATE = '请求订单'";//where T_STATE="+Constants.status_request;
		try {
			ResultSet rs =db.executeQuery(sql, null);
			List<FoodOrderInfo> list = returnList(rs);
			
			db.close();
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//显示所有订单
	@Override
	public List<FoodOrderInfo> queryList() {
		// TODO Auto-generated method stub
		DBOperator db = new DBOperator();
		String sql = "select * from T_FOODORDERINFO";//where T_STATE="+Constants.status_request;
		try {
			ResultSet rs =db.executeQuery(sql, null);
			List<FoodOrderInfo> list = returnList(rs);
			
			db.close();
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FoodOrderInfo> queryUnOrder() {
		DBOperator db = new DBOperator();
		String sql = "select * from T_FOODORDERINFO where T_STATE != '完成订单'";
		try {
			ResultSet rs =db.executeQuery(sql, null);
			List<FoodOrderInfo> list = returnList(rs);
			
			db.close();
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<FoodOrderInfo> returnList(ResultSet rs){
		List<FoodOrderInfo> list = new ArrayList<FoodOrderInfo>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				int userid = rs.getInt(2);
				int foodid = rs.getInt(3);
				int foodid2 = rs.getInt(4);
				String address = rs.getString(5);
				BigDecimal telephone = rs.getBigDecimal(6);
				String notice = rs.getString(7);
				double totalprice = rs.getDouble(8);
				int amount = rs.getInt(9);
				Date bookdate = rs.getDate(10);
				String state = rs.getString(11);
				
				FoodOrderInfo order = new FoodOrderInfo(id, userid, foodid, foodid2, address, telephone, notice, totalprice, amount, bookdate, state);
				list.add(order);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public PageBean<FoodOrderInfo> getPagedata(int pageNum,String sql) {
		// TODO Auto-generated method stub
		PageBean<FoodOrderInfo> pagebean = new PageBean<FoodOrderInfo>();
		DBOperator db = new DBOperator();
		String countSql = "select count(T_ID) from T_FOODORDERINFO"+sql.substring(29);
		
		pagebean.setTotal(db.getCount(countSql));
		
		if(pageNum>pagebean.getTotalPage()){
			pageNum=pagebean.getTotalPage();
    	}
		if(pageNum<=0){
			pageNum=1;
		}
		try {
			db.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	
    	DBOperator dbo = new DBOperator();
        String strSql="select * from (select a.* ,rownum rn from  ("+sql+") a where rownum <= "+pageNum*pagebean.getPagesize()+" ) where rn>"+(pageNum-1)*pagebean.getPagesize();
        System.out.println(strSql);
        ResultSet rset;
		try {
			rset = dbo.executeQuery(strSql,null);
			pagebean.getList().addAll(this.returnList(rset));
//        while(rset.next())
//        {
//            
//                Seller seller = new Seller(
//                		rset.getInt("T_SELLERID"), 
//                		rset.getString("T_SELLER_NAME"), 
//                		rset.getString("T_PICTUREADDR"), 
//                		rset.getInt("T_PRICE_QISONG"),
//                		rset.getInt("T_PRICE_PEISONG"),
//                		rset.getInt("T_TELEPHONE"), 
//                		rset.getInt("T_TOTAL_SELL"));
//                pagebean.getList().add(seller);
//            
//           
//        }
        rset.close();
        pagebean.setCurrentPage(pageNum);
        //pagebean.setList(null);
        return pagebean;
        
        

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally{
			try {
				dbo.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return null;
	}
//	@Override
//	public List<FoodOrderInfo> queryList1() {
//		// TODO Auto-generated method stub
//		DBOperator db = new DBOperator();
//		String sql = "select * from T_FOODORDERINFO";//where T_STATE="+Constants.status_request;
//		try {
//			ResultSet rs =db.executeQuery(sql, null);
//			List<FoodOrderInfo> list = returnList(rs);
//			
//			db.close();
//			rs.close();
//			return list;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
}
	

