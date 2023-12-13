package com.db.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.db.pojo.Product;
import com.db.util.DBUtility;

public class ProductDaoImp1 implements ProductDao{

	Connection con=null;
	PreparedStatement ps=null;
	String sql=null;
	ResultSet rs=null;
	
	@Override
	public Boolean addProduct(Product p) {
		con=DBUtility.makeConnection();
		try {
			sql="insert into Product_6201(productName, productType, price, quantityInStock, rating, description) values (?, ?, ?, ?, ?, ?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, p.getProductName());
			ps.setString(2, p.getProductType());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getQuantityInStock());
			ps.setDouble(5, p.getRating());
			ps.setString(6, p.getDescription());
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Boolean updateProduct(Product p) {
		con=DBUtility.makeConnection();
		sql="update Product_6201 set productName=?, productType=?, price=?, quantityInStock=?, rating=?, description=? where productId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, p.getProductName());
			ps.setString(2, p.getProductType());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getQuantityInStock());
			ps.setDouble(5, p.getRating());
			ps.setString(6, p.getDescription());
			ps.setInt(7, p.getProductId());
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Boolean deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> showAllProducts() {
		con=DBUtility.makeConnection();
		sql="select * from Product_6201";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			List<Product> plist=new ArrayList<Product>();
			
			while(rs.next()) {
				Product p=new Product();
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString(2));
				p.setProductType(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setQuantityInStock(rs.getInt(5));
				p.setRating(rs.getDouble(6));
				p.setDescription(rs.getString(7));
				
				plist.add(p);
			}
			
			return plist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Product showProductById(Integer productId) {
		con=DBUtility.makeConnection();
		sql="select * from Product_6201 where productId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, productId);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				Product p=new Product();
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString(2));
				p.setProductType(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setQuantityInStock(rs.getInt(5));
				p.setRating(rs.getDouble(6));
				p.setDescription(rs.getString(7));
				
				return p;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Product> searchProductByName(String productName) {
		con=DBUtility.makeConnection();
		sql="select * from Product_6201 where productName like ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+productName+"%");
			
			rs=ps.executeQuery();
			List<Product> plist=new ArrayList<Product>();
			
			while(rs.next()) {
				Product p=new Product();
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString(2));
				p.setProductType(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setQuantityInStock(rs.getInt(5));
				p.setRating(rs.getDouble(6));
				p.setDescription(rs.getString(7));
				
				plist.add(p);
			}
			
			return plist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

