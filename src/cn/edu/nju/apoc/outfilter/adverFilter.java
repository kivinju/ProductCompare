package cn.edu.nju.apoc.outfilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import cn.edu.nju.apoc.entity.Ads;
import cn.edu.nju.apoc.mydb.AdsDB;

/**
 * 
 * @author kivin
 *
 */

@WebFilter("/*")
public class adverFilter implements Filter{
	AdsDB db = new AdsDB();
	
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
				Document document = Jsoup.parse(resBody);
				Element head = document.select("head").first();
				head.append("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/news.css\"/>");
				
				Element body = document.select("body").first();
				@SuppressWarnings("deprecation")
				ArrayList<Ads> list= db.getURLs(request.getRealPath("img/news"));
				for(Ads ad:list){
					body.append("<a href=\"" + ad.getUrl() + "\"><img class=\"left\" src=\"" + ad.getUri() + "\" /></a>");
				}
				resBody = document.html();
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
	}
	
}
