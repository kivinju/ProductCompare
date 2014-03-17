package cn.edu.nju.apoc.entity;

/**
 * AbstractSensitives entity provides the base persistence definition of the
 * Sensitives entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSensitives implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String word;

	// Constructors

	/** default constructor */
	public AbstractSensitives() {
	}

	/** full constructor */
	public AbstractSensitives(String word) {
		this.word = word;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}