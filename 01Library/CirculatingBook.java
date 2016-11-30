public class CirculatingBook extends LibraryBook {
	String currentHolder, dueDate;

	public CirculatingBook(String author, String title, String isbn, String callNumber) {
		super(author, title, isbn, callNumber);
		currentHolder = "";
		dueDate = "";
	}

	private String getCurrentHolder() {
		return currentHolder;
	}

	private String getDueDate() {
		return dueDate;
	}

	private void setCurrentHolder(String currentHolder) {
		this.currentHolder = currentHolder;
	}

	private void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public void checkout(String patron, String due) {
		currentHolder = patron;
		dueDate = due;
	}

	public void returned() {
		currentHolder = "";
		dueDate = "";
	}

	public String circulationStatus() {
		if (currentHolder.equals("")) {
			return "book available on shelves";
		} else {
			return "This book is currently held by " + getCurrentHolder() + ", and it is due " + getDueDate();
		}
	}

	public String toString() {
		if (currentHolder.equals("")) {
			return super.toString();
		} else {
			return super.toString() + ", " + currentHolder + ", " + dueDate;
		}
	}
}