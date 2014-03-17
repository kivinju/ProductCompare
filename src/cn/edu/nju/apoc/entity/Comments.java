package cn.edu.nju.apoc.entity;

import java.sql.Timestamp;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */
public class Comments extends AbstractComments implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** full constructor */
	public Comments(Products products, String ip, Timestamp createtime,
			String comments) {
		super(products, ip, createtime, comments);
	}

}
