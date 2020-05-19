package BookShelf.classes.business.services;

import java.util.ArrayList;

import BookShelf.classes.business.entities.Book;
import BookShelf.classes.business.entities.repositories.RepositoryRepository;

public class BookRetrieve {
	public BookRetrieve(){
		super();
	}
	
	public ArrayList<Book> findAll(){
		return RepositoryRepository.br.findAll();
	}
	
	public ArrayList<Book> findByTitle(String title){
		return RepositoryRepository.br.findByTitle(title);
	}
}
