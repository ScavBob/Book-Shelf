package BookShelf.classes.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import BookShelf.classes.business.entities.Book;
import BookShelf.classes.business.services.BookRetrieve;

public class BookController implements IController {

    
    public BookController() {
        super();
    }
    
    
    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)
            throws Exception {

    	final String title = String.valueOf(request.getParameter("bookTitle"));
    	
    	final BookRetrieve retrieve = new BookRetrieve();
    	final Book book = retrieve.findByTitle(title).get(0);
        
        final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("book", book);
        
        templateEngine.process("product/book", ctx, response.getWriter());
        
    }

}