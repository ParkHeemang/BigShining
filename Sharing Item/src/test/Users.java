package test;

import java.util.ArrayList;

public class Users {

	private String id; // ���̵�
	private String userImgUrl; // ���� ���� url
	private String name; // �г���
	private String address; // �ּ�
	private String sex; // ����

	
	
	private String password; // ���
	private int age; // ����

	private String phoneAdress; // �ڵ��� ��ȣ

	private String Usercomment; // �����ڸ�Ʈ

	
	
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

	// private ArrayList<Item> userItemArr; //���� ������ ArrayList

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
