package cn.edu.nju.apoc.entity;

/**
 * AbstractCommercialAds entity provides the base persistence definition of the
 * CommercialAds entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCommercialAds implements java.io.Serializable {

	// Fields

	private Integer adid;
	private Integer money;
	private String content;
	private String url;

	// Constructors

	/** default constructor */
	public AbstractCommercialAds() {
	}

	/** full constructor */
	public AbstractCommercialAds(Integer money, String content, String url) {
		this.money = money;
		this.content = content;
		this.url = url;
	}

	// Property accessors

	public Integer getAdid() {
		return this.adid;
	}

	public void setAdid(Integer adid) {
		this.adid = adid;
	}

	public Integer getMoney() {
		return this.money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}