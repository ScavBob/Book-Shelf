package BookShelf.classes.business.entities;

public class Book {
	
	private String title;
	private String author;
	private String bookSeries;
	private String description;
	private int isbn;
	private String publisher;
	
	/**
	 * title, author, publisher, bookSeries, isbn
	 * 
	 * */
	public Book() {
		
	}
	
	public Book(String title, String author, String publisher, String bookSeries, int isbn) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.bookSeries = bookSeries;
		this.isbn = isbn;
		this.description = "No Description Set Yet!";
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setBookSeries(String bookSeries) {
		this.bookSeries = bookSeries;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookSeries() {
		return bookSeries;
	}

	public int getIsbn() {
		return isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	@Override
	public String toString() {
		return "(" + this.title + ", " + this.author + ", " + this.isbn + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if( this.getTitle().toLowerCase().equals(((Book)(obj)).getTitle().toLowerCase()) ) {
			if( ((Book)(obj)).getIsbn() == this.getIsbn()) {
				return true;
			}
			else if (((Book)(obj)).getAuthor().equals(this.getAuthor())) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
}
