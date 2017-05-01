package org.jboss.jsf.excel.ui;

import javax.faces.component.FacesComponent;

import org.jboss.jsf.excel.WorksheetItem;

@FacesComponent(
		createTag=true, 
		tagName="image",
		namespace="http://jboss.org/jsf/excel",
		value="org.jboss.jsf.excel.ui.UIImage")
public class UIImage extends ExcelComponent implements WorksheetItem
{
   public static final String COMPONENT_TYPE = "org.jboss.jsf.excel.ui.UIImage";

   private String URI;
   private Integer startColumn;
   private Integer startRow;
   private Double columnSpan;
   private Double rowSpan;

   public String getURI()
   {
      return (String) valueOf("URI", URI);
   }

   public void setURI(String URI)
   {
      this.URI = URI;
   }

   public Integer getStartRow()
   {
      return (Integer) valueOf("startRow", startRow);
   }

   public void setStartRow(Integer startRow)
   {
      this.startRow = startRow;
   }

   public Integer getStartColumn()
   {
      return (Integer) valueOf("startColumn", startColumn);
   }

   public void setStartColumn(Integer startColumn)
   {
      this.startColumn = startColumn;
   }

   public Double getRowSpan()
   {
      return (Double) valueOf("rowSpan", rowSpan);
   }

   public void setRowSpan(Double rowSpan)
   {
      this.rowSpan = rowSpan;
   }

   public Double getColumnSpan()
   {
      return (Double) valueOf("columnSpan", columnSpan);
   }

   public void setColumnSpan(Double columnSpan)
   {
      this.columnSpan = columnSpan;
   }

   @Override
   public String getFamily()
   {
      return COMPONENT_TYPE;
   }

   public ItemType getItemType()
   {
      return ItemType.image;
   }

   public Integer getColumn() {
       return getStartColumn();
   }

   public Integer getRow() {
       return getStartRow();
   }

   public Object getValue() {
       return getURI();
   }

}
