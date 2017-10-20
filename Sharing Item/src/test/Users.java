package test;

import java.util.ArrayList;

public class Users {

	private String id; // 아이디
	private String userImgUrl; // 유저 사진 url
	private String name; // 닉네임
	private String address; // 주소
	private String sex; // 성별

	
	
	private String password; // 비번
	private int age; // 나이

	private String phoneAdress; // 핸드폰 번호

	private String Usercomment; // 유저코멘트

	
	
	public Users(String id, String userImgUrl, String name, String address, String sex, String password, int age,
			String phoneAdress, String usercomment) {

		this.id = id;
		this.userImgUrl = userImgUrl;
		this.name = name;
		this.address = address;
		this.sex = sex;
		this.password = password;
		this.age = age;
		this.phoneAdress = phoneAdress;
		Usercomment = usercomment;
	}

	// private ArrayList<Item> userItemArr; //유저 아이템 ArrayList

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneAdress(String phoneAdress) {
		this.phoneAdress = phoneAdress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setUsercomment(String usercomment) {
		Usercomment = usercomment;
	}

	public void setUserImgUrl(String userImgUrl) {
		this.userImgUrl = userImgUrl;
	}

	// public void setUserItemArr(ArrayList<Item> userItemArr) {
	// this.userItemArr = userItemArr;
	// }
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
	// public ArrayList<Item> getUserItemArr() {
	// return userItemArr;
	// }

}
