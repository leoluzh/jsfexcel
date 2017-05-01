package org.jboss.jsf.excel.ui.validation;

import javax.faces.component.FacesComponent;

import org.jboss.jsf.excel.ui.ExcelComponent;

@FacesComponent(
		createTag=true,
		tagName="range-validation",
		namespace="http://jboss.org/jsf/excel",
		value="org.jboss.jsf.ui.validation.UIRangeValidation")
public class UIRangeValidation extends ExcelComponent implements Validation
{
   public static final String COMPONENT_TYPE = "org.jboss.jsf.excel.ui.validation.UIRangeValidation";

   private Integer startColumn;
   private Integer startRow;
   private Integer endColumn;
   private Integer endRow;

   public Integer getStartColumn()
   {
      return (Integer) valueOf("startColumn", startColumn);
   }

   public void setStartColumn(Integer startColumn)
   {
      this.startColumn = startColumn;
   }

   public Integer getStartRow()
   {
      return (Integer) valueOf("startRow", startRow);
   }

   public void setStartRow(Integer startRow)
   {
      this.startRow = startRow;
   }

   public Integer getEndColumn()
   {
      return (Integer) valueOf("endColumn", endColumn);
   }

   public void setEndColumn(Integer endColumn)
   {
      this.endColumn = endColumn;
   }

   public Integer getEndRow()
   {
      return (Integer) valueOf("endRow", endRow);
   }

   public void setEndRow(Integer endRow)
   {
      this.endRow = endRow;
   }

   @Override
   public String getFamily()
   {
      return COMPONENT_TYPE;
   }

   public ValidationType getType()
   {
      return ValidationType.range;
   }
}
