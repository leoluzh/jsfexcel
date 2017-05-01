package org.jboss.jsf.excel;

import java.util.HashMap;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.jboss.jsf.excel.csv.CsvExcelWorkbook;
import org.jboss.jsf.excel.jxl.JXLExcelWorkbook;
import org.jboss.jsf.excel.util.CdiUtil;

/**
 * Factory to get excel workbook implementation
 * 
 * @author Daniel Roth (danielc.roth@gmail.com)
 * @author Leonardo Luz (leonardo.l.fernandes@gmail.com)
 */

@Named("excelFactory")
@ViewScoped
public class ExcelFactory
{
	
   private static Map<String, Class<? extends ExcelWorkbook>> defaultImplementations;

   private Map<String, Class<? extends ExcelWorkbook>> implementations;

   static
   {
      defaultImplementations = new HashMap<String, Class<? extends ExcelWorkbook>>();
      defaultImplementations.put("csv", CsvExcelWorkbook.class);
      defaultImplementations.put("jxl", JXLExcelWorkbook.class);
   }

   public static ExcelFactory instance()
   {
	   return (ExcelFactory) CdiUtil.getSingleton(ExcelFactory.class);
	   //return (ExcelFactory) Component.getInstance(ExcelFactory.class);
   }

   public ExcelWorkbook getExcelWorkbook(String type)
   {

      Class<? extends ExcelWorkbook> clazz;

      ExcelWorkbook excelWorkbook;

      if (StringUtils.isEmpty(type))
      {
         type = "jxl";
      }

      if (implementations != null && implementations.get(type) != null)
      {
         clazz = implementations.get(type);
      }
      else
      {
         clazz = defaultImplementations.get(type);
      }

      if (clazz == null)
      {
         throw new IllegalArgumentException("Unable to create workbook of type " + type);
      }

      try
      {
         excelWorkbook = clazz.newInstance();
      }
      catch (Exception e)
      {
         throw new IllegalArgumentException("The class provided could not be instanciated " + type, e);
      }

      return excelWorkbook;

   }

   public Map<String, Class<? extends ExcelWorkbook>> getImplementations()
   {
      return implementations;
   }

   public void setImplementations(Map<String, Class<? extends ExcelWorkbook>> implementations)
   {
      this.implementations = implementations;
   }

}