package org.jboss.jsf.excel.ui.validation;

import javax.faces.component.FacesComponent;

import org.jboss.jsf.excel.ui.ExcelComponent;

@FacesComponent(
		createTag=true,
		tagName="numeric-validation",
		namespace="http://jboss.org/jsf/excel",
		value="org.jboss.jsf.excel.ui.validation.UINumericValidation")
public class UINumericValidation extends ExcelComponent implements Validation
{
   public static final String COMPONENT_TYPE = "org.jboss.jsf.excel.ui.validation.UINumericValidation";

   public enum ValidationCondition
   {
      equal, greater_equal, less_equal, less_than, not_equal, between, not_between
   }

   private Double value;
   private Double value2;
   private ValidationCondition condition;

   @Override
   public String getFamily()
   {
      return COMPONENT_TYPE;
   }

   public Double getValue()
   {
      return (Double) valueOf("value", value);
   }

   public void setValue(Double value)
   {
      this.value = value;
   }

   public Double getValue2()
   {
      return (Double) valueOf("value2", value2);
   }

   public void setValue2(Double value2)
   {
      this.value2 = value2;
   }

   public ValidationCondition getCondition()
   {
      return (ValidationCondition) valueOf("condition", condition);
   }

   public void setCondition(ValidationCondition condition)
   {
      this.condition = condition;
   }

   public ValidationType getType()
   {
      return ValidationType.numeric;
   }

}
