package cn.edu.nju.apoc.helper;

import java.io.StringReader;
import java.util.ArrayList;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

/**
 * The NLP module use this class to split title into words
 *
 */
public class SplitMachine {
	
	public ArrayList<String> split(String origin) {
		String str = origin;
		
		ArrayList<String> results = new ArrayList<String>();
		StringReader reader = new StringReader(str); 
	    IKSegmenter ik = new IKSegmenter(reader,true);
	    Lexeme lexeme = null;
	    try {
	    	while((lexeme = ik.next())!=null)
	    		results.add(lexeme.getLexemeText()); 
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return results;
	}
}