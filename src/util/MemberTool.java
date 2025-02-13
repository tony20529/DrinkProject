package util;

import java.util.regex.Pattern;

public class MemberTool {
	public static boolean AddName(String name){
		return !Pattern.matches("^[a-zA-Z\\u4e00-\\u9fa5]{2,10}|[a-zA-Z]{1,10}$", name);
	}
	public static boolean AddUsername(String username) {
		return !Pattern.matches("^[a-zA-Z0-9]{6,10}$", username);
	}
	public static boolean AddPassword(String password) {
		return !Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z0-9]{6,12}$", password);
	}
	public static boolean AddAge(String age) {
		return !Pattern.matches("^(7|[8-9]|[1-9][0-9]|1[0-4][0-9]|150)$", age);
	}
	public static boolean AddMobile(String mobile) {
		return !Pattern.matches("^09[0-9]{8}$", mobile);
	}
	public static boolean AddAddress(String address) {
		return !Pattern.matches("(?<city>\\D+[縣市])(?<district>\\D+?(市區|鎮區|鎮市|[鄉鎮市區]))(?<others>.+)", address);
	}
	public static boolean Id(String id) {
		return !Pattern.matches("^[0-9]*$", id);
	}
}
