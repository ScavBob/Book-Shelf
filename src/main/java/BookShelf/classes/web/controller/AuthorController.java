package BookShelf.classes.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import BookShelf.classes.business.entities.Author;
import BookShelf.classes.business.entities.Book;
import BookShelf.classes.business.services.AuthorRetrieve;

public class AuthorController implements IController {

    
    public AuthorController() {
        super();
    }
    
    
    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)
            throws Exception {

    	final String name = request.getParameter("authorName");    			
    	
    	final AuthorRetrieve retrieve = new AuthorRetrieve();
		final Author author = retrieve.findByTitle(name);
        
        final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("author", author);
        
        templateEngine.process("product/author", ctx, response.getWriter());
        
    }

}