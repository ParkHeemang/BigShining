package test;

public class Item {
	
	
	
	private static int itemNum=0;
	private String owner;					//아이템의 소유자	
	private String type;					//아이템 분류
	private int fee;						//아이템 대여비
	private String brand;
					
	private int available;				//아이템 이용가능여부

				

	ItemDAO itemdao = new ItemDAO();
	
	
	
	
	
	
	
	
	
	
	public Item(String owner,String type,
			int fee, int available, String brand) {
	
		this.owner = owner;
		
		this.type = type;
		this.fee = fee;
		this.available = available;
		itemNum++;
	
		
		
		
		
	
	}
	
	
	
	public String getBrand() {
		
		return brand;
	}
	
	public int getItemNum() {
		return itemNum;
		
		
	}
	
	public void setBrand(String brand) {
		
		
		this.brand = brand;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	
	
	public String getOwner() {
		return owner;
	}
	public String getType() {
		return type;
	}
	public int getFee() {
		return fee;
	}
	
	public int getAvailable() {
		return available;
	}


	

}
