package test;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
	
		
		ItemDAO itemdao = new ItemDAO();
		ReviewDAO reviewdao = new ReviewDAO();
		ArrayList<Review> reviewArr= new ArrayList<>();

		
	
		
		reviewArr = reviewdao.selectReviewsByItemNum(1);
		
		for (int i = 0; i < reviewArr.size(); i++) {
			
			System.out.println(reviewArr.get(i).getScore());
			
		}
		
		
		
		
		
		

	}

}
