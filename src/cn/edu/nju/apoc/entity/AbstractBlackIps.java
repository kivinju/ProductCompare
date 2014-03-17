package cn.edu.nju.apoc.entity;

/**
 * AbstractBlackIps entity provides the base persistence definition of the
 * BlackIps entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBlackIps implements java.io.Serializable {

	// Fields

	private Integer ipid;
	private String ip;

	// Constructors

	/** default constructor */
	public AbstractBlackIps() {
	}

	/** full constructor */
	public AbstractBlackIps(String ip) {
		this.ip = ip;
	}

	// Property accessors

	public Integer getIpid() {
		return this.ipid;
	}

	public void setIpid(Integer ipid) {
		this.ipid = ipid;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}