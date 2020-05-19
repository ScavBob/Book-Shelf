package BookShelf.classes.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import BookShelf.classes.business.entities.Author;
import BookShelf.classes.business.services.AuthorRetrieve;

public class EditAuthorController implements IController {

    
    public EditAuthorController() {
        super();
    }
    
    
    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)
            throws Exception {

    	final String name = String.valueOf(request.getParameter("author"));
    	System.out.println(name);
    	final AuthorRetrieve retrieve = new AuthorRetrieve();
    	final Author author = retrieve.findByTitle(name);
        
        final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("author", author);
        
        templateEngine.process("product/editAuthor", ctx, response.getWriter());
    }

}