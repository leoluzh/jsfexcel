package org.jboss.jsf.excel.jxl;

import java.util.HashMap;
import java.util.Map;

import org.jboss.jsf.excel.ui.UICell.CellType;

import jxl.write.WritableCellFormat;

/**
 * A cache for parsed cell info
 * 
 * @author karlsnic
 */
public class CellInfoCache
{
   // A cache for cell types, mapped by UIComponent ID
   private Map<String, CellType> cellDataTypeCache = new HashMap<String, CellType>();

   // A cache for cell formattings, mapped by UIComponent ID
   private Map<String, WritableCellFormat> cellFormatCache = new HashMap<String, WritableCellFormat>();

   public CellType getCachedCellType(String componentId) {
      return cellDataTypeCache.get(componentId);
   }
   
   public void setCachedCellType(String componentId, CellType cellType) {
      cellDataTypeCache.put(componentId, cellType);
   }

   public WritableCellFormat getCachedCellFormat(String componentId) {
      return cellFormatCache.get(componentId);
   }
   
   public void setCachedCellFormat(String componentId, WritableCellFormat cellFormat) {
      cellFormatCache.put(componentId, cellFormat);
   }

}
