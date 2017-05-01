package org.jboss.jsf.excel.ui;

import javax.faces.component.FacesComponent;

@FacesComponent(
		createTag=true,
		tagName="link",
		namespace="http://jboss.org/jsf/excel",
		value="org.jboss.jsf.excel.ui.UILink")
public class UILink extends ExcelComponent
{
   private static final String COMPONENT_TYPE = "org.jboss.jsf.excel.ui.UILink";
   
   private String URL;
   
   public String getURL()
   {
      return (String) valueOf("URL", URL);
   }

   public void setURL(String url)
   {
      URL = url;
   }

   @Override
   public String getFamily()
   {
      return COMPONENT_TYPE;
   }

}
