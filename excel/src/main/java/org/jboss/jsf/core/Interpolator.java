package org.jboss.jsf.core;


import java.text.MessageFormat;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.jboss.jsf.excel.util.CdiUtil;


/**
 * Interpolates EL expressions in Strings
 * 
 * @author Gavin King
 */

@Named("org.jboss.seam.core.interpolator")
@RequestScoped
public class Interpolator
{
   
   private static final Logger log = Logger.getLogger(Interpolator.class.getName());
   
   public static Interpolator instance()
   {
	  return CdiUtil.getInstance(Interpolator.class); 
   }
   
   /**
    * Replace all EL expressions in the form #{...} with their evaluated values.
    * 
    * @param string
    *           a template
    * @return the interpolated string
    */
   public String interpolate(String string, Object... params)
   {
      if (params == null)
      {
         params = new Object[0];
      }
      
      if (params.length > 10)
      {
         throw new IllegalArgumentException("more than 10 parameters");
      }
      
      if (string.indexOf('#') >= 0 || string.indexOf('{') >= 0)
      {
         string = interpolateExpressions(string, params);
      }
      
      return string;
   }
   
   private String interpolateExpressions(String string, Object... params)
   {
      StringTokenizer tokens = new StringTokenizer(string, "#{}", true);
      StringBuilder builder = new StringBuilder(string.length());
      
      while (tokens.hasMoreTokens())
      {
         String tok = tokens.nextToken();
         
         if ("#".equals(tok) && tokens.hasMoreTokens())
         {
            String nextTok = tokens.nextToken();
            
            while (nextTok.equals("#") && tokens.hasMoreTokens())
            {
               builder.append(tok);
               nextTok = tokens.nextToken();
            }
            
            if ("{".equals(nextTok))
            {
               String expression = "#{" + tokens.nextToken() + "}";
               try
               {
                  Object value = Expressions.instance().createValueExpression(expression).getValue();
                  if (value != null)
                     builder.append(value);
               }
               catch (Exception e)
               {
                  log.log(Level.INFO,"exception interpolating string: " + string, e);
               }
               tokens.nextToken(); // the trailing "}"
               
            }
            else if (nextTok.equals("#"))
            {
               // could be trailing #
               builder.append("#");
               
            }
            else
            {
               int index;
               try
               {
                  index = Integer.parseInt(nextTok.substring(0, 1));
                  if (index >= params.length)
                  {
                     // log.warn("parameter index out of bounds: " + index +
                     // " in: " + string);
                     builder.append("#").append(nextTok);
                  }
                  else
                  {
                     builder.append(params[index]).append(nextTok.substring(1));
                  }
               }
               catch (NumberFormatException nfe)
               {
                  builder.append("#").append(nextTok);
               }
            }
         }
         else if ("{".equals(tok))
         {
            StringBuilder expr = new StringBuilder();
            
            expr.append(tok);
            int level = 1;
            
            while (tokens.hasMoreTokens())
            {
               String nextTok = tokens.nextToken();
               expr.append(nextTok);
               
               if (nextTok.equals("{"))
               {
                  ++level;
               }
               else if (nextTok.equals("}"))
               {
                  if (--level == 0)
                  {
                     try
                     {
                        if (params.length == 0)
                        {
                           builder.append(expr.toString());
                        }
                        else
                        {
                           String value = new MessageFormat(expr.toString(), Locale.getDefault() ).format(params);
                           builder.append(value);
                        }
                     }
                     catch (Exception e)
                     {
                        // if it is a bad message, use the expression itself
                        builder.append(expr);
                     }
                     expr = null;
                     break;
                  }
               }
            }
            
            if (expr != null)
            {
               builder.append(expr);
            }
         }
         else
         {
            builder.append(tok);
         }
      }
      
      return builder.toString();
   }
   
}
