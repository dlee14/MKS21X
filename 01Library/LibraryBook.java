abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
	String callNumber;

	public LibraryBook(String author, String title, String isbn, String callNumber) {
		super(author, title, isbn);
		this.callNumber = callNumber;
	}

	public String getCallNumber() {
		return callNumber;
	}

	private void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	abstract void checkout(String patron, String due);

	abstract void returned();

	abstract String circulationStatus();

	public int compareTo(LibraryBook book) {
		return 0;
	}

	public String toString() {
		return super.toString() + ", " +circulationStatus() + ", " + callNumber;
	}
}