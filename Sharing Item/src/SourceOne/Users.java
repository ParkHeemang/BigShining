package SourceOne;

import java.util.ArrayList;

public class Users {
	
	
	private String id;                 //���̵�
	private String password;			//���
	private String address;				//�ּ�
	private String phoneAdress;			//�ڵ��� ��ȣ
	
	
	private String name;				//�г���
	private String sex;					//����
	private int age;					//����
	private String Usercomment;			//�����ڸ�Ʈ
	private String userImgUrl;			//���� ���� url
	private ArrayList<Item> userItemArr;		//���� ������ ArrayList
	
	
	
	
	
	
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
