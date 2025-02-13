package service.impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import model.Member;
import model.Porder;
import service.MemberService;

public class MemberServiceImpl implements MemberService {

	public static void main(String[] args) {
		

	}

	private static MemberDaoImpl memberdaoimpl=new MemberDaoImpl();
	public void addMember(Member member) {
		memberdaoimpl.addMember(member);
		
	}

	@Override
	public void addVipMember(Member vipmember) {
		memberdaoimpl.addVipMember(vipmember);
		
	}

	@Override
	public void addEmployeeMember(Member employee) {
		memberdaoimpl.addEmployeeMember(employee);
		
	}

	@Override
	public void addSuperuserMember(Member superuser) {
		memberdaoimpl.addSuperuserMember(superuser);
		
	}

	@Override
	public Member Login(String username, String password) {
		Member member=null;
		List<Member> l=memberdaoimpl.selectUsernameAndPassword(username, password);
		if(l.size()!=0)
		{
			member=l.get(0);
		}		
		
		return member;
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		return memberdaoimpl.selectByUsername(username).isEmpty();
	}
	
	public String AllMember(){
		List<Member> l=memberdaoimpl.selectAll();
		String show="";
		
		for(Member p:l)
		{
			
			show=show+"客戶編號:"+p.getId()+
					"\t客戶姓名:"+p.getName()+
					"\t客戶帳號:"+p.getUsername()+
					"\t客戶密碼:"+p.getPassword()+
					"\t客戶性別:"+p.getGender()+
					"\t客戶年齡:"+p.getAge()+
					"\t客戶地址:"+p.getAddress()+
					"\t客戶電話:"+p.getMobile()+
					"\n";
		}
		
		
		return show;
	}
	
	public String AllGuest() {
		List<Member> l=memberdaoimpl.selectAllGuest();
		String show="";
		
		for(Member p:l)
		{
			
			show=show+"客戶編號:"+p.getId()+
					"\t客戶姓名:"+p.getName()+
					"\t客戶帳號:"+p.getUsername()+
					"\t客戶密碼:"+p.getPassword()+
					"\t客戶性別:"+p.getGender()+
					"\t客戶年齡:"+p.getAge()+
					"\t客戶地址:"+p.getAddress()+
					"\t客戶電話:"+p.getMobile()+
					"\n";
		}
		
		
		return show;
	}
	
	public Integer findLatestId() {
		List<Member> l=memberdaoimpl.selectAll();
		Integer id = null;
		for(Member p:l) {
			id=p.getId();
		}
		return id;
		
	}
	
	public Member findByMemberId(int id) {
		Member member=null;
		if(id>0)
		{
			List<Member> l=memberdaoimpl.selectByMemberId(id);
			if(l.size()>0)
			{
				member=l.get(0);
			}
			
		}	
		
		
		
		return member;
	}
	
	public Member findByVipMemberId(int id) {
		Member member=null;
		if(id>0)
		{
			List<Member> l=memberdaoimpl.selectByVipMemberId(id);
			if(l.size()>0)
			{
				member=l.get(0);
			}
			
		}
		return member;
	}
	
	public Member findByEmployeeMemberId(int id) {
		Member member=null;
		if(id>0)
		{
			List<Member> l=memberdaoimpl.selectByEmployeeMemberId(id);
			if(l.size()>0)
			{
				member=l.get(0);
			}
			
		}	
		return member;
	}
	
	public Member findBySuperuserMemberId(int id) {
		Member member=null;
		if(id>0)
		{
			List<Member> l=memberdaoimpl.selectBySuperuserMemberId(id);
			if(l.size()>0)
			{
				member=l.get(0);
			}
			
		}	
		return member;
	}
	
	public Member findByAllMemberId(int id) {
		Member member=null;
		if(id>0)
		{
			List<Member> l=memberdaoimpl.selectById(id);
			if(l.size()>0)
			{
				member=l.get(0);
			}
			
		}	
		return member;
	}
	public Member findByUsername(String username) {
		Member member=null;
		if(!new MemberServiceImpl().isUsernameBeenUse(username)) {
			List<Member> l=memberdaoimpl.selectByUsername(username);
			if(l.size()>0) 
			{
				member=l.get(0);
			}
		}
		return member;
	}

	public Member findByEmployeeName(String name) {
		Member member=null;
		List<Member> l=memberdaoimpl.selectByEmployeeName(name);
		if(l.size()>0) 
		{
			member=l.get(0);
		}
		return member;
	}

	@Override
	public void updateMember(int id,String name,String password,String gender,String age,String address,String mobile) {
		if(!memberdaoimpl.selectByMemberId(id).isEmpty()) {Member m=findByMemberId(id);m.setName(name);m.setPassword(password);m.setGender(gender);m.setAge(age);m.setAddress(address);m.setMobile(mobile);memberdaoimpl.updateMember(m);}
		else if(!memberdaoimpl.selectByVipMemberId(id).isEmpty()) {Member m=findByVipMemberId(id);m.setName(name);m.setPassword(password);m.setGender(gender);m.setAge(age);m.setAddress(address);m.setMobile(mobile);memberdaoimpl.updateVipMember(m);}
		else if(!memberdaoimpl.selectByEmployeeMemberId(id).isEmpty()) {Member m=findByEmployeeMemberId(id);m.setName(name);m.setPassword(password);m.setGender(gender);m.setAge(age);m.setAddress(address);m.setMobile(mobile);memberdaoimpl.updateEmployeeMember(m);}
		else if(!memberdaoimpl.selectBySuperuserMemberId(id).isEmpty()) {Member m=findBySuperuserMemberId(id);m.setName(name);m.setPassword(password);m.setGender(gender);m.setAge(age);m.setAddress(address);m.setMobile(mobile);memberdaoimpl.updateSuperuserMember(m);}
	}
	
	public void updateMemberPassword(int id,String password) {
		if(!memberdaoimpl.selectByMemberId(id).isEmpty()){Member m=findByMemberId(id);m.setPassword(password);memberdaoimpl.updateMember(m);}
		else if(!memberdaoimpl.selectByVipMemberId(id).isEmpty()){Member m=findByVipMemberId(id);m.setPassword(password);memberdaoimpl.updateVipMember(m);}
		else if(!memberdaoimpl.selectByEmployeeMemberId(id).isEmpty()) {Member m=findByEmployeeMemberId(id);m.setPassword(password);memberdaoimpl.updateEmployeeMember(m);}
		else if(!memberdaoimpl.selectBySuperuserMemberId(id).isEmpty()){Member m=findBySuperuserMemberId(id);m.setPassword(password);memberdaoimpl.updateSuperuserMember(m);}
	}

	

	@Override
	public void deleteMember(int id) {
		if(id>0)
		{
			if(!memberdaoimpl.selectByMemberId(id).isEmpty()){memberdaoimpl.deleteMember(id);}
			else if(!memberdaoimpl.selectByVipMemberId(id).isEmpty()){memberdaoimpl.deleteVipMember(id);}
			else if(!memberdaoimpl.selectByEmployeeMemberId(id).isEmpty()){memberdaoimpl.deleteEmployeeMember(id);}
			else if(!memberdaoimpl.selectBySuperuserMemberId(id).isEmpty()){memberdaoimpl.deleteSuperuserMember(id);}
		}
		
	}

	

}
