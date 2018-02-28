package com.dingcan.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dingcan.dao.FoodDAO;
import com.dingcan.domain.Food;
import com.dingcan.utils.DBOperator;
import com.dingcan.utils.PageBean;

public class FoodDaoimp implements FoodDAO{
	
	public List<Food> queryList() {
		DBOperator db = new DBOperator();
		
		String sql = "Select * from T_FOOD";
		List<Food> list= new ArrayList<Food>();
		
		try {
			ResultSet rs = db.executeQuery(sql, null);
			while(rs.next()){
				list.add(new Food(rs.getInt("T_foodid"), 
									rs.getString("T_foodname"),
									rs.getInt("T_sellerid"),
									rs.getDouble("T_price"),
									rs.getString("T_picture"),
									rs.getInt("T_rest"), 
									rs.getInt("T_total_sell"),
									rs.getDouble("T_stars")
									));
			}
			return list;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				db.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	}
	

	@Override
	public Food getByNo(int foodid) {
		
		DBOperator dbo = new DBOperator();
		
		String sql = "Select * from T_food";
		Object[] obj = {foodid};
		Food food =null;
		try {
			ResultSet rs = dbo.executeQuery(sql, obj);
			while(rs.next()){
				food=new Food(rs.getInt("T_foodid"), 
						rs.getString("T_foodname"),
						rs.getInt("T_sellerid"),
						rs.getDouble("T_price"),
						rs.getString("T_picture"),
						rs.getInt("T_rest"), 
						rs.getInt("T_totalsell"),
						rs.getDouble("T_stars")
						);
			}
			return food;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	public Food getByNo(String foodname) {
		// TODO Auto-generated method stub
		DBOperator dbo = new DBOperator();
		
		String sql = "Select T_SELLERID,T_SELLER_NAME,T_PICTUREADDR,T_PRICE_QISONG,T_PRICE_PEISONG,T_TELEPHONE,T_TOTAL_SELL from T_SELLER where T_SELLERNAME=?";
		   
		Object[] obj = {foodname};
		Food food =null;
		try {
			ResultSet rs = dbo.executeQuery(sql, obj);
			while(rs.next()){
				food=new Food(rs.getInt("T_foodid"), 
						rs.getString("T_foodname"),
						rs.getInt("T_sellerid"),
						rs.getDouble("T_price"),
						rs.getString("T_picture"),
						rs.getInt("T_rest"), 
						rs.getInt("T_totalsell"),
						rs.getDouble("T_stars")
						);
			}
			return food;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	

	@Override
	public boolean UpdateByNo(Food food, int foodid) {
DBOperator dbo = new DBOperator();
		
		String sql = "Update T_Food set "
				+ "T_SELLER_NAME=?,"
				+ "T_PICTUREADDR=?,"
				+ "T_PRICE_QISONG=?,"
				+ "T_PRICE_PEISONG=?,"
				+ "T_TELEPHONE=?,"
				+ "T_TOTAL_SELL=?"
				+ " where T_SELLERID=?";
		   
		String[] obj = {food.foodname,
						food.picture,
						String.valueOf(food.sellerid),
						String.valueOf(food.rest),
						String.valueOf(food.totalsell),
						String.valueOf(food.stars),
						String.valueOf(food.totalsell)};
		//Seller seller =null;
		try {
			 dbo.executeUpdate(sql, obj);
			
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				dbo.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}
	

	@Override
	public boolean DeleteByNo(int foodid) {
			DBOperator dbo = new DBOperator();
		
		String sql = "delete from T_Food  where T_foodID=?";
		   
		String[] obj = {String.valueOf(foodid)};
		//Seller seller =null;
		try {
			 dbo.executeUpdate(sql, obj);
			
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				dbo.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}



	@Override
	public void AddFood(Food food) {
		// TODO Auto-generated method stub
		DBOperator dbo = new DBOperator();
		
		String sql = "INSERT INTO T_FOOD (T_FOODID ,T_FOODNAME ,T_SELLERID ,T_PRICE ,T_PICTURE ,T_REST ,T_TOTAL_SELL ,T_STARS ) VALUES (t_food_seq.nextval,?,?,?,?,?,?,?)";
		Object[] obj = {food.foodname,food.sellerid,food.price,food.picture,
						food.rest,food.totalsell,food.stars};//从前台取出值
		
		//Seller seller =null;
		try {
			 dbo.executeUpdate(sql, obj);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				dbo.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public List<Food> returnList(ResultSet rs){
		List<Food> list = new ArrayList<Food>();
		try {
			while(rs.next()){
				int foodid = rs.getInt(1);
				String foodname = rs.getString(2);
				int sellerid = rs.getInt(3);
				double price = rs.getDouble(4);
				String picture = rs.getString(5);
				int rest = rs.getInt(6);
				int totalsell = rs.getInt(7);
				double stars = rs.getDouble(8);
				
				Food food = new Food(foodid, foodname, sellerid, price, picture, rest, totalsell, stars);
				list.add(food);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public PageBean<Food> getPagedata(int pageNum,String sql) {
		// TODO Auto-generated method stub
		PageBean<Food> pagebean = new PageBean<Food>();
		DBOperator db = new DBOperator();
		String countSql = "select count(T_FOODID) from T_FOOD";
		
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


	@Override
	public void AddFood() {
		// TODO Auto-generated method stub
		
	}

	


	

}


