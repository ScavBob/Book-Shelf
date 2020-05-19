package BookShelf.classes.web.application;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import BookShelf.classes.web.controller.AddBookCompleteController;
import BookShelf.classes.web.controller.AddBookController;
import BookShelf.classes.web.controller.AuthorController;
import BookShelf.classes.web.controller.BookController;
import BookShelf.classes.web.controller.BookListController;
import BookShelf.classes.web.controller.EditAuthorController;
import BookShelf.classes.web.controller.EditBookController;
import BookShelf.classes.web.controller.HomeController;
import BookShelf.classes.web.controller.IController;
import BookShelf.classes.web.controller.PublisherController;


public class Application {


    private TemplateEngine templateEngine;
    private Map<String, IController> controllersByURL;

    
    
    public Application(final ServletContext servletContext) {

        super();

        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        
        // HTML is the default mode, but we will set it anyway for better understanding of code
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // This will convert "home" to "/WEB-INF/templates/home.html"
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        // Set template cache TTL to 1 hour. If not set, entries would live in cache until expelled by LRU
        templateResolver.setCacheTTLMs(Long.valueOf(3600000L));
        
        // Cache is set to true by default. Set to false if you want templates to
        // be automatically updated when modified.
        templateResolver.setCacheable(false);

        this.templateEngine = new TemplateEngine();
        this.templateEngine.setTemplateResolver(templateResolver);

        this.controllersByURL = new HashMap<String, IController>();
        this.controllersByURL.put("/", new HomeController());
        this.controllersByURL.put("/publisher", new PublisherController());
        this.controllersByURL.put("/author", new AuthorController());
        this.controllersByURL.put("/book", new BookController());
        this.controllersByURL.put("/product/editAuthor", new EditBookController());
        this.controllersByURL.put("/product/editBook", new EditAuthorController());
        this.controllersByURL.put("/product/addBook", new AddBookController());
        this.controllersByURL.put("/product/addBookComplete", new AddBookCompleteController());
        this.controllersByURL.put("/product/list", new BookListController());

    }

    
    public IController resolveControllerForRequest(final HttpServletRequest request) {
        final String path = getRequestPath(request);
        return this.controllersByURL.get(path);
    }
    
    
    public ITemplateEngine getTemplateEngine() {
        return this.templateEngine;
    }

    
    
    private static String getRequestPath(final HttpServletRequest request) {
        
        String requestURI = request.getRequestURI();
        final String contextPath = request.getContextPath();
        
        final int fragmentIndex = requestURI.indexOf(';'); 
        if (fragmentIndex != -1) {
            requestURI = requestURI.substring(0, fragmentIndex);
        }
        
        if (requestURI.startsWith(contextPath)) {
            return requestURI.substring(contextPath.length());
        }
        return requestURI;
    }
    

}
