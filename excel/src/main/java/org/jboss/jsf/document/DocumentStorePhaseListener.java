package org.jboss.jsf.document;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;


import org.jboss.jsf.web.Parameters;

public class DocumentStorePhaseListener implements PhaseListener
{
   private static final long serialVersionUID = 7308251684939658978L;

   private static final Logger log = Logger.getLogger(DocumentStorePhaseListener.class.getName());

   public PhaseId getPhaseId()
   {
      return PhaseId.RENDER_RESPONSE;
   }

   public void afterPhase(PhaseEvent phaseEvent)
   {
      // ...
   }

   public void beforePhase(PhaseEvent phaseEvent)
   {
	  
	  String rootId = phaseEvent.getFacesContext().getViewRoot().getViewId();
      //String rootId = Pages.getViewId(phaseEvent.getFacesContext());

      Parameters params = Parameters.instance();
      String id = (String) params.convertMultiValueRequestParameter(params.getRequestParameters(), "docId", String.class);
      if (rootId.contains(DocumentStore.DOCSTORE_BASE_URL))
      {
         sendContent(phaseEvent.getFacesContext(), id);
      }
   }

   public void sendContent(FacesContext context, String contentId)
   {
      try
      {
         DocumentData documentData = DocumentStore.instance().getDocumentData(contentId);

         if (documentData != null)
         {

            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.setContentType(documentData.getDocumentType().getMimeType());

            response.setHeader("Content-Disposition", documentData.getDisposition() + "; filename=\"" + documentData.getFileName() + "\"");

            documentData.writeDataToStream(response.getOutputStream());
            context.responseComplete();
         }
      }
      catch (IOException e)
      {
    	 log.log(Level.WARNING,e.getMessage(), e);
      }
   }

}
