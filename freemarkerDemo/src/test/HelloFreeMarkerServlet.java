package test;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloFreeMarkerServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Configuration cfg  = null;
	
	public void init() throws ServletException
	{
		cfg = new Configuration();
		cfg.setServletContextForTemplateLoading(getServletContext(),"/WEB-INF/templates");
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException
	{
		Map root = new HashMap();
		root.put("message", "hello world");
		root.put("name", "уелн");
		
		Template tp = cfg.getTemplate("test.ftl");
		response.setContentType("text/html;charset="+tp.getEncoding());
		Writer out = response.getWriter();
		try
		{
			tp.process(root, out);
		}
		catch(TemplateException e)
		{
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException
	{
		doPost(request,response);
	}
}
