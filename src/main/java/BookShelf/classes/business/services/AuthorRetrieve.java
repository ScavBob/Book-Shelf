package BookShelf.classes.business.services;

import java.util.ArrayList;

import BookShelf.classes.business.entities.Author;
import BookShelf.classes.business.entities.repositories.RepositoryRepository;

public class AuthorRetrieve {
	
	public AuthorRetrieve() {
		super();
	}

	public ArrayList<Author> findAll(){
		return RepositoryRepository.ar.findAll();
	}
	
	public Author findByTitle(String name){
		return RepositoryRepository.ar.findByName(name);
	}
}
