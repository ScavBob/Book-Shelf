package BookShelf.classes.business.entities.repositories;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import BookShelf.classes.business.entities.Book;

public class BookRepository {
	private static BookRepository INSTANCE = new BookRepository();
	private Map<String, ArrayList<Book>> booksByTitle;
	
	public BookRepository() {
		super();
		booksByTitle = new HashMap<String, ArrayList<Book>>();
				// AFTER THIS PART IS FOR EXAMPLE
		/*Book b1 = new Book("Lucky Jim", "Kingsley Amis", "Self-Published", "a book series", 1);
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
		this.addBook(b31);*/
	}
	
	public static BookRepository getInstance() {
		return INSTANCE;
	}
	
	public void addBook(Book b) {
		if(this.booksByTitle.get(b.getTitle()) != null) {
			if(!booksByTitle.get(b.getTitle()).contains(b))
				this.booksByTitle.get(b.getTitle()).add(b);
		}
		else {
			ArrayList<Book> a = new ArrayList<Book>();
			a.add(b);
			this.booksByTitle.put(b.getTitle(), a);
		}
	}
	
	public void order(ArrayList<Book> arr) {
		for(int i = 0; i < arr.size() - 1; i++) {
			int index = i;
			for(int j = i + 1; j < arr.size(); j++) {
				if(arr.get(j).getTitle().compareTo(arr.get(index).getTitle()) < 0) {
					index = j;
				}
			}
			Book smallerBook = arr.get(index);
			arr.set(index, arr.get(i));
			arr.set(i, smallerBook);
		}
	}
	
	public ArrayList<Book> findAll(){
		ArrayList<Book> arr = new ArrayList<Book>();
		for(Map.Entry<String, ArrayList<Book>> entry : booksByTitle.entrySet())
			for(int i = 0; i < entry.getValue().size(); i++)
				arr.add(entry.getValue().get(i));
		order(arr);
		return arr;
	}
	
	public ArrayList<Book> findByTitle(String Title){
		return this.booksByTitle.get(Title);
	}
	
	public static void main(String args[]) {
		Book b  = new Book("Cankat Kitap", "Cankat", "Self-published", "", 4151516);
		Book b1  = new Book("Cankat Kitap", "Cankat 1", "Self-published", "", 415515510);
		BookRepository.getInstance().addBook(b);
		BookRepository.getInstance().addBook(b1);
		
		Iterator it = BookRepository.getInstance().booksByTitle.entrySet().iterator();
		System.out.println(it.hasNext());
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
		 	System.out.println(pair.getKey() + " = " + pair.getValue());
		 	it.remove(); // avoids a ConcurrentModificationException
	    }
	}
}
