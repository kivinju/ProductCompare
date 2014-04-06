package cn.edu.nju.apoc.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Synonym implements Serializable {
	
	private int id;
	private String word;
	private ArrayList<Synonym> list;
	
	public Synonym(int id,String word) {
		this.id = id;
		this.word = word;
		this.list = new ArrayList<Synonym>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public ArrayList<Synonym> getList() {
		return list;
	}
	public void setList(ArrayList<Synonym> list) {
		this.list = list;
	}
	
}
