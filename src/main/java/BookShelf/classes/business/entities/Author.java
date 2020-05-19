package BookShelf.classes.business.entities;
import java.util.ArrayList;


public class Author 
{
	private String name;
	private ArrayList<Book> books;
	private String description;
	
	public Author(String name) {
		super();
		books = new ArrayList<Book>();
		this.name = name;
		this.description = "Description Not Yet Set!";
	}

	public boolean addBook(Book book) {
		if(book == null)
			return false;
		if(!book.getAuthor().equals(this.name)) {
			return false;
		}
		if(books.contains(book))
			return false;
		books.add(book);
		order();
		return true;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(description != null)
			this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.getName().toLowerCase().equals( ((Author)obj).getName().toLowerCase() ))
			return true;
		return false;
	}
	
	public void order() {
		for(int i = 0; i < books.size() - 1; i++) {
			int index = i;
			for(int j = i + 1; j < books.size(); j++) {
				if(books.get(j).getTitle().compareTo(books.get(index).getTitle()) < 0) {
					index = j;
				}
			}
			Book smallerBook = books.get(index);
			books.set(index, books.get(i));
			books.set(i, smallerBook);
		}
	}
}
