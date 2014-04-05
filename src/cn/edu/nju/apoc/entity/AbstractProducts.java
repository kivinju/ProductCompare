package cn.edu.nju.apoc.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractProducts entity provides the base persistence definition of the
 * Products entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractProducts implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String name;
	private Integer price;
	private String site;
	private byte[] img;
	private Set biddings = new HashSet(0);
	private Set commentses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractProducts() {
	}

	/** minimal constructor */
	public AbstractProducts(String name, Integer price, String site, byte[] img) {
		this.name = name;
		this.price = price;
		this.site = site;
		this.img = img;
	}

	/** full constructor */
	public AbstractProducts(String name, Integer price, String site,
			byte[] img, Set biddings, Set commentses) {
		this.name = name;
		this.price = price;
		this.site = site;
		this.img = img;
		this.biddings = biddings;
		this.commentses = commentses;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public byte[] getImg() {
		return this.img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Set getBiddings() {
		return this.biddings;
	}

	public void setBiddings(Set biddings) {
		this.biddings = biddings;
	}

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

}