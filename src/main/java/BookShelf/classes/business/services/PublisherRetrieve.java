package BookShelf.classes.business.services;

import java.util.ArrayList;

import BookShelf.classes.business.entities.Publisher;
import BookShelf.classes.business.entities.repositories.PublisherRepository;

public class PublisherRetrieve {
	public PublisherRetrieve() {
		super();
	}

	public ArrayList<Publisher> findAll(){
		return PublisherRepository.getInstance().findAll();
	}
	
	public Publisher findByTitle(String name){
		return PublisherRepository.getInstance().findByName(name);
	}
}
