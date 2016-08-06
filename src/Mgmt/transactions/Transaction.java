package Mgmt.transactions;

import java.io.Serializable;

public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int gameid;
	private int quantity;
	private String date;
	
	public Transaction(){
	}
	
	public Transaction(String name, int gameid, int quantity, String date){
		this.name = name;
		this.gameid = gameid;
		this.quantity = quantity;
		this.date = date;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getGameid(){
		return gameid;
	}
	
	public void setGameid(int gameid){
		this.gameid = gameid;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	
	public String getDate(){
		return date;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	
}
