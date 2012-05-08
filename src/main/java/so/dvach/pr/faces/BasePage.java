
package so.dvach.pr.faces;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BasePage  implements Serializable {

    protected FacesContext facesContext;
    protected Locale currentLocale = Locale.getDefault();

    protected boolean isValid(String input) {
    	return input!=null && input.trim().length()>0;
    }
    
    
      
  
    
    protected void addMessage(String text) {
        // JSF Success Messages won't live past a redirect, so it's not used
        // FacesUtils.addInfoMessage(formatMessage(key, arg));
        List messages = (List) getSession().getAttribute("messages");

        if (messages == null) {
            messages = new ArrayList();
        }

        messages.add(text);
        getSession().setAttribute("messages", messages);
    }

    protected void addError(String text, Object arg) {
        // The "JSF Way" doesn't allow you to put HTML in your error messages, so I don't use it.
        // FacesUtils.addErrorMessage(formatMessage(key, arg));
        List errors = (List) getSession().getAttribute("errors");

        if (errors == null) {
            errors = new ArrayList();
        }

        errors.add(text);
       
        getSession().setAttribute("errors", errors);
    }

    protected void addError(String key) {
        addError(key, null);
    }

    /**
     * Convenience method for unit tests.
     *
     * @return boolean indicator of an "errors" attribute in the session
     */
    public boolean hasErrors() {
        return (getSession().getAttribute("errors") != null);
    }

    /**
     * Servlet API Convenience method
     *
     * @return HttpServletRequest from the FacesContext
     */
    public HttpServletRequest getRequest() {
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
    }

    /**
     * Servlet API Convenience method
     *
     * @return the current user's session
     */
    protected HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * Servlet API Convenience method
     *
     * @return HttpServletResponse from the FacesContext
     */
    protected HttpServletResponse getResponse() {
        return (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
    }

    /**
     * Servlet API Convenience method
     *
     * @return the ServletContext form the FacesContext
     */
    public ServletContext getServletContext() {
        return (ServletContext) getFacesContext().getExternalContext().getContext();
    }

    public void redirect404() {
        redirect(getRequest().getContextPath() + "/404.jsp");
    }

    public void redirect403() {
        redirect(getRequest().getContextPath() + "/403.jsp");
    }

    public void redirect(String page) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(page);
        } catch (IOException ex) {
            //getLogger().error(ex.getLocalizedMessage(),ex);
        }
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
