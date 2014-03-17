package cn.edu.nju.apoc.entity;

/**
 * Bidding entity. @author MyEclipse Persistence Tools
 */
public class Bidding extends AbstractBidding implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Bidding() {
	}

	/** full constructor */
	public Bidding(Products products, Integer money) {
		super(products, money);
	}

}
