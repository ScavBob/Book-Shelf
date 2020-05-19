
package BookShelf.classes.business.entities.repositories;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import BookShelf.classes.business.entities.Author;

public class AuthorRepository {
	private static AuthorRepository INSTANCE = new AuthorRepository();
	private Map<String, Author> authorByName;
	
	public AuthorRepository() {
		super();
		authorByName = new HashMap<String, Author>();
	}
	
	public static AuthorRepository getInstance() {
		return INSTANCE;
	}
	
	public void addAuthor(Author a) {
		this.authorByName.put(a.getName(), a);
	}
	
	public ArrayList<Author> findAll(){
		return new ArrayList<Author>(this.authorByName.values());
	}
	
	public Author findByName(String name){
		return this.authorByName.get(name);
	}
	
}
