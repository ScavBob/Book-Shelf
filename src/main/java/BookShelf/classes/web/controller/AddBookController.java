package BookShelf.classes.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import BookShelf.classes.business.entities.Book;

public class AddBookController implements IController {

    
    public AddBookController() {
        super();
    }
    
    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)
            throws Exception {
    	
    	Book book = new Book();
        final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("book", book);
        
        templateEngine.process("product/addBook", ctx, response.getWriter());
        
    }

}