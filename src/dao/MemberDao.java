package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
		//create
		void addMember(Member member);//加入會員
		void addVipMember(Member vipmember);//加入VIP
		void addEmployeeMember(Member employee);//加入員工
		void addSuperuserMember(Member superuser);//加入管理員
		
		//read
		List<Member> selectAllGuest();//觀看客戶表單
		List<Member> selectAll();//觀看所有成員表單
		List<Member> selectUsernameAndPassword(String username,String password);
		//讀取帳號與密碼的資料
		List<Member> selectById(int id);
		//用ID讀取會員資料
		List<Member> selectByMemberId(int id);
		//用ID讀取一般會員資料
		List<Member> selectByVipMemberId(int id);
		//用ID讀取VIP一般會員資料
		List<Member> selectByEmployeeMemberId(int id);
		//用ID讀取員工資料
		List<Member> selectBySuperuserMemberId(int id);
		//用ID讀取管理員資料
		List<Member> selectByUsername(String username);
		//用帳號讀取會員資料
		List<Member> selectByEmployeeName(String name);
		//用員工姓名讀取員工資料
		
		//update
		void updateMember(Member member);//更改會員資料
		void updateVipMember(Member vipmember);//更改VIP資料
		void updateEmployeeMember(Member employee);//更改員工資料
		void updateSuperuserMember(Member superuser);//更改管理員資料
		void updateMemberPassword(Member member);//更改會員密碼
		void updateVipMemberPassword(Member member);//更改會員密碼
		
		//delete
		void deleteMember(int id);//刪除會員資料
		void deleteVipMember(int id);//刪除VIP資料
		void deleteEmployeeMember(int id);//刪除員工資料
		void deleteSuperuserMember(int id);//刪除管理員資料

}
