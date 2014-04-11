package cn.edu.nju.apoc.entity;

public class RealProduct extends Products{
	private String url;
	
	public RealProduct(Products p, String url) {
		super(p.getName(),p.getPrice(),p.getSite(),p.getImg(),p.getBiddings(),p.getCommentses());
		setPid(p.getPid());
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}

