package SourceOne;

import java.util.ArrayList;

public class Users {
	
	
	private String id;                 //아이디
	private String password;			//비번
	private String address;				//주소
	private String phoneAdress;			//핸드폰 번호
	
	
	private String name;				//닉네임
	private String sex;					//성별
	private int age;					//나이
	private String Usercomment;			//유저코멘트
	private String userImgUrl;			//유저 사진 url
	private ArrayList<Item> userItemArr;		//유저 아이템 ArrayList
	
	
	
	
	
	
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneAdress() {
		return phoneAdress;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public int getAge() {
		return age;
	}
	public String getUsercomment() {
		return Usercomment;
	}
	public String getUserImgUrl() {
		return userImgUrl;
	}
	public ArrayList<Item> getUserItemArr() {
		return userItemArr;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
