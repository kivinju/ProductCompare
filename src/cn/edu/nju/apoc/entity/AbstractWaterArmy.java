package cn.edu.nju.apoc.entity;

/**
 * AbstractWaterArmy entity provides the base persistence definition of the
 * WaterArmy entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWaterArmy implements java.io.Serializable {

	// Fields

	private Integer wid;
	private String ip;

	// Constructors

	/** default constructor */
	public AbstractWaterArmy() {
	}

	/** full constructor */
	public AbstractWaterArmy(String ip) {
		this.ip = ip;
	}

	// Property accessors

	public Integer getWid() {
		return this.wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}