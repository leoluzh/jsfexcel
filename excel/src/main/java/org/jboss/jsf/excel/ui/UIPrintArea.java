package org.jboss.jsf.excel.ui;

import javax.faces.component.FacesComponent;

@FacesComponent(
		createTag=true,
		tagName="print-area",
		namespace="http://jboss.org/jsf/excel",
		value="org.jboss.jsf.excel.ui.UIPrintArea")
public class UIPrintArea extends ExcelComponent
{
   public static final String COMPONENT_TYPE = "org.jboss.jsf.excel.ui.UIPrintArea";

   private Integer firstColumn;
   private Integer firstRow;
   private Integer lastColumn;
   private Integer lastRow;

   public Integer getFirstColumn()
   {
      return (Integer) valueOf("firstColumn", firstColumn);

   }

   public void setFirstColumn(Integer firstColumn)
   {
      this.firstColumn = firstColumn;
   }

   public Integer getFirstRow()
   {
      return (Integer) valueOf("firstRow", firstRow);
   }

   public void setFirstRow(Integer firstRow)
   {
      this.firstRow = firstRow;
   }

   public Integer getLastColumn()
   {
      return (Integer) valueOf("lastColumn", lastColumn);
   }

   public void setLastColumn(Integer lastColumn)
   {
      this.lastColumn = lastColumn;
   }

   public Integer getLastRow()
   {
      return (Integer) valueOf("lastRow", lastRow);
   }

   public void setLastRow(Integer lastRow)
   {
      this.lastRow = lastRow;
   }

   @Override
   public String getFamily()
   {
      return COMPONENT_TYPE;
   }

}
