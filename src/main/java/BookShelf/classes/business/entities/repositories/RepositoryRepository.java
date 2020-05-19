package BookShelf.classes.business.entities.repositories;
import BookShelf.classes.business.entities.Author;
import BookShelf.classes.business.entities.Book;
import BookShelf.classes.business.entities.Publisher;

public class RepositoryRepository {
	private static RepositoryRepository INSTANCE = new RepositoryRepository();
	public static BookRepository br;
	public static AuthorRepository ar;
	public static PublisherRepository pr;	

	public RepositoryRepository(){		
		br = BookRepository.getInstance();
		ar = AuthorRepository.getInstance();
		pr = PublisherRepository.getInstance();
		Book b1 = new Book("Lucky Jim", "Kingsley Amis", "Self-Published", "a book series", 1);
		Book b2 = new Book("Money", "Martin Amis", "Self-Published", "a book series", 2);
		Book b3 = new Book("The Information", "Martin Amis", "Self-Published", "a book series", 3);
		Book b4 = new Book("The Bottle Factory Outing", "Beryl Bainbridge", "Self-Published", "a book series", 4);
		Book b5 = new Book("According to Queeney", "Beryl Bainbridge", "Self-Published", "a book series", 5);
		Book b6 = new Book("Flauberts Parrot", "Julian Barnes", "Self-Published", "a book series", 6);
		Book b7 = new Book("A History of the World in 10 1/2 Chapters", "Julian Barnes", "Self-Published", "a book series", 7);
		Book b8 = new Book("Augustus Carp, Esq. by Himself: Being the Autobiography of a Really Good Man", "Henry Howarth Bashford", "Self-Published", "a book series", 8);
		Book b9 = new Book("Molloy", "Samuel Beckett", "Self-Published", "a book series", 9);
		Book b10 = new Book("Zuleika Dobson", "Max Beerbohm", "Self-Published", "a book series", 10);
		Book b11 = new Book("The Adventures of Augie March", "Saul Bellow", "Self-Published", "a book series", 11);
		Book b12 = new Book("The Uncommon Reader", "Alan Bennett", "Self-Published", "a book series", 12);
		Book b13 = new Book("Queen Lucia", "EF Benson", "Self-Published", "a book series", 13);
		Book b14 = new Book("The Ascent of Rum Doodle", "WE Bowman", "Self-Published", "a book series", 14);
		Book b15 = new Book("A Good Man in Africa", "William Boyd", "Self-Published", "a book series", 15);
		Book b16 = new Book("The History Man", "Malcolm Bradbury", "Self-Published", "a book series", 16);
		Book b17 = new Book("No Bed for Bacon", "Caryl Brahms and SJ Simon", "Self-Published", "a book series", 17);
		Book b18 = new Book("Illywhacker", "Peter Carey", "Self-Published", "a book series", 18);
		Book b19 = new Book("A Season in Sinji", "JL Carr", "Self-Published", "a book series", 19);
		Book b20 = new Book("The Harpole Report", "JL Carr", "Self-Published", "a book series", 20);
		Book b21 = new Book("The Hearing Trumpet", "Leonora Carrington", "Self-Published", "a book series", 21);
		Book b22 = new Book("Mister Johnson", "Joyce Cary", "Self-Published", "a book series", 22);
		Book b23 = new Book("The Horses Mouth", "Joyce Cary", "Self-Published", "a book series", 23);
		Book b24 = new Book("Don Quixote", "Miguel de Cervantes", "Self-Published", "a book series", 24);
		Book b25 = new Book("The Case of the Gilded Fly", "Edmund Crispin", "Self-Published", "a book series", 25);
		Book b26 = new Book("Just William", "Richmal Crompton", "Self-Published", "a book series", 26);
		Book b27 = new Book("The Provincial Lady", "EM Delafield", "Self-Published", "a book series", 27);
		Book b28 = new Book("Slouching Towards Kalamazoo", "Peter De Vries", "Self-Published", "a book series", 28);
		Book b29 = new Book("The Pickwick Papers", "Charles Dickens", "Self-Published", "a book series", 29);
		Book b30 = new Book("Martin Chuzzlewit", "Charles Dickens", "Self-Published", "a book series", 30);
		Book b31 = new Book("Jacques the Fatalist and his Master", "Denis Diderot", "Self-Published", "a book series", 31);
		
		this.addBook(b1);
		this.addBook(b2);
		this.addBook(b3);
		this.addBook(b4);
		this.addBook(b5);
		this.addBook(b6);
		this.addBook(b7);
		this.addBook(b8);
		this.addBook(b9);
		this.addBook(b10);
		this.addBook(b11);
		this.addBook(b12);
		this.addBook(b13);
		this.addBook(b14);
		this.addBook(b15);
		this.addBook(b16);
		this.addBook(b17);
		this.addBook(b18);
		this.addBook(b19);
		this.addBook(b20);
		this.addBook(b21);
		this.addBook(b22);
		this.addBook(b23);
		this.addBook(b24);
		this.addBook(b25);
		this.addBook(b26);
		this.addBook(b27);
		this.addBook(b28);
		this.addBook(b29);
		this.addBook(b30);
		this.addBook(b31);
		
		b31.setDescription("Hello");
	}	

	public static RepositoryRepository getInstance(){

		return INSTANCE;	
	}	

	public void addBook(Book b) {
		addBook(b.getTitle(), b.getAuthor(), b.getPublisher(), b.getBookSeries(), b.getIsbn());
	}
	
	public void addBook(String Title, String Author, String Publisher, String BookSeries, int isbn) {
		if(BookRepository.getInstance().findByTitle(Title) == null)
			BookRepository.getInstance().addBook(new Book(Title, Author, Publisher, BookSeries, isbn));
		if(PublisherRepository.getInstance().findByName(Publisher) == null)
			PublisherRepository.getInstance().addPublisher(new Publisher(Publisher));
			PublisherRepository.getInstance().findByName(Publisher).addBook(new Book(Title, Author, Publisher, BookSeries, isbn));
		if(AuthorRepository.getInstance().findByName(Author) == null)
			AuthorRepository.getInstance().addAuthor(new Author(Author));
			AuthorRepository.getInstance().findByName(Author).addBook(new Book(Title, Author, Publisher, BookSeries, isbn));
	}
}