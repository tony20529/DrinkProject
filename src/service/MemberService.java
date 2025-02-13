package service;

import java.util.List;

import model.Member;
import model.Porder;

public interface MemberService {
		//create
		void addMember(Member member);//加入會員
		void addVipMember(Member vipmember);//加入VIP
		void addEmployeeMember(Member employee);//加入員工
		void addSuperuserMember(Member superuser);//加入管理員
		
		
		//read
		Member Login(String username,String password);//驗證登入帳密是否正確
		boolean isUsernameBeenUse(String username);//驗證註冊的帳號是否有重複
		String AllMember();//觀看所有成員表單
		String AllGuest();//觀看所有成員表單
		Integer findLatestId();//查詢最新ID
		Member findByMemberId(int id);//查詢MemberID
		Member findByVipMemberId(int id);//查詢VIPMemberID
		Member findByEmployeeMemberId(int id);//查詢員工ID
		Member findBySuperuserMemberId(int id);//查詢管理員ID
		Member findByAllMemberId(int id);//查詢所有成員ID
		Member findByUsername(String username);//查詢帳號
		Member findByEmployeeName(String name);//查詢員工姓名
		//update
		void updateMember(int id,String name,String password,String gender,String age,String address,String mobile);//更改會員資料
		void updateMemberPassword(int id,String password);
		
		
		//delete
		void deleteMember(int id);//刪除會員資料
		

}
