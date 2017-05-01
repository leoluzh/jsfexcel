package org.jboss.jsf.core;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.jboss.jsf.excel.util.CdiUtil;

/**
 * Manager component for the current locale. This base
 * implementation simply returns the server default 
 * locale.
 * 
 * @author Gavin King
 */

@Named("org.jboss.seam.core.locale")
@RequestScoped
public class Locale 
{

   public java.util.Locale getLocale()
   {
      return java.util.Locale.getDefault();
   }
     
   public static java.util.Locale instance()
   {
	   /**
       if ( Contexts.isApplicationContextActive() ) 
       {
          return (java.util.Locale) Component.getInstance(Locale.class, ScopeType.STATELESS);
       } 
       else 
       {
          return java.util.Locale.getDefault(); //for unit tests
       }
       **/
	   
	   return CdiUtil.getInstance(Locale.class);
	   
	   
   }
}
