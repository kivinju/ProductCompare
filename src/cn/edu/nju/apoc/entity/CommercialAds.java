package cn.edu.nju.apoc.entity;

import java.io.FileInputStream;

/**
 * CommercialAds entity. @author MyEclipse Persistence Tools
 */
public class CommercialAds extends AbstractCommercialAds implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public CommercialAds() {
	}

	/** full constructor */
	public CommercialAds(Integer money, byte[] content, String url) {
		super(money, content, url);
	}
	
}
