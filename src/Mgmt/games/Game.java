package Mgmt.games;

import java.io.Serializable;

public class Game implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private double rating;
	private int stock;
	private double price;
	private String info;
	private String genre;
	private String image;
	
	public Game(){
	}
	
	public Game(int id, String name, double rating, int stock, double price, String info, String genre, String image){
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.stock = stock;
		this.price = price;
		this.info = info;
		this.genre = genre;
		this.image = image;
	}
	
	public int getID(){
		return id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public double getRating(){
		return rating;
	}
	
	public void setRating(double rating){
		this.rating = rating;
	}
	
	public int getStock(){
		return stock;
	}
	
	public void setStock(int stock){
		this.stock = stock;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public String getInfo(){
		return info;
	}
	
	public void setInfo(String info){
		this.info = info;
	}
	
	public String getGenre(){
		return genre;
	}
	
	public void setGenre(String genre){
		this.info = genre;
	}
	
	public String getImage(){
		return image;
	}
	
	public void setImage(String image){
		this.image = image;
	}
}
