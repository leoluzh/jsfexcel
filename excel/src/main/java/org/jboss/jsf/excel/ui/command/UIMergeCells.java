package org.jboss.jsf.excel.ui.command;

import javax.faces.component.FacesComponent;

import org.jboss.jsf.excel.ui.ExcelComponent;

@FacesComponent(
		createTag=true,
		tagName="merge-cells",
		namespace="http://jboss.org/jsf/excel",
		value="org.jboss.jsf.excel.ui.command.UIMergeCells")
public class UIMergeCells extends ExcelComponent implements Command
{
   public static final String COMPONENT_TYPE = "org.jboss.jsf.excel.ui.command.UIMergeCells";

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

   public CommandType getCommandType()
   {
      return CommandType.merge_cells;
   }

}
