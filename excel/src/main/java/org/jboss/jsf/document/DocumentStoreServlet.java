package org.jboss.jsf.document;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.jsf.servlet.ContextualHttpServletRequest;
import org.jboss.jsf.web.Parameters;

@SuppressWarnings("serial")
public class DocumentStoreServlet extends HttpServlet
{
 
   @Override
   protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
   {
      new ContextualHttpServletRequest(request)
      {
         @Override
         public void process() throws ServletException, IOException
         {
            doWork(request, response);
         }
      }.run();
   }

   private static void doWork(HttpServletRequest request, HttpServletResponse response) throws IOException
   {
      Parameters params = Parameters.instance();
      String contentId = (String) params.convertMultiValueRequestParameter(params.getRequestParameters(), "docId", String.class);

      DocumentStore store = DocumentStore.instance();

      if (store.idIsValid(contentId))
      {
         DocumentData documentData = store.getDocumentData(contentId);

         response.setContentType(documentData.getDocumentType().getMimeType());
         response.setHeader("Content-Disposition", documentData.getDisposition() + "; filename=\"" + documentData.getFileName() + "\"");

         documentData.writeDataToStream(response.getOutputStream());
      }
      else
      {
         String error = store.getErrorPage();
         if (error != null)
         {
            if (error.startsWith("/"))
            {
               error = request.getContextPath() + error;
            }
            response.sendRedirect(error);
         }
         else
         {
            response.sendError(404);
         }
      }
   }
}
