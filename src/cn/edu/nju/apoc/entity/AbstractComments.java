package cn.edu.nju.apoc.entity;

import java.sql.Timestamp;

/**
 * AbstractComments entity provides the base persistence definition of the
 * Comments entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractComments implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Products products;
	private String ip;
	private Timestamp createtime;
	private String comments;

	// Constructors

	/** default constructor */
	public AbstractComments() {
	}

	/** full constructor */
	public AbstractComments(Products products, String ip, Timestamp createtime,
			String comments) {
		this.products = products;
		this.ip = ip;
		this.createtime = createtime;
		this.comments = comments;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}