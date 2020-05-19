package BookShelf.classes.business.entities;

import java.util.ArrayList;

import BookShelf.classes.business.entities.repositories.AuthorRepository;
import BookShelf.classes.business.entities.repositories.BookRepository;
import BookShelf.classes.business.entities.repositories.PublisherRepository;

public class driver {

	public static void main(String[] args) {
		Author a = new Author("Cankat");
		Book b  = new Book("Cankat Kitap", "Cankat", "Self-published", "", 4151516);
		Publisher p = new Publisher("Self-published");
		addBook(b, a, p);
		
		Author a1 = new Author("Cankat 1");
		Book b1  = new Book("Cankat Kitap", "Cankat 1", "Self-published", "", 415515510);
		Publisher p1 = new Publisher("Self-published");
		addBook(b1, a1, p1);
		ArrayList<Book> arr = BookRepository.getInstance().findByTitle("Cankat Kitap");
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		System.out.println(AuthorRepository.getInstance().findAll().toString());
		System.out.println(PublisherRepository.getInstance().findAll().toString());
	}
	public static boolean addBook(Book b, Author a, Publisher p) {
		if( b.getTitle() == null || a.getName() == null || p.getName() == null  )
			return false;
		if(!b.getAuthor().equals(a.getName()))
			return false;
		if(!b.getPublisher().equals(p.getName()))
			return false;
		
		BookRepository.getInstance().addBook(b);
		AuthorRepository.getInstance().addAuthor(a);
		a.addBook(b);
		PublisherRepository.getInstance().addPublisher(p);
		p.addBook(b);
		return true;
	}
}
