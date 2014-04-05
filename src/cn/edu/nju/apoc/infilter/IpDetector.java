package cn.edu.nju.apoc.infilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import cn.edu.nju.apoc.mydb.IPDB;

/**
 * @creator kivin
 * @author zongyanqi
 *
 */

@WebFilter(urlPatterns="/*")
public class IpDetector implements Filter{

	private IPDB db = new IPDB();
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		boolean pass = db.pass(request.getRemoteAddr());
		if(!pass){
			PrintWriter writer = response.getWriter();
			writer.println("<html><head><title>IP Blocked!</title></head><body><h1>IP Forbidden!</h1><img src=\"http://pic27.nipic.com/20130221/11952988_150523398187_2.jpg\"/></body></html>");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
