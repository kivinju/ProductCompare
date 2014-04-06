package cn.edu.nju.apoc.entity;

import java.util.Set;

/**
 * Products entity. @author MyEclipse Persistence Tools
 */
public class Products extends AbstractProducts implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Products() {
	}

	/** minimal constructor */
	public Products(String name, double price, String site, byte[] img) {
		super(name, price, site, img);
	}

	/** full constructor */
	public Products(String name, double price, String site, byte[] img,
			Set biddings, Set comments) {
		super(name, price, site, img, biddings, comments);
	}

}
