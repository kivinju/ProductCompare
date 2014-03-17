package cn.edu.nju.apoc.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractSynonymsIndex entity provides the base persistence definition of the
 * SynonymsIndex entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSynonymsIndex implements java.io.Serializable {

	// Fields

	private Integer synoid;
	private String word;
	private Set synonymsIndexesForId1 = new HashSet(0);
	private Set synonymsIndexesForId2 = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractSynonymsIndex() {
	}

	/** minimal constructor */
	public AbstractSynonymsIndex(String word) {
		this.word = word;
	}

	/** full constructor */
	public AbstractSynonymsIndex(String word, Set synonymsIndexesForId1,
			Set synonymsIndexesForId2) {
		this.word = word;
		this.synonymsIndexesForId1 = synonymsIndexesForId1;
		this.synonymsIndexesForId2 = synonymsIndexesForId2;
	}

	// Property accessors

	public Integer getSynoid() {
		return this.synoid;
	}

	public void setSynoid(Integer synoid) {
		this.synoid = synoid;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Set getSynonymsIndexesForId1() {
		return this.synonymsIndexesForId1;
	}

	public void setSynonymsIndexesForId1(Set synonymsIndexesForId1) {
		this.synonymsIndexesForId1 = synonymsIndexesForId1;
	}

	public Set getSynonymsIndexesForId2() {
		return this.synonymsIndexesForId2;
	}

	public void setSynonymsIndexesForId2(Set synonymsIndexesForId2) {
		this.synonymsIndexesForId2 = synonymsIndexesForId2;
	}

}