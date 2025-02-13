package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import model.Member;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao{
	private static Connection conn=DbConnection.getDb();
	public static void main(String[] args) {
		List<Member> l=new MemberDaoImpl().selectUsernameAndPassword("tony123", "ekrjkr");
		Member m=null;
		if(l.size()!=0)
		{
			m=l.get(0);
		}		
		System.out.print(m);
		

	}

	@Override
	public void addMember(Member member) {
		
		String sql="insert into member(id,name,username,password,gender,age,address,mobile)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, member.getId());
			preparedstatement.setString(2, member.getName());
			preparedstatement.setString(3, member.getUsername());
			preparedstatement.setString(4, member.getPassword());
			preparedstatement.setString(5, member.getGender());
			preparedstatement.setString(6, member.getAge());
			preparedstatement.setString(7, member.getAddress());
			preparedstatement.setString(8, member.getMobile());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void addVipMember(Member vipmember) {
		String sql="insert into vipmember(id,name,username,password,gender,age,address,mobile)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, vipmember.getId());
			preparedstatement.setString(2, vipmember.getName());
			preparedstatement.setString(3, vipmember.getUsername());
			preparedstatement.setString(4, vipmember.getPassword());
			preparedstatement.setString(5, vipmember.getGender());
			preparedstatement.setString(6, vipmember.getAge());
			preparedstatement.setString(7, vipmember.getAddress());
			preparedstatement.setString(8, vipmember.getMobile());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void addEmployeeMember(Member employee) {
		
		String sql="insert into employee(id,name,username,password,gender,age,address,mobile)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, employee.getId());
			preparedstatement.setString(2, employee.getName());
			preparedstatement.setString(3, employee.getUsername());
			preparedstatement.setString(4, employee.getPassword());
			preparedstatement.setString(5, employee.getGender());
			preparedstatement.setString(6, employee.getAge());
			preparedstatement.setString(7, employee.getAddress());
			preparedstatement.setString(8, employee.getMobile());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void addSuperuserMember(Member superuser) {
		
		String sql="insert into superuser(id,name,username,password,gender,age,address,mobile)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, superuser.getId());
			preparedstatement.setString(2, superuser.getName());
			preparedstatement.setString(3, superuser.getUsername());
			preparedstatement.setString(4, superuser.getPassword());
			preparedstatement.setString(5, superuser.getGender());
			preparedstatement.setString(6, superuser.getAge());
			preparedstatement.setString(7, superuser.getAddress());
			preparedstatement.setString(8, superuser.getMobile());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public List<Member> selectAllGuest() {
		String sql="SELECT * FROM allguest;";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			
			
			
			while(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setGender(resultset.getString("gender"));
				m.setAge(resultset.getString("age"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}

	@Override
	public List<Member> selectAll() {
		String sql="SELECT * FROM allmember;";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			
			
			
			while(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setGender(resultset.getString("gender"));
				m.setAge(resultset.getString("age"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}

	@Override
	public List<Member> selectUsernameAndPassword(String username, String password) {
		String sql="select * from allmember where username=? and password=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setGender(resultset.getString("gender"));
				m.setAge(resultset.getString("age"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<Member> selectById(int id) {
		String sql="select * from allmember where id=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setGender(resultset.getString("gender"));
				m.setAge(resultset.getString("age"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public List<Member> selectByMemberId(int id) {
		String sql="select * from member where id=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setGender(resultset.getString("gender"));
				m.setAge(resultset.getString("age"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Member> selectByVipMemberId(int id) {
		String sql="select * from vipmember where id=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setGender(resultset.getString("gender"));
				m.setAge(resultset.getString("age"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Member> selectByEmployeeMemberId(int id) {
		String sql="select * from employee where id=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setGender(resultset.getString("gender"));
				m.setAge(resultset.getString("age"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Member> selectBySuperuserMemberId(int id) {
		String sql="select * from superuser where id=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setGender(resultset.getString("gender"));
				m.setAge(resultset.getString("age"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Member> selectByUsername(String username) {
		String sql="select * from allmember where username=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, username);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setGender(resultset.getString("gender"));
				m.setAge(resultset.getString("age"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return l;
	}
	
	public List<Member> selectByEmployeeName(String name){
		String sql="select * from employee where name=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, name);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setGender(resultset.getString("gender"));
				m.setAge(resultset.getString("age"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return l;
	}

	@Override
	public void updateMember(Member member) {
		String sql="update member set name=?,password=?,gender=?,age=?,address=?,mobile=? where id=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			
			preparedstatement.setString(1, member.getName());
			preparedstatement.setString(2, member.getPassword());
			preparedstatement.setString(3, member.getGender());
			preparedstatement.setString(4, member.getAge());
			preparedstatement.setString(5, member.getAddress());
			preparedstatement.setString(6, member.getMobile());
			preparedstatement.setInt(7, member.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateVipMember(Member vipmember) {
		String sql="update vipmember set name=?,password=?,gender=?,age=?,address=?,mobile=? where id=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			
			preparedstatement.setString(1, vipmember.getName());
			preparedstatement.setString(2, vipmember.getPassword());
			preparedstatement.setString(3, vipmember.getGender());
			preparedstatement.setString(4, vipmember.getAge());
			preparedstatement.setString(5, vipmember.getAddress());
			preparedstatement.setString(6, vipmember.getMobile());
			preparedstatement.setInt(7, vipmember.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployeeMember(Member employee) {
		String sql="update employee set name=?,password=?,gender=?,age=?,address=?,mobile=? where id=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			
			preparedstatement.setString(1, employee.getName());
			preparedstatement.setString(2, employee.getPassword());
			preparedstatement.setString(3, employee.getGender());
			preparedstatement.setString(4, employee.getAge());
			preparedstatement.setString(5, employee.getAddress());
			preparedstatement.setString(6, employee.getMobile());
			preparedstatement.setInt(7, employee.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateSuperuserMember(Member superuser) {
		String sql="update superuser set name=?,password=?,gender=?,age=?,address=?,mobile=? where id=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			
			preparedstatement.setString(1, superuser.getName());
			preparedstatement.setString(2, superuser.getPassword());
			preparedstatement.setString(3, superuser.getGender());
			preparedstatement.setString(4, superuser.getAge());
			preparedstatement.setString(5, superuser.getAddress());
			preparedstatement.setString(6, superuser.getMobile());
			preparedstatement.setInt(7, superuser.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateMemberPassword(Member member) {
		String sql="update member set password=? where id=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			
			preparedstatement.setString(1, member.getPassword());
			preparedstatement.setInt(2, member.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateVipMemberPassword(Member vipmember) {
		String sql="update vipmember set password=? where id=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			
			preparedstatement.setString(1, vipmember.getPassword());
			preparedstatement.setInt(2, vipmember.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMember(int id) {
		String sql="delete from member where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteVipMember(int id) {
		String sql="delete from vipmember where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployeeMember(int id) {
		String sql="delete from employee where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteSuperuserMember(int id) {
		String sql="delete from superuser where id=?";
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
