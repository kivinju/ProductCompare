package cn.edu.nju.apoc.entity;

public class RealProduct {
	private Products p;
	private String url;
	
	public RealProduct(Products p, String url) {
		super();
		this.p = p;
		this.url = url;
	}
	
	public Products getProduct() {
		return p;
	}
	public void setProduct(Products p) {
		this.p = p;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
