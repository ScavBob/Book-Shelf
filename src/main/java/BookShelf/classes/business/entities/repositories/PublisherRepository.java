package BookShelf.classes.business.entities.repositories;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import BookShelf.classes.business.entities.Publisher;

public class PublisherRepository {
	private static PublisherRepository INSTANCE = new PublisherRepository();
	private Map<String, Publisher> publisherByName;
	
	public PublisherRepository() {
		super();
		publisherByName = new HashMap<String, Publisher>();
	}
	
	public static PublisherRepository getInstance() {
		return INSTANCE;
	}
	
	public void addPublisher(Publisher p) {
		this.publisherByName.put(p.getName(), p);
	}
	
	public ArrayList<Publisher> findAll(){
		return new ArrayList<Publisher>(this.publisherByName.values());
	}
	
	public Publisher findByName(String name){
		return this.publisherByName.get(name);
	}
	
}
