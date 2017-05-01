package org.jboss.jsf.core;

import java.io.InputStream;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.jboss.jsf.excel.util.CdiUtil;


/**
 * Access to application resources and resource bundles.
 * 
 * @author Gavin King
 *
 */

@Named("org.jboss.seam.core.resourceLoader")
@RequestScoped
public class ResourceLoader
{
   private static final Logger log = Logger.getLogger(ResourceLoader.class.getName());
   
   private String[] bundleNames = {"messages"};
   
   /**
    * The configurable list of delegate resource bundle names
    * 
    * @return an array of resource bundle names
    */
   public String[] getBundleNames() 
   {
      return bundleNames;
   }
   
   public void setBundleNames(String[] bundleNames) 
   {
      this.bundleNames = bundleNames;
   }
   
   public InputStream getResourceAsStream(String resource)
   {
      return Resources.getResourceAsStream( resource, ServletLifecycle.getCurrentServletContext() );
   }
   
   public URL getResource(String resource) 
   {
      return Resources.getResource( resource, ServletLifecycle.getCurrentServletContext() );
   }
   
   /**
    * Load a resource bundle by name (may be overridden by subclasses
    * who want to use non-standard resource bundle types).
    * 
    * @param bundleName the name of the resource bundle
    * @return an instance of java.util.ResourceBundle
    */
   public java.util.ResourceBundle loadBundle(String bundleName) 
   {
      try
      {
         java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle( 
               bundleName, 
               Locale.instance(), 
               Thread.currentThread().getContextClassLoader() 
         );
         
         // for getting bundle from page level message properties
         if (bundle == null){
            bundle = java.util.ResourceBundle.getBundle( 
                  bundleName, 
                  Locale.instance(), 
                  ServletLifecycle.getCurrentServletContext().getClass().getClassLoader() 
            );
         }
         log.debug("loaded resource bundle: " + bundleName);
         return bundle;
      }
      catch (MissingResourceException mre)
      {
         log.debug("resource bundle missing: " + bundleName);
         return null;
      }
   }
   
   @Override
   public String toString()
   {
      String concat = bundleNames==null ? "" : StringUtils.joinWith(", ", (Object[]) bundleNames );
      return "ResourceBundle(" + concat + ")";
   }
   
   public static ResourceLoader instance()
   {
	  /**
      if (!Contexts.isApplicationContextActive()) {
         return new ResourceLoader();
      } else {
         return (ResourceLoader) Component.getInstance(ResourceLoader.class, ScopeType.STATELESS);
      }
      **/
	   return CdiUtil.getInstance(ResourceLoader.class);
   }
   
}
