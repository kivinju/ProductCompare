package cn.edu.nju.apoc.entity;

/**
 * InterestWord entity. @author MyEclipse Persistence Tools
 */
public class InterestWord extends AbstractInterestWord implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public InterestWord() {
	}

	/** full constructor */
	public InterestWord(String word, String seller) {
		super(word, seller);
	}

}
