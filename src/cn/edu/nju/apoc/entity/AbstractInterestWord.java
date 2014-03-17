package cn.edu.nju.apoc.entity;

/**
 * AbstractInterestWord entity provides the base persistence definition of the
 * InterestWord entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractInterestWord implements java.io.Serializable {

	// Fields

	private Integer iid;
	private String word;
	private String seller;

	// Constructors

	/** default constructor */
	public AbstractInterestWord() {
	}

	/** full constructor */
	public AbstractInterestWord(String word, String seller) {
		this.word = word;
		this.seller = seller;
	}

	// Property accessors

	public Integer getIid() {
		return this.iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getSeller() {
		return this.seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

}