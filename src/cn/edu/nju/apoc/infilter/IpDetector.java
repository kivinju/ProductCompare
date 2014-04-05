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
			writer.println("<html><head><title>IP Blocked!</title></head><body><h1>IP Forbidden!</h1><img src=\"http://h.hiphotos.bdimg.com/album/s%3D550%3Bq%3D90%3Bc%3Dxiangce%2C100%2C100/sign=1d8e0e9479f40ad111e4c7e6671760e2/03087bf40ad162d9e5265bb013dfa9ec8b13cd55.jpg?referer=1bc68bd8e9f81a4c7f25d8f92b4b&x=.jpg\"/></body></html>");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
