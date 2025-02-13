package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import controller.member.AddMemberErrorUI;
import controller.member.AddMemberSuccessUI;
import controller.member.AddMemberUI;
import controller.member.GuestManagementUI;
import controller.member.LoginErrorUI;
import controller.member.LoginSuccessUI;
import controller.member.LoginUI;
import controller.member.MemberManagementUI;
import controller.member.UpdateMemberUI;
import controller.porder.PorderUI;

	//存檔資料:

	public class Tool {
	public static void save(Object s,String filename) {
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			oos.writeObject(s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//讀取資料:
	
	public static Object read(String filename) {
		Object o=null;
		FileInputStream fis;
		try {
			fis = new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			o=ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
		
	}

	
	//時間控制:
	
		public static String format(int number)
		{
			return number<10?"0"+number:""+number;
		}
		
		public static String Week(int number)
		 {
		  String[] x={"日","一","二","三","四","五","六"};
		  return "("+x[number]+")";
		 }
		
		public static String getTime()
		{
			Calendar calendar=new GregorianCalendar ();
			int Year=calendar.get (Calendar.YEAR);
			int Month=calendar.get(Calendar.MONTH)+1;
			int Date=calendar.get (Calendar.DAY_OF_MONTH);
			int Week=calendar.get(Calendar.DAY_OF_WEEK)-1;
			int Hour=calendar.get (Calendar.HOUR_OF_DAY);
			int Minute=calendar.get (Calendar.MINUTE);
			int Second=calendar.get(Calendar.SECOND) ;
			return format(Year)+"/"+format(Month)+"/"+format(Date)+Week(Week)+format(Hour)+":"+format(Minute)+":"+format(Second);
		}	
		
		public static String getTime1()
		{
			Calendar calendar=new GregorianCalendar ();
			int Year=calendar.get (Calendar.YEAR);
			int Month=calendar.get(Calendar.MONTH)+1;
			int Date=calendar.get (Calendar.DAY_OF_MONTH);
			int Hour=calendar.get (Calendar.HOUR_OF_DAY);
			int Minute=calendar.get (Calendar.MINUTE);
			return format(Year)+"/"+format(Month)+"/"+format(Date)+" "+format(Hour)+":"+format(Minute);
		}	
	
	//登入頁面:
		public static void Login() {
			LoginUI login=new LoginUI();
			login.setVisible(true);
		}
	//登入成功頁面:
		public static void LoginSeccess() {
			LoginSuccessUI loginsuccess=new LoginSuccessUI();
			loginsuccess.setVisible(true);
		}
	//登入失敗頁面:
		public static void LoginError() {
			LoginErrorUI loginerror=new LoginErrorUI();
			loginerror.setVisible(true);
		}
	//註冊頁面:
		public static void AddMember() {
			AddMemberUI addmember=new AddMemberUI();
			addmember.setVisible(true);
		}
	//註冊成功頁面:
		public static void AddMemberSuccess() {
			AddMemberSuccessUI addmembersuccess=new AddMemberSuccessUI();
			addmembersuccess.setVisible(true);
		}
	//註冊失敗頁面:
		public static void AddMemberError() {
			AddMemberErrorUI addmembererror=new AddMemberErrorUI();
			addmembererror.setVisible(true);
		}
	//個資更改頁面:
		public static void UpdateMember() {
			UpdateMemberUI updatemember=new UpdateMemberUI();
			updatemember.setVisible(true);
		}
	//客人管理頁面:
		public static void GuestManagement() {
			GuestManagementUI guestmanagement=new GuestManagementUI();
			guestmanagement.setVisible(true);
		}
	//客戶管理頁面:
		public static void MemberManagement() {
			MemberManagementUI membermanagement=new MemberManagementUI();
			membermanagement.setVisible(true);
		}
	//購物頁面：
		public static void Porder() {
			PorderUI porder=new PorderUI();
			porder.setVisible(true);
		}
	
}
