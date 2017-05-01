package org.jboss.jsf.excel.ui.validation;

import javax.faces.component.FacesComponent;

import org.jboss.jsf.excel.ui.ExcelComponent;

@FacesComponent(
		createTag=true,
		tagName="list-validation-item",
		namespace="http://jboss.org/jsf/excel",
		value="org.jboss.jsf.excel.ui.validation.UIListValidationItem")
public class UIListValidationItem extends ExcelComponent
{
   public static final String COMPONENT_TYPE = "org.jboss.jsf.excel.ui.validation.UIListValidationItem";

   private String value;

   public String getValue()
   {
      return (String) valueOf("value", value);
   }

   public void setValue(String value)
   {
      this.value = value;
   }

   @Override
   public String getFamily()
   {
      return COMPONENT_TYPE;
   }

}
