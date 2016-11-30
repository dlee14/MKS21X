public class ReferenceBook extends LibraryBook {
	String collection;

	public ReferenceBook(String author, String title, String isbn, String callNumber, String collection) {
		super(author, title, isbn, callNumber);
		this.collection = collection;
	}

	public String getCollection() {
		return collection;
	}

	private void getCollection(String collection) {
		this.collection = collection;
	}

	public void checkout(String patron, String due) {
		System.out.println("You cannot check out a reference book.");
	}

	public void returned() {
		System.out.println("Reference book could not have been checked out -- return impossible.");
	}

	public String circulationStatus() {
		return "non-circulating reference book";
	}

	public String toString() {
		return super.toString() + ", " + collection;
	}
}