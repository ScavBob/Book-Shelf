package BookShelf.classes.business.entities;

import java.util.ArrayList;

public class Publisher {
	
	private ArrayList<Book> books;
	private String name;
	private String description;
	
	public Publisher(String name){
		super();
		books = new ArrayList<Book>();
		this.name = name;
		description = "Not Yet Set!";
	}
	
	public ArrayList<Book> getBooks() {
		return books;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean addBook(Book b) {
		if(b == null)
			return false;
		if(!b.getPublisher().equals(this.name))
			return false;
		if(books.contains(b))
			return false;
		books.add(b);
		order();
		return true;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return "(" + this.name + ")";
	}

	public void setDescription(String description) {
		if(description != null)
			this.description = description;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.getName().toLowerCase().equals( ((Publisher)obj).getName().toLowerCase() ))
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
