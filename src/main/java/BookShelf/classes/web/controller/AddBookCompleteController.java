package BookShelf.classes.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import BookShelf.classes.business.entities.Book;
import BookShelf.classes.business.entities.repositories.BookRepository;
import BookShelf.classes.business.entities.repositories.RepositoryRepository;

public class AddBookCompleteController implements IController {

    
    public AddBookCompleteController() {
        super();
    }
    
    
    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)
            throws Exception {
    	
    	final String title = request.getParameter("authorName.title");
    	final String author = request.getParameter("authorName.author");
    	final String publisher = request.getParameter("authorName.publisher");
    	final String series = request.getParameter("authorName.bookSeries");
    	final Integer isbn = Integer.valueOf(request.getParameter("authorName.title"));
    	System.out.println(title + ", " + author + ", " + publisher + ", " + series + ", " + isbn);
    	final Book book = BookRepository.getInstance().findByTitle(title).get(0);

    	boolean bookAdded = false;
    	if(title != null && title != null && publisher != null && isbn != null) {
    		RepositoryRepository.getInstance().addBook(title, author, publisher, series, isbn);
    		RepositoryRepository.getInstance().addBook(book);
    		bookAdded = true;
    	}
        
        final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("bookAdded", bookAdded);
        
        templateEngine.process("product/addBookComplete", ctx, response.getWriter());
        
    }

}