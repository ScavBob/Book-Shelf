package BookShelf.classes.web.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import BookShelf.classes.business.entities.Book;
import BookShelf.classes.business.services.BookRetrieve;

public class HomeController implements IController {

    
    public HomeController() {
        super();
    }
    
    
    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)
            throws Exception {
        
    	final BookRetrieve productService = new BookRetrieve();
    	List<Book> allProducts = productService.findAll();
    	
        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("prods", allProducts);
        
        templateEngine.process("home", ctx, response.getWriter());
    }

}