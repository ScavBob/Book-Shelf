package BookShelf.classes.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import BookShelf.classes.business.entities.Publisher;
import BookShelf.classes.business.services.PublisherRetrieve;

public class PublisherController implements IController {

    
    public PublisherController() {
        super();
    }
    
    
    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)
            throws Exception {

    	final String name = String.valueOf(request.getParameter("publisherName"));
    	
    	final PublisherRetrieve retrieve = new PublisherRetrieve();
		final Publisher publisher = retrieve.findByTitle(name);
        
        final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("publisher", publisher);
        
        templateEngine.process("product/publisher", ctx, response.getWriter());
        
    }

}