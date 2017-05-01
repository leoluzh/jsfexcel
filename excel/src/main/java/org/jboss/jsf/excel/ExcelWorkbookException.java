package org.jboss.jsf.excel;

/**
 * Encapsulate errors occuring in excel workbook generation
 * 
 * @author Nicklas Karlsson (nickarls@gmail.com)
 * @author Daniel Roth (danielc.roth@gmail.com)
 * 
 */

@SuppressWarnings("serial")
public class ExcelWorkbookException extends RuntimeException
{

  
   public ExcelWorkbookException()
   {

      super();
   }

   public ExcelWorkbookException(String message)
   {
      super(message);

   }

   public ExcelWorkbookException(String message, Throwable t)
   {
      super(message, t);

   }

   public ExcelWorkbookException(Throwable t)
   {
      super(t);

   }

}
