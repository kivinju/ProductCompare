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
import cn.edu.nju.apoc.mydb.CommentDB;

/**
 * @creator kivin
 * @author xunan there works: 1,sensitive words 2,ˮ�� 3,����̼Ҹ���Ȥ�Ĺؼ�ʼ��
 */
@WebFilter("/user/comment")
public class commentFilter implements Filter {
	CommentDB db = new CommentDB();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String comment = request.getParameter("comment");
		if (comment != null) {
			ArrayList<String> comments = new SplitMachine().split(comment);
			boolean pass = db.pass(comments);
			request.setAttribute("result", pass);
			if (pass) {
				ArrayList<String> sellers = db.getSellers(comments);
				request.setAttribute("interest", sellers);
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
