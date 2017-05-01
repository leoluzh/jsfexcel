package org.jboss.jsf.excel.ui;

import javax.faces.component.FacesComponent;

@FacesComponent(
			createTag=true,
			tagName="formula",
			namespace="http://jboss.org/jsf/excel",
			value="org.jboss.jsf.excel.ui.UIFormula")
public class UIFormula extends UICell
{
   public static final String COMPONENT_TYPE = "org.jboss.jsf.excel.ui.UIFormula";

   @Override
   public String getFamily()
   {
      return COMPONENT_TYPE;
   }
   
}
