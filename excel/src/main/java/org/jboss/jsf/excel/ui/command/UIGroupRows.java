package org.jboss.jsf.excel.ui.command;

import javax.faces.component.FacesComponent;

import org.jboss.jsf.excel.ui.ExcelComponent;

@FacesComponent(
		createTag=true,
		tagName="group-rows",
		namespace="http://jboss.org/jsf/excel",
		value="org.jboss.jsf.excel.ui.command.UIGroupRows")
public class UIGroupRows extends ExcelComponent implements Command
{
   public static final String COMPONENT_TYPE = "org.jboss.jsf.excel.ui.command.UIGroupRows";

   private Integer startRow;
   private Integer endRow;
   private Boolean collapse;

   public Boolean getCollapse()
   {
      return (Boolean) valueOf("collapse", collapse);
   }

   public void setCollapse(Boolean collapse)
   {
      this.collapse = collapse;
   }

   public Integer getStartRow()
   {
      return (Integer) valueOf("startRow", startRow);
   }

   public void setStartRow(Integer startRow)
   {
      this.startRow = startRow;
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

   public CommandType getCommandType()
   {
      return CommandType.group_rows;
   }

}
