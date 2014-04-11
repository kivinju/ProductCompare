package cn.edu.nju.apoc.entity;

import java.util.Iterator;
import java.util.Set;

/**
 * Products entity. @author MyEclipse Persistence Tools
 */
public class Products extends AbstractProducts implements java.io.Serializable,Comparable {

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

	@Override
	public int compareTo(Object o) {
		int curBid = 0;
		int otherBid = 0;
		if(!this.getBiddings().isEmpty()){
			Iterator<Bidding> bids = this.getBiddings().iterator();
			curBid = bids.next().getMoney();
		}
		if(!((Products)o).getBiddings().isEmpty()){
			Iterator<Bidding> bids =((Products)o).getBiddings().iterator();
			otherBid = bids.next().getMoney();
		}
		
		return otherBid-curBid;
	}

}
