package org.jboss.jsf.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.jboss.jsf.excel.util.CdiUtil;


/**
 * A Seam component that binds the HttpServletRequest object
 * to the current thread.
 * 
 * @author Gavin King
 */
@Named("org.jboss.seam.web.servletContexts")
@RequestScoped
public class ServletContexts 
{
   
   private HttpServletRequest request;
   
   public static ServletContexts instance()
   {
      return (ServletContexts) CdiUtil.getInstance(ServletContexts.class);
   }
   
   public static ServletContexts getInstance()
   {
	  return (ServletContexts) CdiUtil.getInstance(ServletContexts.class);
   }

   public HttpServletRequest getRequest()
   {
      return request;
   }

   public void setRequest(HttpServletRequest request)
   {
      this.request = request;
   }
   
}
