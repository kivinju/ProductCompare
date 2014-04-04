package cn.edu.nju.apoc.infilter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import cn.edu.nju.apoc.helper.SplitMachine;
import cn.edu.nju.apoc.mydb.SynonymDB;

/**
 * @creator kivin
 * @author yanning
 * 
 */

@WebFilter("/user/search")
public class synonymDetector implements Filter {
	private SynonymDB db = new SynonymDB();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String str = request.getParameter("searchString");
		if (str != null) {
			ArrayList<String> list = new SplitMachine().split(str);
			String r = "";

			for (String s : list) {
				r += db.getSynonym(s) + ";";
			}

			request.setAttribute("searchString", r);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
