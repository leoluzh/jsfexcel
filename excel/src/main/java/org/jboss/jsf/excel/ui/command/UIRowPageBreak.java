package org.jboss.jsf.excel.ui.command;

import javax.faces.component.FacesComponent;

import org.jboss.jsf.excel.ui.ExcelComponent;

@FacesComponent(createTag=true,
				tagName="row-page-break",
				namespace="http://jboss.org/jsf/excel",
				value="org.jboss.jsf.excel.ui.command.UIRowPageBreak")
public class UIRowPageBreak extends ExcelComponent implements Command
{
   public static final String COMPONENT_TYPE = "org.jboss.jsf.excel.ui.command.UIRowPageBreak";

   private Integer row;

   public Integer getRow()
   {
      return (Integer) valueOf("row", row);
   }

   public void setRow(Integer row)
   {
      this.row = row;
   }

   public CommandType getCommandType()
   {
      return CommandType.add_row_pagebreak;
   }

   @Override
   public String getFamily()
   {
      return COMPONENT_TYPE;
   }

}
