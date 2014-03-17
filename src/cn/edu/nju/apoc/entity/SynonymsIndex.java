package cn.edu.nju.apoc.entity;

import java.util.Set;

/**
 * SynonymsIndex entity. @author MyEclipse Persistence Tools
 */
public class SynonymsIndex extends AbstractSynonymsIndex implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public SynonymsIndex() {
	}

	/** minimal constructor */
	public SynonymsIndex(String word) {
		super(word);
	}

	/** full constructor */
	public SynonymsIndex(String word, Set synonymsIndexesForId1,
			Set synonymsIndexesForId2) {
		super(word, synonymsIndexesForId1, synonymsIndexesForId2);
	}

}
