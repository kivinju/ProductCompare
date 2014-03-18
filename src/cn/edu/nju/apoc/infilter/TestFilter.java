package cn.edu.nju.apoc.infilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

import com.sun.corba.se.impl.protocol.RequestDispatcherRegistryImpl;

@WebFilter(urlPatterns="/*")
public class TestFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("================filter==================");
		//RequestDispatcher dispatcher = new RequestDispatcherRegistryImpl(orb, defaultId)
//		((HttpServletResponse)arg1).sendRedirect("");
		HttpServletRequest request=((HttpServletRequest)arg0);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/jsp/test.jsp");
		requestDispatcher.forward(arg0, arg1);
//		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
