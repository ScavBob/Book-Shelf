package BookShelf.classes.web.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import BookShelf.classes.business.entities.Book;
import BookShelf.classes.business.services.BookRetrieve;

@Controller
public class BookListController implements IController {


    public BookListController() {
        super();
    }
    
        @RequestMapping(value = "list", method = RequestMethod.GET)
        public String findBooks(@RequestParam (value = "search", required = false) String title, Model model) {
        	BookRetrieve bookService = new BookRetrieve();
            model.addAttribute("search", bookService.findByTitle(title));
            System.out.println("Here boss: " + title);
            return "list";
        }
        
    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)
            throws Exception {
    	
    	final String title = String.valueOf(request.getParameter("bookTitle"));
    	final BookRetrieve bookService = new BookRetrieve();
    	List<Book> allBooks;
    	System.out.println(title);
    	if(title != "null") {
    		allBooks = bookService.findByTitle(title);
    	}else {
    	allBooks = bookService.findAll();
        }
        final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("prods", allBooks);

        templateEngine.process("product/list", ctx, response.getWriter());
    }
}
