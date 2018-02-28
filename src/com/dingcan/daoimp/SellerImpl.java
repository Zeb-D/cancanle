package com.dingcan.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dingcan.dao.SellerDAO;
import com.dingcan.domain.Seller;
import com.dingcan.utils.DBOperator;
import com.dingcan.utils.PageBean;

public class SellerImpl implements SellerDAO{

	@Override
	public List<Seller> queryList() {
		// TODO Auto-generated method stub
		DBOperator dbo = new DBOperator();
		
		String sql = "Select T_SELLERID,T_SELLER_NAME,T_PICTUREADDR,T_PRICE_QISONG,T_PRICE_PEISONG,T_TELEPHONE,T_TOTAL_SELL from T_SELLER";
		   
		List<Seller> list= new ArrayList<Seller>();
		try {
			ResultSet rs = dbo.executeQuery(sql, null);
			while(rs.next()){
				list.add(new Seller(rs.getInt("T_SELLERID"), 
									rs.getString("T_SELLER_NAME"),
									rs.getString("T_PICTUREADDR"),
									rs.getInt("T_PRICE_QISONG"),
									rs.getInt("T_PRICE_PEISONG"),
									rs.getInt("T_TELEPHONE"), 
									rs.getInt("T_TOTAL_SELL")));
			}
			return list;
			
			
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
	
	public List<String> queryAllName() {
		// TODO Auto-generated method stub
		DBOperator dbo = new DBOperator();
		
		String sql = "Select T_SELLER_NAME from T_SELLER";
		   
		List<String> list= new ArrayList<String>();
		try {
			ResultSet rs = dbo.executeQuery(sql, null);
			while(rs.next()){
				list.add(rs.getString("T_SELLER_NAME"));
			}
			return list;
			
			
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
	public PageBean<Seller> getPagedata(int pageNum,String range) {
		// TODO Auto-generated method stub
		PageBean<Seller> pagebean = new PageBean<Seller>();
		DBOperator db = new DBOperator();
		String countSql = "select count(T_SELLERID) from T_SELLER "+range;
		
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
        String strSql="select * from  (select a.* ,rownum rn from  (select * from t_seller " + range+ ") a where rownum <= "+pageNum*pagebean.getPagesize()+" ) where rn>"+(pageNum-1)*pagebean.getPagesize();
        		System.out.println(strSql);
        ResultSet rset;
		try {
			rset = dbo.executeQuery(strSql,null);
		
        while(rset.next())
        {
            
                Seller seller = new Seller(
                		rset.getInt("T_SELLERID"), 
                		rset.getString("T_SELLER_NAME"), 
                		rset.getString("T_PICTUREADDR"), 
                		rset.getInt("T_PRICE_QISONG"),
                		rset.getInt("T_PRICE_PEISONG"),
                		rset.getInt("T_TELEPHONE"), 
                		rset.getInt("T_TOTAL_SELL"));
                pagebean.getList().add(seller);
            
           
        }
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
	public Seller getByNo(int sellerid) {
		// TODO Auto-generated method stub
		
		DBOperator dbo = new DBOperator();
		
		String sql = "Select T_SELLERID,T_SELLER_NAME,T_PICTUREADDR,T_PRICE_QISONG,T_PRICE_PEISONG,T_TELEPHONE,T_TOTAL_SELL from T_SELLER where T_SELLERID=?";
		   
		Object[] obj = {sellerid};
		Seller seller =null;
		try {
			ResultSet rs = dbo.executeQuery(sql, obj);
			while(rs.next()){
				seller = new Seller(rs.getInt("T_SELLERID"), 
									rs.getString("T_SELLER_NAME"),
									rs.getString("T_PICTUREADDR"),
									rs.getInt("T_PRICE_QISONG"),
									rs.getInt("T_PRICE_PEISONG"),
									rs.getInt("T_TELEPHONE"), 
									rs.getInt("T_TOTAL_SELL"));
			}
			return seller;
			
			
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
	public Seller getByName(String sellername) {
		// TODO Auto-generated method stub
		
		DBOperator dbo = new DBOperator();
		
		String sql = "Select T_SELLERID,T_SELLER_NAME,T_PICTUREADDR,T_PRICE_QISONG,T_PRICE_PEISONG,T_TELEPHONE,T_TOTAL_SELL from T_SELLER where T_SELLER_NAME=?";
		   
		Object[] obj = {sellername};
		Seller seller =null;
		try {
			ResultSet rs = dbo.executeQuery(sql, obj);
			while(rs.next()){
				seller = new Seller(rs.getInt("T_SELLERID"), 
									rs.getString("T_SELLER_NAME"),
									rs.getString("T_PICTUREADDR"),
									rs.getInt("T_PRICE_QISONG"),
									rs.getInt("T_PRICE_PEISONG"),
									rs.getInt("T_TELEPHONE"), 
									rs.getInt("T_TOTAL_SELL"));
			}
			return seller;
			
			
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
	public boolean UpdateByNo(Seller seller, int sellerid) {
		// TODO Auto-generated method stub
		DBOperator dbo = new DBOperator();
		
		String sql = "Update T_SELLER set "
				+ "T_SELLER_NAME=?,"
				+ "T_PICTUREADDR=?,"
				+ "T_PRICE_QISONG=?,"
				+ "T_PRICE_PEISONG=?,"
				+ "T_TELEPHONE=?,"
				+ "T_TOTAL_SELL=?"
				+ " where T_SELLERID=?";
		   
		String[] obj = {seller.sellername,
						seller.pictureaddr,
						String.valueOf(seller.priceqisong),
						String.valueOf(seller.pricepeisong),
						String.valueOf(seller.telephone),
						String.valueOf(seller.totalsell),
						String.valueOf(sellerid)};
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
	public boolean DeleteByNo(int sellerid) {
		// TODO Auto-generated method stub
		
		DBOperator dbo = new DBOperator();
		
		String sql = "delete from T_SELLER  where T_SELLERID=?";
		   
		String[] obj = {String.valueOf(sellerid)};
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
	public boolean InsertSeller(Seller seller) {
		// TODO Auto-generated method stub
		DBOperator dbo = new DBOperator();
		
		String sql = "insert into t_seller(t_sellerid,t_seller_name,t_pictureaddr,t_price_qisong,t_price_peisong,t_telephone,t_total_sell)"
				+ "values(t_seller_seq.nextval,?,?,?,?,?,?)";
		   
		String[] obj = {seller.sellername,
						seller.pictureaddr,
						String.valueOf(seller.priceqisong),
						String.valueOf(seller.pricepeisong),
						String.valueOf(seller.telephone),
						String.valueOf(seller.totalsell)};
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
	

	public static void main(String[] args) {
		SellerImpl si = new SellerImpl();
		
		PageBean<Seller> page = si.getPagedata(1," where T_SELLER_NAME like '厦门%'");
		
		System.out.println(page);
		
		/*//si.DeleteByNo(6);
		si.InsertSeller(new Seller(1,"南昌扮粉","D:\\f\\ab.jpg",25,4,10086110,1) );
		List<Seller> list = si.queryList();
		for(Seller se:list){
			System.out.println(se);
		}
		
		System.out.println(si.getByNo(1));
		System.out.println(si.getByName("北京烤鸭"));
		
		//System.out.println(si.UpdateByNo(new Seller(1,"北京烤鸭","D:\\f\\ab.jpg",25,4,10086110,1), 1));
		System.out.println(si.getByNo(1));
		//sellerid=1, sellername=北京烤鸭, pictureaddr=D:\\f\a.jpg, priceqisong=25, pricepeisong=4, telephone=10086110, totalsell=1]
*/
		
	}

	
	
}
