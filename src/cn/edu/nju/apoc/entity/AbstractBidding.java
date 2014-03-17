package cn.edu.nju.apoc.entity;

/**
 * AbstractBidding entity provides the base persistence definition of the
 * Bidding entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBidding implements java.io.Serializable {

	// Fields

	private Integer bidid;
	private Products products;
	private Integer money;

	// Constructors

	/** default constructor */
	public AbstractBidding() {
	}

	/** full constructor */
	public AbstractBidding(Products products, Integer money) {
		this.products = products;
		this.money = money;
	}

	// Property accessors

	public Integer getBidid() {
		return this.bidid;
	}

	public void setBidid(Integer bidid) {
		this.bidid = bidid;
	}

	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Integer getMoney() {
		return this.money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

}