package test;

public class Review {
	
	
	int reviewsItemNum;
	String date;
	String user;
	
	private int score;
	private String statement;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getReviewsItemNum() {
		return reviewsItemNum;
	}
















	public String getDate() {
		return date;
	}
















	public String getUser() {
		return user;
	}
















	public int getScore() {
		return score;
	}
















	public String getStatement() {
		return statement;
	}
















	public Review(int reviewItemNum, String date, int score, String statement,String user ) {
	
		this.reviewsItemNum = reviewItemNum;
		this.date = date;
		this.user = user;
		this.score = score;
		this.statement = statement;
	}
	





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}