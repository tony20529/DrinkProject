package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Porder;
import util.DbConnection;
import util.Tool;

public class PorderDaoImpl implements PorderDao{

	public static void main(String[] args) {
		

	}

	private static Connection conn=DbConnection.getDb();
	public void add(Porder porder) {
		String sql="insert into porder(name,username,pearlmilktea,duoduogreentea,milkcoveredgreentea,coffee,pearlmilk,time) "
				+"values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setString(2, porder.getUsername());
			preparedstatement.setInt(3, porder.getPearlmilktea());
			preparedstatement.setInt(4, porder.getDuoduogreentea());
			preparedstatement.setInt(5, porder.getMilkcoveredgreentea());
			preparedstatement.setInt(6, porder.getCoffee());
			preparedstatement.setInt(7, porder.getPearlmilk());
			preparedstatement.setString(8, porder.getTime());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	@Override
	public List<Porder> selectAll() {
		String sql="select * from porder";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("id"));
				porder.setName(resultset.getString("name"));
				porder.setUsername(resultset.getString("username"));
				porder.setPearlmilktea(resultset.getInt("pearlmilktea"));
				porder.setDuoduogreentea(resultset.getInt("duoduogreentea"));
				porder.setMilkcoveredgreentea(resultset.getInt("milkcoveredgreentea"));
				porder.setCoffee(resultset.getInt("coffee"));
				porder.setPearlmilk(resultset.getInt("pearlmilk"));
				porder.setTime(resultset.getString("time"));
				porder.setSeller(resultset.getString("seller"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;
	}

	@Override
	public List<Porder> selectById(int id) {
		String Sql="select * from porder where id=?";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(Sql);
			preparedstatement.setInt(1, id);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("id"));
				porder.setName(resultset.getString("name"));
				porder.setUsername(resultset.getString("username"));
				porder.setPearlmilktea(resultset.getInt("pearlmilktea"));
				porder.setDuoduogreentea(resultset.getInt("duoduogreentea"));
				porder.setMilkcoveredgreentea(resultset.getInt("milkcoveredgreentea"));
				porder.setCoffee(resultset.getInt("coffee"));
				porder.setPearlmilk(resultset.getInt("pearlmilk"));
				porder.setTime(resultset.getString("time"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(Porder porder) {
		String sql="update porder set name=?,username=?,pearlmilktea=?,duoduogreentea=?,milkcoveredgreentea=?,coffee=?,pearlmilk=?,seller=? where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setString(2, porder.getUsername());
			preparedstatement.setInt(3, porder.getPearlmilktea());
			preparedstatement.setInt(4, porder.getDuoduogreentea());
			preparedstatement.setInt(5, porder.getMilkcoveredgreentea());
			preparedstatement.setInt(6, porder.getCoffee());
			preparedstatement.setInt(7, porder.getPearlmilk());
			preparedstatement.setString(8, porder.getSeller());
			preparedstatement.setInt(9, porder.getId());
			
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from porder where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
