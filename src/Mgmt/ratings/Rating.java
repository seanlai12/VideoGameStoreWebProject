package Mgmt.ratings;

import java.io.Serializable;

public class Rating implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int gameID;
	private String raterinfo;
	private String date;
	private double rating;
	private String comment;
	
	public Rating(){
	}
	
	public Rating(int gameID, String raterinfo, String date, double rating, String comment){
		
		this.gameID = gameID;
		this.raterinfo = raterinfo;
		this.date = date;
		this.rating = rating;
		this.comment = comment;
	}
	
	public int getGameID(){
		return gameID;
	}
	
	public void setGameID(int gameID){
		this.gameID = gameID;
	}
	
	public String getRaterinfo(){
		return raterinfo;
	}
	
	public void setRaterinfo(String raterinfo){
		this.raterinfo = raterinfo;
	}

	public String getDate(){
		return date;
	}
	
	public void setDate(String date){
		this.date = date;
	}

	public double getRating(){
		return rating;
	}
	
	public void setRating(double rating){
		this.rating = rating;
	}
	
	public String getComment(){
		return comment;
	}
	
	public void setComment(String comment){
		this.comment = comment;
	}

}
