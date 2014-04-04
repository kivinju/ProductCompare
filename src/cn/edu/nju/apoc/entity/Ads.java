package cn.edu.nju.apoc.entity;

public class Ads {
	private String url;
	private String uri;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public Ads(String url,String uri){
		this.url = url;
		this.uri = uri;
	}
}
