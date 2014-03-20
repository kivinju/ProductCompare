package cn.edu.nju.apoc.outfilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author kivin
 *
 */

@WebFilter("/*")
public class adverFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		BufferedResponse resWrapper = new BufferedResponse((HttpServletResponse)response);
		chain.doFilter(request, resWrapper);
		
		if (resWrapper.getOutputType() == BufferedResponse.OT_WRITER) {
			String resBody = new String(resWrapper.toByteArray(),resWrapper.getCharacterEncoding());

			if (resWrapper.getContentType().startsWith("text/html")) {
				resBody = resBody.replaceAll("JSP", "SOPHIA");
				response.setContentLength(resBody.length());
			}
			PrintWriter writer = response.getWriter();
			writer.println(resBody);
		} else if (resWrapper.getOutputType() == BufferedResponse.OT_OUTPUT_STREAM) {
			ServletOutputStream out = response.getOutputStream();
			out.write(resWrapper.toByteArray());
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
