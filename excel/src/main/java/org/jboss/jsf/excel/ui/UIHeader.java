package org.jboss.jsf.excel.ui;

import javax.faces.component.FacesComponent;

@FacesComponent(
		createTag=true,
		tagName="header",
		namespace="http://jboss.org/jsf/excel",
		value="org.jboss.jsf.excel.ui.UIHeader")
public class UIHeader extends ExcelComponent
{
   public static final String COMPONENT_TYPE = "org.jboss.jsf.excel.ui.UIHeader";

   public static final String LEFT_FACET = "left";
   public static final String CENTER_FACET = "center";
   public static final String RIGHT_FACET = "right";

   @Override
   public String getFamily()
   {
      return COMPONENT_TYPE;
   }

}
