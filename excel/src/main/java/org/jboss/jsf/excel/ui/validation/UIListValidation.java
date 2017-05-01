package org.jboss.jsf.excel.ui.validation;

import javax.faces.component.FacesComponent;

import org.jboss.jsf.excel.ui.ExcelComponent;

@FacesComponent(
		createTag=true,
		tagName="list-validation",
		namespace="http://jboss.org/jsf/excel",
		value="org.jboss.jsf.excel.ui.validation.UIListValidation")
public class UIListValidation extends ExcelComponent implements Validation
{
   public static final String COMPONENT_TYPE = "org.jboss.jsf.excel.ui.validation.UIListValidation";

   @Override
   public String getFamily()
   {
      return COMPONENT_TYPE;
   }

   public ValidationType getType()
   {
      return ValidationType.list;
   }
}
